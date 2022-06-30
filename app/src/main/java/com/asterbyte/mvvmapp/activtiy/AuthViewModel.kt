package com.asterbyte.mvvmapp.activtiy

import android.view.View
import androidx.lifecycle.ViewModel
import com.asterbyte.mvvmapp.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {
  var email: String? = null
  var password: String? = null

  var authListener: AuthListener? = null
  @Inject
  lateinit var userRepository: UserRepository

  fun onLoginButtonClick(view: View) {
    authListener?.onStarted()
    if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
      authListener?.onFailure("Email or password is empty")
      return
    }
    val loginResponse = userRepository.userLogin(email!!, password!!)
    authListener?.onSuccess(loginResponse)
  }
}