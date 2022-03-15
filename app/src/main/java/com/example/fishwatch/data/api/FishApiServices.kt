package com.example.fishwatch.data.api

import com.example.fishwatch.data.model.FishResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object FishApiServices {
    private val BASE_URL = "https://www.fishwatch.gov/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(FishApi::class.java)


    fun getFish(): Single<List<FishResponse>> {
        return api.getFish()
    }
}