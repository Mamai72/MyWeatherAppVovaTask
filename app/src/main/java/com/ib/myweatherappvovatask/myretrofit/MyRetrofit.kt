package com.ib.myweatherappvovatask.myretrofit

import com.ib.myweatherappvovatask.data.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MyRetrofit {
    @GET("users/{postName}/repos")
    fun getInfo(@Path("postName") name: String): Call<User>

 //   fun getInfo(@Path("London") cityName: String): Call<WeatherDataJson>
 //   fun getInfo(@Path("cityName") cityName: String): Call<List<WeatherData>>
}

