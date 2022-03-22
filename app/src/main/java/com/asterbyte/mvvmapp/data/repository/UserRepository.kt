package com.asterbyte.mvvmapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.asterbyte.mvvmapp.data.networkk.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class UserRepository {

  fun userLogin(email: String, password: String): LiveData<String> {

    val loginResponse = MutableLiveData<String>()

    MyApi().userLogin(email, password)
      .enqueue(object : retrofit2.Callback<ResponseBody> {
        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
          if (response.isSuccessful) {
            loginResponse.value = response.body().toString()
          } else {
            loginResponse.value = response.errorBody().toString()
          }
        }

        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
          loginResponse.value = t.message
        }

      })
    return loginResponse
  }
}