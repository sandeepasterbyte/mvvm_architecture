package com.asterbyte.mvvmapp.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

//Extension functions

//extension of toast
fun Context.toast(message: String) {
  Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

//extension of progres bar
fun ProgressBar.show() {
  visibility = View.VISIBLE
}

fun ProgressBar.hide() {
  visibility = View.GONE
}
