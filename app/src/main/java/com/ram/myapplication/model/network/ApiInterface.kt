package com.ram.myapplication.model.network

import com.ram.myapplication.model.Repose
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    companion object {
        const val BASEURL: String = "https://api.github.com/users/mralexgray/"
    }
    @GET("repos")
    suspend fun getRepos(): Response<MutableList<Repose>>
}