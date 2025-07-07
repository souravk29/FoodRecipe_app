
package eu.work.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import org.w3c.dom.Text


/*    Since we have setup the ViewModel we must be utilizing it in UI         */



@Composable
fun RecipeScreen(modifier: Modifier = Modifier,
                 viewstate: MainViewModel.RecipeState,
                 navigateToDetail: (Category) -> Unit)
{

    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.loading_anim) // make sure you have this JSON in res/raw
    )


    Box(modifier = Modifier.fillMaxSize().padding(45.dp)) {

        when {
            viewstate.loading -> {

                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(250.dp)
                )
            }

            viewstate.error != null -> {
                Text("ERROR OCCURED")
            }

            else -> {

                CategoryScreen(viewstate.list, navigateToDetail)

            }
        }
    }
}

@Composable
fun CategoryScreen( categories : List<Category> ,
                    navigateToDetail: (Category) -> Unit){

    Column(modifier = Modifier.fillMaxSize()) {

    Text(
        text = "RECIPE APP" ,
        color = Color.Black,
        modifier = Modifier.fillMaxWidth() .padding(vertical = 10.dp),
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold,
           /* textDecoration = TextDecoration.Underline*/)

    )
    LazyVerticalStaggeredGrid(

        columns = StaggeredGridCells.Fixed(2), // or Adaptive(minSize)
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalItemSpacing = 2.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp)

    ) {

        items(categories) { category ->
            CategoryItem(category = category,navigateToDetail)
        }
     }
    }
}

@Composable
fun CategoryItem( category: Category,
                  navigatetoDetail: (Category) -> Unit) {

    Column(
        modifier = Modifier.fillMaxSize().padding(4.dp)
            .clickable{navigatetoDetail(category)},
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),                                                        // "rememberAsyncImagePainter" was added from "Image Loading" in dependencies.
            contentDescription = null,
            modifier = Modifier.fillMaxSize().aspectRatio(1f)

        )

        Text(
            text = category.strCategory ,
            color = Color.Black,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

