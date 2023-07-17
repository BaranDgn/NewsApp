package com.example.newsapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.newsapp.data.model.News
import com.example.newsapp.data.repository.NewsApiServiceImpl
import com.example.newsapp.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repo : NewsApiServiceImpl
) : ViewModel() {

    suspend fun loadAllTheNews() : Resource<News>{
        return repo.getNewsFromApi()
    }

}