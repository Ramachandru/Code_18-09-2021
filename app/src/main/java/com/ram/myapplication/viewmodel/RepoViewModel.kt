package com.ram.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ram.myapplication.model.Repose
import com.ram.myapplication.model.network.APiCall
import com.ram.myapplication.model.network.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepoViewModel : ViewModel() {
    private val liveDataRepos: MutableLiveData<MutableList<Repose>>? =
        MutableLiveData<MutableList<Repose>>()

    fun getReposData(): MutableLiveData<MutableList<Repose>>? {
        getDataFromServer()
        return liveDataRepos
    }

    fun getDataFromServer(): Unit {
        var apiCall = APiCall.getRetrofit().create(ApiInterface::class.java)
        val call = apiCall.getRepos()
        call.enqueue(object : Callback<MutableList<Repose>> {
            override fun onResponse(
                call: Call<MutableList<Repose>>,
                response: Response<MutableList<Repose>>
            ) {
                liveDataRepos!!.value = response.body()
            }

            override fun onFailure(call: Call<MutableList<Repose>>, t: Throwable) {
                Log.v("ERROR", "ERROR " + t.message)
            }

        })
    }
}