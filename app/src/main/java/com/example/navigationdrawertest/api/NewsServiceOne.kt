package com.example.navigationdrawertest.api

import com.example.navigationdrawertest.API_KEY
import com.example.navigationdrawertest.model.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//const val API_KEY ="2ed5101c94ca43c18b17c2db6e15b5b5"
interface NewsServiceOne {
    @GET("v2/top-headlines?apiKey=$API_KEY")

    //suspend function will return headline/response in form of News
    suspend fun getHead(@Query("page")page:Int): Response<News>
}