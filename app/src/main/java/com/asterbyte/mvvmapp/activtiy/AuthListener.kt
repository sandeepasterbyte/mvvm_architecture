package com.asterbyte.mvvmapp.activtiy

import androidx.lifecycle.LiveData
import com.asterbyte.mvvmapp.data.LoginResponse

interface AuthListener {
  fun onStarted()
  fun onSuccess(loginResponse: LiveData<LoginResponse>)
  fun onFailure(message: String)
}