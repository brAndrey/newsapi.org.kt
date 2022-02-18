package com.example.myapplication561461084.data.news.Provider

import com.example.myapplication561461084.data.news.Api.Common.NewsCommon
import com.example.myapplication561461084.data.news.NewsRepozitories.NewsRepositories


object NewsRepositoriesProvider {

    fun providerNewsRepository():NewsRepositories {
        // инициализируем интерфайс
        return NewsRepositories(NewsCommon.apiNewsApiService)
        //return NewsRepositories(NewsCommon.apiNewsApiService)

    }
}