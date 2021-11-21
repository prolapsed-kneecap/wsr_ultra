package com.example.wsr_ultra

import com.example.wsr.RetrofitClient
import com.example.wsr.RetrofitServices

object Common {
    val BASE_URL = "http://mskkdsao2021.mad.hakta.pro"

    val retrofitServices: RetrofitServices = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}