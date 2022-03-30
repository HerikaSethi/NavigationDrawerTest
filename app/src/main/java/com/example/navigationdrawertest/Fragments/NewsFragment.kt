package com.example.navigationdrawertest.Fragments

import ViewModels.MainViewModel
import ViewModels.MainViewModelFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.navigationdrawertest.R
import com.example.navigationdrawertest.Repository.NewsRepository
import com.example.navigationdrawertest.api.NewsServiceOne
import com.example.navigationdrawertest.api.RetrofitHelper


class NewsFragment : Fragment() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newsServiceOne = RetrofitHelper.getInstance().create(NewsServiceOne::class.java)

        val repository = NewsRepository(newsServiceOne)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.n.observe(viewLifecycleOwner, Observer {
            Log.d("abc"," datafetched"+it.toString())
        })

    }


}