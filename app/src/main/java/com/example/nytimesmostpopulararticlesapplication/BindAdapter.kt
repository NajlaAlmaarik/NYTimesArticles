package com.example.nytimesmostpopulararticlesapplication

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nytimesmostpopulararticlesapplication.local.Articles
import com.example.nytimesmostpopulararticlesapplication.main.ArticlesAdapter
import java.net.URI
import java.net.URL


@BindingAdapter("loadingState")
fun loadingState(progressBar: ProgressBar,state:Boolean){
    if(state)
        progressBar.visibility = View.VISIBLE
    else
        progressBar.visibility = View.GONE

}

@BindingAdapter("listData")
fun recyclerViewBinding(recyclerView: RecyclerView, data : List<Articles>?){
    val adapter = recyclerView.adapter as ArticlesAdapter
    adapter.submitList(data)
}
