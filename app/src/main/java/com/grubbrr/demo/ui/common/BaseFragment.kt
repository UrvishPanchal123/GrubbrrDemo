package com.grubbrr.demo.ui.common

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.grubbrr.demo.R
import com.grubbrr.demo.database.GrubbrrDatabase

open class BaseFragment<T : ViewDataBinding> : Fragment() {

    protected lateinit var mBinding: T
    private lateinit var progressDialog: Dialog
    protected lateinit var mDatabase: GrubbrrDatabase

    protected fun bindView(
        inflater: LayoutInflater,
        layoutId: Int,
        container: ViewGroup?
    ) {
        mBinding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        mDatabase = GrubbrrDatabase.getInstance(activity!!.applicationContext)!!
    }

    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    protected fun showLoader(context: Context) {
        progressDialog = Dialog(context)
        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        progressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.setContentView(R.layout.layout_custom_loader)
        progressDialog.window?.setDimAmount(0.75f)
        progressDialog.show()
    }

    protected fun dismissLoader() {
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