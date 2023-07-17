package com.example.newsapp.presentation.view

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun NewsCardView(
    painter : Painter,
    contentDescription: String,
    title: String,
    linkToResource : Uri,
    navController: NavController
) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(linkToResource.toString())) }

    Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .clickable {
                    //navController.navigate(Screens.NewsDetailScreen.route)
                    context.startActivity(intent)

                },
            shape = RoundedCornerShape(8.dp),
            elevation = 5.dp
        ) {
            Column(modifier = Modifier.height(280.dp)){

                Image(
                    painter = painter,
                    contentDescription = "contentDescription",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp))


                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                    contentAlignment = Alignment.BottomStart
                ){
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(4.dp)) {
                        Text(
                            text = title,
                            style = TextStyle(color = Color.Black, fontSize = 16.sp)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = contentDescription,
                            style = TextStyle(color = Color.Black, fontSize = 12.sp)
                        )
                    }

                }
            }
        }



}