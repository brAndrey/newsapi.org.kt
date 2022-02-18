package com.example.myapplication561461084.data.api_github_com.Repository

import com.example.myapplication561461084.data.Constant
import com.example.myapplication561461084.data.api_github_com.Common.Common
import com.example.myapplication561461084.data.api_github_com.Interfase.UmoriliApiService
import com.example.myapplication561461084.data.api_github_com.Model.UmoriliModel
import com.example.myapplication561461084.data.api_github_com.Movie_api
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.Call

class UmoriliRepository(val apiUmorili: UmoriliApiService) {


    fun UmoriliApiGatData(RESOURSENAME: String,COINT : Int): Observable<List<UmoriliModel?>?>? {
        return apiUmorili.getPostModel(resourseName = Constant.RESOURSENAME, count=Constant.COINT)
    }

    fun seachMovieCall(): Call<List<UmoriliModel?>?>? {
        return apiUmorili.getData(Constant.RESOURSENAME, Constant.COINT)
    }

    fun seachMovieFlowable(): Flowable<List<UmoriliModel?>?>? {
        return apiUmorili.getPostModelLive(Constant.RESOURSENAME, Constant.COINT)
    }


}
