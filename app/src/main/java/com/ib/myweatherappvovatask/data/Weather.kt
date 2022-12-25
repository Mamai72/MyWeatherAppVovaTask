package com.ib.myweatherappvovatask.data

data class Weather(
    val `data`: List<Data>,
    val dateGenerated: String,
    val status: String,
    val user: String,
    val version: String
)