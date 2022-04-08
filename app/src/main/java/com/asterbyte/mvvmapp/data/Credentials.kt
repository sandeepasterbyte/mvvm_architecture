package com.asterbyte.mvvmapp.data

import com.google.gson.annotations.SerializedName

data class Credentials(
  @SerializedName("email")
  val userEnail:String,

  @SerializedName("password")
  val password:String)
