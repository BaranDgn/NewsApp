package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapp.domain.util.Screens
import com.example.newsapp.presentation.view.NewsDetailScreen
import com.example.newsapp.presentation.view.NewsScreen
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppNav()
        }

    }


}

@Composable
fun NewsAppNav() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screens.NewsScreen.route
    ){
        composable(route = Screens.NewsScreen.route){
            NewsScreen(navController)
        }

        composable(route= Screens.NewsDetailScreen.route){
            NewsDetailScreen(navController)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewsAppTheme {
        NewsAppNav()
    }
}