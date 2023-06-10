package com.example.nytimesmostpopulararticlesapplication.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nytimesmostpopulararticlesapplication.NYArticleRepository
import com.example.nytimesmostpopulararticlesapplication.local.ArticleDao
import com.example.nytimesmostpopulararticlesapplication.local.Articles
import com.example.nytimesmostpopulararticlesapplication.remote.ArticleResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel(
     articleDao : ArticleDao,
     application: Application
) : AndroidViewModel(application) {

    val repository = NYArticleRepository(articleDao)

    private val _loadingStatus = MutableLiveData<Boolean>()
    val loadingStatus : LiveData<Boolean>
        get() = _loadingStatus

    init {
        viewModelScope.launch {
            _loadingStatus.value = true
            repository.loadArticles()
            _loadingStatus.value = false
        }

    }

     val articles = repository.getArticles()

}