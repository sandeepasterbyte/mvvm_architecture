package com.asterbyte.mvvmapp.data.networkk

import com.asterbyte.mvvmapp.data.Credentials
import com.asterbyte.mvvmapp.data.LoginResponse
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface MyApi {

  @POST("authaccount/login")
  fun userLogin(@Body jsonObject: Credentials): Call<LoginResponse>

  companion object {
    operator fun invoke(): MyApi {
      return Retrofit.Builder()
        .baseUrl("http://restapi.adequateshop.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(MyApi::class.java)
    }
  }

}