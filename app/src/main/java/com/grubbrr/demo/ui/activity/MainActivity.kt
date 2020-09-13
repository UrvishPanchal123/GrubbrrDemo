package com.grubbrr.demo.ui.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.grubbrr.demo.R
import com.grubbrr.demo.databinding.ActivityMainBinding
import com.grubbrr.demo.ui.common.BaseActivity
import com.grubbrr.demo.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindView(R.layout.activity_main)
        init()
    }

    private fun init() {
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        webCallGetMenu()
    }

    private fun webCallGetMenu() {

        showLoader(this)

        viewModel.getMenu().observe(this, Observer {
            dismissLoader()
            println(it)
            displayShortToast(this, "API Called Successfully")
        })
    }
}