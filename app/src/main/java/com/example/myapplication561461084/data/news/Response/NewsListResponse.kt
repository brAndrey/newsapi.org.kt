package com.example.myapplication561461084.data.news

import com.google.gson.annotations.SerializedName

data class NewsListResponse(
    val status: String,

    val totalResults: String,
    @SerializedName("articles")
    val articles: List<NewsListItem>,
)


data class NewsListItem(

    //val source: List<NewsListSource>,
    val source: NewsListSource,
    val author:String,
    val title:String,
    val description:String,
    val url:String,
    val urlToImage:String,
    val publishedAt:String,
    val content:String

    )

data class NewsListSource(
    val id: String,

    val name: String,

    )