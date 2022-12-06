package com.example.mvc_template.config

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

// 액티비티 추상 클래스
abstract class BaseActivity<B : ViewBinding>(private val inflate: (LayoutInflater) -> B) : AppCompatActivity() {

    protected lateinit var bind : B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = inflate(layoutInflater)
        setContentView(bind.root)
    }

    fun showCustomToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}