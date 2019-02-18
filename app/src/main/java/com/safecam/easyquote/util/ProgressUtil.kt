package com.safecam.easyquote.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.RelativeLayout
import com.safecam.easyquote.R
import com.safecam.easyquote.view.activity.BaseActivity
import kotlinx.android.synthetic.main.circular_progress.view.*

/**
 * Helper functions to show circular loading
 *
 * @author Darien
 */
object ProgressUtil {

    /**
     * Show a circular loading and disable user interactions on that screen
     *
     * @param context the base activity context
     */
    fun showLoading(context: BaseActivity) {
        val rootLayout = context.window.decorView.rootView as ViewGroup
        val progressBar = LayoutInflater.from(context).inflate(R.layout.circular_progress, rootLayout, false)

        val params = RelativeLayout.LayoutParams(100, 100)
        params.addRule(RelativeLayout.CENTER_IN_PARENT)
        rootLayout.addView(progressBar, params)

        // to show ProgressBar
        progressBar.visibility = View.VISIBLE

        // disable user interaction
        context.window.setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }

    /**
     * Hide a circular loading and enable user interaction in that screen
     *
     * @param context the base activity context
     */
    fun hideLoading(context: BaseActivity) {
        val rootLayout = context.window.decorView.rootView as ViewGroup

        // to Hide ProgressBar
        rootLayout.progress_circular.visibility = View.GONE

        // enable user interaction
        context.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
}