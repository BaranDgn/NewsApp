package com.example.newsapp.data.repository

import com.example.newsapp.data.model.News
import com.example.newsapp.data.service.NewsApiService
import com.example.newsapp.domain.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

//@ActivityScoped
class NewsApiServiceImpl @Inject constructor(
    private val newsApi : NewsApiService
) {

    suspend fun getNewsFromApi() : Resource<News> {
        val responseNews = try{
            newsApi.getNews()
        }catch (e: Exception){
            return Resource.Error("")
        }
        return Resource.Success(responseNews)
    }
}