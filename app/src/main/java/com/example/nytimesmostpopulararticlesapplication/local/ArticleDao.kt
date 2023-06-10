package com.example.nytimesmostpopulararticlesapplication.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(articles : List<Articles>)

    @Query("SELECT * FROM articles_table ORDER BY publishedDate desc")
    fun getAllArticles() : LiveData<List<Articles>>
}