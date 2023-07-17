package com.example.newsapp.domain.util

sealed class Screens(val route: String){
    object NewsScreen : Screens("news_screen")
    object NewsDetailScreen : Screens("news_detail_screen")

}
