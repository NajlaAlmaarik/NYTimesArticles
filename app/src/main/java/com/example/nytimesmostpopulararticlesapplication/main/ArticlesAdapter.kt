package com.example.nytimesmostpopulararticlesapplication.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nytimesmostpopulararticlesapplication.databinding.ArticleItemBinding
import com.example.nytimesmostpopulararticlesapplication.local.Articles
import java.util.zip.Inflater

class ArticlesAdapter(val onClickListener: OnClickListener) : ListAdapter<Articles,ArticlesAdapter.ArticleViewHolder>(DiffCallBack) {
    object DiffCallBack : DiffUtil.ItemCallback<Articles>(){
        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(
            oldItem: Articles,
            newItem: Articles
        ): Boolean {
           return oldItem.id == newItem.id
        }

    }

    class ArticleViewHolder(val binding : ArticleItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(article : Articles){
            binding.article = article
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
       return ArticleViewHolder(ArticleItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(item)
        }

    }
}

class OnClickListener(val clickListener: (articles: Articles) -> Unit) {
    fun onClick(article: Articles) = clickListener(article)
}