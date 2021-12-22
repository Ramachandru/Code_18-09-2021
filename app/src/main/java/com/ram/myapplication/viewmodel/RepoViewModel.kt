package com.ram.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ram.myapplication.model.Repose
import com.ram.myapplication.model.network.APiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class RepoViewModel : ViewModel() {
    private val liveDataRepos: MutableLiveData<MutableList<Repose>>? by lazy {
        MutableLiveData<MutableList<Repose>>().also {
            getDataFromServer()
        }
    }

    fun getReposData(): MutableLiveData<MutableList<Repose>>? {
        return liveDataRepos
    }

    fun getDataFromServer(): Unit {
        var apiCall = APiCall.getRetrofit()

        viewModelScope.launch(Dispatchers.IO) {
            val response = apiCall.getRepos()
            if (response.isSuccessful) {
                liveDataRepos!!.postValue(response.body())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}