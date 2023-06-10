package com.example.nytimesmostpopulararticlesapplication.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Articles::class], version = 1)
@TypeConverters(CachedStringConverter::class, CachedMediaConverter::class)
abstract class ArticlesDataBase() : RoomDatabase() {

    abstract val articleDao : ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticlesDataBase? = null
        fun getInstance(context: Context): ArticlesDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ArticlesDataBase::class.java,
                        "articles_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}