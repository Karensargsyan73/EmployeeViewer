package com.example.employeeviewer

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("65gb/static/raw/master/testTask.json")
    fun getEmployees(): Call<Response>
}