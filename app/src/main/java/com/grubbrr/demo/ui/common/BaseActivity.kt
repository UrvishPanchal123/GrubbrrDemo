package com.grubbrr.demo.ui.common

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.grubbrr.demo.R
import com.grubbrr.demo.database.GrubbrrDatabase

@SuppressLint("Registered")
open class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var mBinding: T

    private lateinit var progressDialog: Dialog

    protected lateinit var mDatabase: GrubbrrDatabase

    protected fun bindView(layoutId: Int) {
        mBinding = DataBindingUtil.setContentView(this, layoutId)
        mDatabase = GrubbrrDatabase.getInstance(this)!!
    }

    protected fun initToolbar(
        toolbar: Toolbar,
        title: Int,
        txtTitle: TextView,
        showHeaderLogo: Boolean,
        showBackButton: Boolean,
        imgHeaderLogo: ImageView
    ) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        if (title != 0)
            txtTitle.text = getString(title)
        else
            txtTitle.visibility = View.GONE

        if (showBackButton)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (showHeaderLogo)
            imgHeaderLogo.visibility = View.VISIBLE
    }

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    protected fun showLoader(context: Context) {
        progressDialog = Dialog(context)
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.setContentView(R.layout.layout_custom_loader)
        progressDialog.window?.setDimAmount(0.75f)
        progressDialog.show()
    }

    protected fun dismissLoader() {
        if (::progressDialog.isInitialized)
            progressDialog.dismiss()
    }

    /**
     * Checking Internet is available or not
     *
     * @param context
     * @return
     */
    fun isInternetAvailable(context: Context?): Boolean {
        val cm = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }

    fun displayShortToast(context: Context, msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    fun displayLongToast(context: Context, msg: String?) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
    }

//    fun displayInternetToast(context: Context) {
//        Toast.makeText(
//            context,
//            resources.getString(R.string.string_msg_no_internet),
//            Toast.LENGTH_SHORT
//        ).show()
//    }
}