package com.ib.myweatherappvovatask.myretrofit

import com.ib.myweatherappvovatask.data.Weather

import retrofit2.Response
import retrofit2.http.GET

interface MyRetrofit {
    @GET("2022-12-25T00:00:00Z/t_2m:C/52.520551,13.461804/json")
    suspend fun getInfo(): Response<Weather>
 //   fun getInfo(@Path("London") cityName: String): Call<WeatherDataJson>
 //   fun getInfo(@Path("cityName") cityName: String): Call<List<WeatherData>>
}

