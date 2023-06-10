package com.example.nytimesmostpopulararticlesapplication.remote

import com.example.nytimesmostpopulararticlesapplication.BuildConfig
import com.example.nytimesmostpopulararticlesapplication.Constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

private val interceptor = run {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.apply {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
}
private val okHttpClient = OkHttpClient.Builder()
    .addNetworkInterceptor(interceptor)
    .connectTimeout(30, TimeUnit.SECONDS)
    .writeTimeout(30, TimeUnit.SECONDS)
    .readTimeout(30, TimeUnit.SECONDS)
    .build()

private val retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()


interface NYArticlesApiService {
    @GET("svc/mostpopular/v2/viewed/7.json")
    suspend fun getNYArticles(@Query("api-key") apiKey: String = BuildConfig.API_KEY): ArticleResponse
}

object NYArticleApi {
    val retrofitService: NYArticlesApiService by lazy {
        retrofit.create(NYArticlesApiService::class.java)
    }
}
