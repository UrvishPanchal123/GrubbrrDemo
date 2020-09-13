package com.grubbrr.demo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grubbrr.demo.model.MenuModel
import com.grubbrr.demo.network.CustomApiCallback
import com.grubbrr.demo.network.WebServiceClient

class MainViewModel : ViewModel() {

    fun getMenu(): MutableLiveData<MenuModel> {

        val menuResponse = MutableLiveData<MenuModel>()

        WebServiceClient.getService()?.getMenu()
            ?.enqueue(object : CustomApiCallback<MenuModel>() {

                override fun handleResponseData(data: MenuModel?) {
                    menuResponse.value = data
                }

                override fun showErrorMessage(errorMessage: String?) {
                    Log.e(MainViewModel::class.simpleName, errorMessage.toString())
                    menuResponse.value = null
                }
            })

        return menuResponse
    }
}