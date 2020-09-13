package com.grubbrr.demo.network

import com.grubbrr.demo.BuildConfig
import com.grubbrr.demo.model.MenuModel
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.POST

interface WebServiceAPI {

    @Headers("Version: ${BuildConfig.API_VERSION}")
    @POST("GetMenu")
    fun getMenu(): Call<MenuModel>
}