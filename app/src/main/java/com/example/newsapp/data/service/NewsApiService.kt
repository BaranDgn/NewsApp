package com.example.newsapp.data.service

import com.example.newsapp.data.model.News
import com.example.newsapp.domain.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    //https://newsapi.org/v2/everything?domains=wsj.com&apiKey=b06f4e7696bd4940a81c1aa7e1450ccf
    //https://newsapi.org/v2/everything?domains=wsj.com&apiKey=b06f4e7696bd4940a81c1aa7e1450ccf
    @GET("everything?domains=wsj.com")
    suspend fun getNews(
        //@Query("everything?domains") sss: String = "wsj.com",
        @Query("apiKey") apiKey : String = API_KEY
    ) : News
}