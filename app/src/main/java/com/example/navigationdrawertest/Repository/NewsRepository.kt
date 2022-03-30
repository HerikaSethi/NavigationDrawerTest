package com.example.navigationdrawertest.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.navigationdrawertest.api.NewsServiceOne
import com.example.navigationdrawertest.model.News

//since we are using only api in this project hence we will take reference of api only
class NewsRepository (private val newsServiceOne: NewsServiceOne){
//we are accessing our repository here and repository is accessing newsServiceOne


   private val newsLiveData = MutableLiveData<News>()

    val n:LiveData<News>
    get() = newsLiveData

    //function defined which we will be calling from our viewModel
    suspend fun getN(page:Int){
        val res = newsServiceOne.getHead(page)

        if (res!=null && res.body()!=null){
            //if above condition is true means we have received data fro our retrofit
            newsLiveData.postValue(res.body())
        }
    }

}