package com.example.navigationdrawertest.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationdrawertest.NewsAdapter
import com.example.navigationdrawertest.NewsService
import com.example.navigationdrawertest.R
import com.example.navigationdrawertest.databinding.FragmentRcvRetrofitBinding
import com.example.navigationdrawertest.model.News
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RcvRetrofitFragment : Fragment() {

    lateinit var adapter: NewsAdapter
    lateinit var binding: FragmentRcvRetrofitBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRcvRetrofitBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      getNews()
    }

    private fun getNews() {
       // binding.newsList
       // val newsList: RecyclerView = requireView().findViewById(R.id.newsList)

        //calling retrofit or news service
        val news = NewsService.newsInstance.getHeadlines("in",1)
        news.enqueue(object :retrofit2.Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                if (news!=null) {
                    Log.d("callback", news.toString())

                    //adapter object
                    adapter= NewsAdapter(requireContext(),news.articles)
                    //access recyclerview
                    binding.newsList.adapter = adapter
                    //setting layout manager
                    binding.newsList.layoutManager = LinearLayoutManager(requireContext())
                }

            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("callback", "Error in fetching news",t)
            }

        })
    }

}