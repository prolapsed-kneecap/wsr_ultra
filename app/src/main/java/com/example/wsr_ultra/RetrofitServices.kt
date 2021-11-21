package com.example.wsr

import com.example.wsr_ultra.Feelings
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("/api/feelings")
    fun getFeelings(): Call<Feelings>
}