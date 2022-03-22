package com.asterbyte.mvvmapp.activtiy

import androidx.lifecycle.LiveData

interface AuthListener {
  fun onStarted()
  fun onSuccess(loginResponse: LiveData<String>)
  fun onFailure(message:String)
}