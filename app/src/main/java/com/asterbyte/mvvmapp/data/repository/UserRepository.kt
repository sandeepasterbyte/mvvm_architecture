package com.asterbyte.mvvmapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.asterbyte.mvvmapp.data.Credentials
import com.asterbyte.mvvmapp.data.LoginResponse
import com.asterbyte.mvvmapp.data.networkk.MyApi
import retrofit2.Call
import retrofit2.Response

class UserRepository {

  fun userLogin(email: String, password: String): LiveData<String> {

    val loginResponse = MutableLiveData<String>()
    MyApi().userLogin(Credentials(email, password))
      .enqueue(object : retrofit2.Callback<LoginResponse> {
        override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
          if (response.isSuccessful) {
            loginResponse.value = response.body()?.message
          } else {
            loginResponse.value = response.body()?.message
          }
        }

        override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
          loginResponse.value = t.message
        }

      })
    return loginResponse
  }
}