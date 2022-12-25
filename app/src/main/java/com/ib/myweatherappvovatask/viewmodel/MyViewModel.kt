package com.ib.myweatherappvovatask.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ib.myweatherappvovatask.data.Weather
import com.ib.myweatherappvovatask.myretrofit.MyRetrofit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val myRetrofit: MyRetrofit): ViewModel(){
    var weatherData = MutableLiveData<List<Weather>>()
    var currentData = MutableLiveData<Weather>()

    fun getWeatherApi(){
        viewModelScope.launch {
            val result = myRetrofit.getInfo()
            if (result.isSuccessful){
                currentData.postValue(result.body())
                Log.d("TAG", "getWeatherApi: ${result.message()}")
//               Handler(Looper.getMainLooper()).post { currentData.value = result.body() }
            }else{
                Log.d("TAG", "getWeatherApi: Error response: ${result.message()}")
            }
        }
    }
}