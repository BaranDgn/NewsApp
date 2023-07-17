package com.example.newsapp.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.newsapp.R
import com.example.newsapp.data.model.News
import com.example.newsapp.domain.util.Resource
import com.example.newsapp.presentation.viewModel.NewsViewModel

@Composable
fun NewsScreen(
    navController: NavController,
    newsViewModel : NewsViewModel = hiltViewModel()
) {

    val newsItem = produceState<Resource<News>>(initialValue = Resource.isLoading()){
        value = newsViewModel.loadAllTheNews()
    }.value
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 16.dp)) {

        when(newsItem){
            is Resource.Success ->{
                LazyColumn(contentPadding = PaddingValues(5.dp)){
                    items(newsItem.data!!.articles){news->
                        NewsCardView(painter = rememberImagePainter(data = news.urlToImage), news.title,news.description,news.url.toUri(),navController)

                    }
                }
            }
            is Resource.Error ->{

            }
            else ->Unit
        }
//        NewsCardView(painter = rememberImagePainter(data = R.drawable.ic_launcher_background), "","", navController)
    }
}