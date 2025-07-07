package eu.work.recipeapp

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable


@Composable
fun RecipeApp(navController : NavHostController){
    val recipeViewModel : MainViewModel = viewModel()
    val viewstate by recipeViewModel.categoriesState                                                //“Create a read-only variable called viewstate that always reflects the current value of recipeViewModel.categoriesState.
                                                                                                                             // If the ViewModel updates it, viewState automatically updates.”
    NavHost(navController = navController, startDestination = Screen.RecipeScreen.route){
        composable(Screen.RecipeScreen.route){                              // composable(Screen.RecipeScreen.route) registers the screen for navigation.If the user is currently on the recipe_screen route, build and show the UI from RecipeScreen() and give it the data and navigation logic it needs.”
                                                                                                                              // When this route is active, the code inside { ... } runs and displays that screen.
            RecipeScreen(
                viewstate = viewstate,
                navigateToDetail = {

                    navController.currentBackStackEntry?.savedStateHandle?.set("jacob", it)
                    navController.navigate(Screen.DetailScreen.route)
                })
        }
        composable (Screen.DetailScreen.route){
            val category =navController.previousBackStackEntry?.savedStateHandle?.
                    get<Category>("jacob") ?: Category("","","","")
            CategoryDetailScreen(category = category)
        }

    }
}


/*

navController	Your NavController managing screen navigation.

currentBackStackEntry	The currently visible screen (or the top of the navigation stack).

?.	Safe call — ensures null safety.

savedStateHandle	A key-value store attached to the current screen. Used to store temporary state that survives process death or back-navigation. 🔄 Example Scenario:
                    🔸 You’re on Screen A.
                    You navigate to Screen B to select something (e.g., a category).

                    🔸 After user selects a category,
                    You go back to Screen A and want to send the selected value.

.set("jacob", it)	Saves the value it under the key "jacob".

*/
