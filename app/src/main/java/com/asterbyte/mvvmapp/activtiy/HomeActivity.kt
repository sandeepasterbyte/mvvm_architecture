package com.asterbyte.mvvmapp.activtiy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.asterbyte.mvvmapp.R
import com.asterbyte.mvvmapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
  private var binding: ActivityHomeBinding? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    val name = intent.getStringExtra("name")
    binding?.tvName?.text = "Welcome $name"
  }
}