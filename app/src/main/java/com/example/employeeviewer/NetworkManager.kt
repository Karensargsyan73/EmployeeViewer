package com.example.employeeviewer

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {
    private val BASE_URL: String = "http://gitlab.65apps.com"
    private var mRetrofit: Retrofit? = null

    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    
    fun getApi(): Api {
        return mRetrofit!!.create(Api::class.java)
    }
}
