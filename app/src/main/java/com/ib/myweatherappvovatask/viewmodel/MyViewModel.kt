package com.ib.myweatherappvovatask.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ib.myweatherappvovatask.data.User
import com.ib.myweatherappvovatask.data.Weather
import com.ib.myweatherappvovatask.myretrofit.MyRetrofit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val myRetrofit: MyRetrofit): ViewModel(){
    var weatherData = MutableLiveData<List<Weather>>()
    var currentData = MutableLiveData<User>()

//    fun getWeatherApi(name: String){
//        viewModelScope.launch {
//            val result = myRetrofit.getInfo(name).execute()
//
//                currentData.postValue(result.body())

//        }
//    }

    fun getWeatherApi(name: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val result = myRetrofit.getInfo(name).execute()
            Handler(Looper.getMainLooper()).post { currentData.value = result.body() }
        }
    }
}