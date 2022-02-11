package com.example.myapplication561461084.data.news

data class NewsListResponse(
    val status: String,

    val totalResults: String,

    val articles: List<NewsListItem>,
)


data class NewsListItem(
    val source: List<NewsListSource>,

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