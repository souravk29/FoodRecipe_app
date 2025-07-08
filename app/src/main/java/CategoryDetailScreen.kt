package eu.work.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.text.TextStyle


@Composable
fun CategoryDetailScreen(category: Category){

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(12.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Spacer(modifier = Modifier.height(50.dp))
        Text(
            category.strCategory,
            textAlign = TextAlign.Center,
            style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Black,fontSize = 30.sp)
        )

        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),                                                        // "rememberAsyncImagePainter" was added from "Image Loading" in dependencies.
            contentDescription = "${category.strCategory} Thumbnail",
            modifier = Modifier
                .wrapContentSize()
                .aspectRatio(1f)
                //.verticalScroll(rememberScrollState())
        )

        Text(category.strCategoryDescription, textAlign = TextAlign.Justify
          //  modifier = Modifier.verticalScroll(rememberScrollState() )                                                                 // allows the text to be scrollable across the screen if its long, only the text area not the content above it.
        )

    }

}
