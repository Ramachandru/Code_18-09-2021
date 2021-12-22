package com.ram.myapplication.model.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APiCall {
    companion object {
        fun getRetrofit() = Retrofit.Builder()
            .baseUrl(ApiInterface.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }
}