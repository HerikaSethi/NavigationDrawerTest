package com.example.navigationdrawertest.model

import com.example.navigationdrawertest.model.Article

//data class pointing to the response of json
data class News(val totalResults: Int, val articles: List<Article>)
