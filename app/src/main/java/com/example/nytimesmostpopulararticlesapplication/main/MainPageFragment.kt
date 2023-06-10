package com.example.nytimesmostpopulararticlesapplication.main

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.nytimesmostpopulararticlesapplication.R
import com.example.nytimesmostpopulararticlesapplication.databinding.FragmentMainPageBinding
import com.example.nytimesmostpopulararticlesapplication.local.ArticleDao
import com.example.nytimesmostpopulararticlesapplication.local.ArticlesDataBase


class MainPageFragment : Fragment() {

    private val application: Application by lazy {
        requireNotNull(this.activity).application
    }

    private val dataBase: ArticleDao by lazy {
        ArticlesDataBase.getInstance(application).articleDao
    }

    private val viewModelFactory: MainViewModelFactory by lazy {
        MainViewModelFactory(dataBase, application)
    }

    private val viewModel: MainPageViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainPageViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainPageBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.articlesRec.adapter = ArticlesAdapter(
            OnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(it.url)
            startActivity(intent)
            }
        )

        return binding.root
    }
}