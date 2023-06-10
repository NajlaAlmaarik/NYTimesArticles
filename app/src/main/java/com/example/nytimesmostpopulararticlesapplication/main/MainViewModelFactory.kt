package com.example.nytimesmostpopulararticlesapplication.main

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nytimesmostpopulararticlesapplication.local.ArticleDao

class MainViewModelFactory(
    private val dataSource: ArticleDao,
    private val application: Application
    ) : ViewModelProvider.Factory {
        @Suppress("unchecked_cast")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainPageViewModel::class.java)) {
                return MainPageViewModel(dataSource, application) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
}
