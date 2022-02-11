package com.example.myapplication561461084.data.simplifiedcoding.Common

import com.example.myapplication561461084.data.Constant
import com.example.myapplication561461084.data.simplifiedcoding.Interface.RetrofitServices
import com.example.myapplication561461084.data.simplifiedcoding.Retrofit.RetrofitClient

object Common {

    val retrofitServices:RetrofitServices
    get()=RetrofitClient.getClient(Constant.SIMPLIFIED_URL).create(RetrofitServices::class.java)
}