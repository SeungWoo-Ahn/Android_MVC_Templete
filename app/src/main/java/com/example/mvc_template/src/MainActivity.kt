package com.example.mvc_template.src

import android.os.Bundle
import com.example.mvc_template.R
import com.example.mvc_template.config.BaseActivity
import com.example.mvc_template.databinding.ActivityMainBinding
import com.example.mvc_template.src.home.HomeFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.main_frame, HomeFragment()).commitAllowingStateLoss()

        bind.mainBottomNav.run {
            setOnItemSelectedListener { item ->
                when(item.itemId){
                    R.id.nav_home -> {
                        supportFragmentManager.beginTransaction().replace(R.id.main_frame,HomeFragment()).commitAllowingStateLoss()
                    }
                    R.id.nav_my -> {
                        supportFragmentManager.beginTransaction().replace(R.id.main_frame,HomeFragment()).commitAllowingStateLoss()
                    }
                }
                true
            }
            selectedItemId = R.id.nav_home
        }
    }
}