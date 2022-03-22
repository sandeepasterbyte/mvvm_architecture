package com.asterbyte.mvvmapp.activtiy

import android.view.View
import androidx.lifecycle.ViewModel
import com.asterbyte.mvvmapp.data.repository.UserRepository

class AuthViewModel : ViewModel() {
  var email: String? = null
  var password: String? = null

  var authListener: AuthListener? = null

  fun onLoginButtonClick(view: View) {
    authListener?.onStarted()
    if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
      authListener?.onFailure("Email or password is empty")
      return
    }
    val loginResponse = UserRepository().userLogin(email!!, password!!)
    authListener?.onSuccess(loginResponse)
  }
}