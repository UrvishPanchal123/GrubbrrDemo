package com.grubbrr.demo

import android.app.Application
import com.grubbrr.demo.network.WebServiceClient

class GrubbrrApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        WebServiceClient.init(this)
    }
}