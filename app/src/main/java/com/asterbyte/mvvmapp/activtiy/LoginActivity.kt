package com.asterbyte.mvvmapp.activtiy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.asterbyte.mvvmapp.R
import com.asterbyte.mvvmapp.data.LoginResponse
import com.asterbyte.mvvmapp.databinding.ActivityLoginBinding
import com.asterbyte.mvvmapp.utils.hide
import com.asterbyte.mvvmapp.utils.show
import com.asterbyte.mvvmapp.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity(), AuthListener {

  private val viewModel: AuthViewModel by viewModels()
  private var binding: ActivityLoginBinding? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
//    val viewModel: AuthViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
    binding?.viewModel = viewModel
    viewModel.authListener = this
  }

  override fun onStarted() {
    binding?.progressBar?.show()
  }

  override fun onSuccess(loginResponse: LiveData<LoginResponse>) {
    loginResponse.observe(this, Observer {
      binding?.progressBar?.hide()
      toast(it.message ?: "Unknown Network Error")
      if (it.code == 0) {
        val intent = Intent(this, HomeActivity::class.java).apply {
          putExtra("name", it.data?.name)
        }
        startActivity(intent)
        finish()
      }
    })
  }

  override fun onFailure(message: String) {
    binding?.progressBar?.hide()
    toast(message)
  }
}
//            "email":"Developer@gmail.com",
//            "password":123456