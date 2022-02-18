package com.example.myapplication561461084.data.api_github_com

import com.example.myapplication561461084.data.api_github_com.Common.Common
import com.example.myapplication561461084.NotUse.SearchRepository

object SearchRepositoryProvider {


    fun providerSearchRepository(): SearchRepository {
        return SearchRepository( Common.apiService)
        //this.application as? NewsApp).newsApi
    }
}