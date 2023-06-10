package com.example.nytimesmostpopulararticlesapplication

import androidx.lifecycle.LiveData
import com.example.nytimesmostpopulararticlesapplication.local.ArticleDao
import com.example.nytimesmostpopulararticlesapplication.local.Articles
import com.example.nytimesmostpopulararticlesapplication.remote.ArticleResponse
import com.example.nytimesmostpopulararticlesapplication.remote.NYArticleApi
import com.example.nytimesmostpopulararticlesapplication.remote.NYArticlesApiService
import kotlinx.coroutines.flow.flow

class NYArticleRepository(val dataBase : ArticleDao) {

    suspend fun loadArticles() {
        val result = NYArticleApi.retrofitService.getNYArticles()
        val domain = mapToDomain(result)
        dataBase.insertArticles(domain)
    }

     fun getArticles():LiveData<List<Articles>>{
        return dataBase.getAllArticles()
    }
}