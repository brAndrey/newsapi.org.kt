package com.example.myapplication561461084.data.simplifiedcoding.Common

import android.util.Log
import com.example.myapplication561461084.data.Constant
import com.example.myapplication561461084.data.simplifiedcoding.Interface.RetrofitServices
import com.example.myapplication561461084.data.simplifiedcoding.Retrofit.RetrofitClient
import retrofit2.Retrofit

object Common {

    val retrofitServices:RetrofitServices

    // предопределённый метод
    //get() = RetrofitClient.getClient(Constant.SIMPLIFIED_URL).create(RetrofitServices::class.java)

    get(): RetrofitServices  {
        Log.i("Common get"," "+System.currentTimeMillis())
        return RetrofitClient.getClient(Constant.SIMPLIFIED_URL)
        .create(RetrofitServices::class.java)}

    fun get2(): RetrofitServices
    {

        return RetrofitClient.getClient(Constant.SIMPLIFIED_URL)
           .create(RetrofitServices::class.java)
    }

}