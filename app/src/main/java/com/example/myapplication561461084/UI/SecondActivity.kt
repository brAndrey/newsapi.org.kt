package com.example.myapplication561461084.UI

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication561461084.R
import com.example.myapplication561461084.UI.Interface.TestInterface
import com.example.myapplication561461084.data.news.Api.Interface.NewsApiService
import com.example.myapplication561461084.data.Constant
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

//import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
//import io.reactivex.rxjava3.disposables.CompositeDisposable
//import io.reactivex.rxjava3.schedulers.Schedulers

class SecondActivity: AppCompatActivity(), TestInterface {

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        PrintString(javaClass.simpleName)

        compositeDisposable.dispose()

        //val newsApp = (this.application as? NewsApp).newsApi

        //activity?.application as? QuestApp

        val newApiService: NewsApiService

    //    fetchQuestList(newApi)

        val buton = findViewById<Button>(R.id.button2)
        buton.setOnClickListener(){
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun fetchQuestList(newsApiService: NewsApiService?){


            newsApiService?.let {
            compositeDisposable.add(newsApiService.NewsListResponse(Constant.API_COUNTRY, Constant.API_KEY)
                ?.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                           //Log.e("TAG",it.articles.toString())
                },{}))
            }
    }
}
