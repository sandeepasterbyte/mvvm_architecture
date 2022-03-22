package com.asterbyte.mvvmapp.activtiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.asterbyte.mvvmapp.R
import com.asterbyte.mvvmapp.databinding.ActivityLoginBinding
import com.asterbyte.mvvmapp.utils.hide
import com.asterbyte.mvvmapp.utils.show
import com.asterbyte.mvvmapp.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener {
  var binding: ActivityLoginBinding?=null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
    val viewModel: AuthViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
    binding?.viewModel = viewModel
    viewModel.authListener = this
    binding?.progressBar
  }

  override fun onStarted() {
    binding?.progressBar?.show()
  }

  override fun onSuccess(loginResponse: LiveData<String>) {
    loginResponse.observe(this, Observer {
      binding?.progressBar?.hide()
      toast(it)
    })
  }

  override fun onFailure(message: String) {
    binding?.progressBar?.hide()
    toast(message)
  }
}