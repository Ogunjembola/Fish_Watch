package com.example.fishwatch.data.api

import com.example.fishwatch.data.model.FishResponse
import io.reactivex.Single
import retrofit2.http.GET

interface FishApi {
    @GET("api/species")
    fun getFish(): Single<List<FishResponse>>
}