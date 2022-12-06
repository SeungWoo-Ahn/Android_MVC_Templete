package com.example.mvc_template.src.home

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.mvc_template.R
import com.example.mvc_template.config.BaseFragment
import com.example.mvc_template.databinding.FragmentHomeBinding
import com.example.mvc_template.src.home.models.PostSignUpRequest
import com.example.mvc_template.src.home.models.SignUpResponse
import com.example.mvc_template.src.home.models.UserResponse

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home), HomeFragmentInterface {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnTryGetJwt.setOnClickListener {
            HomeService(this).tryGetUsers()
        }

        binding.btnTryPost.setOnClickListener {
            val email = binding.etId.text.toString()
            val password = binding.etPw.text.toString()

            val postRequest = PostSignUpRequest(
                email = email,
                password = password,
                confirmPassword = password,
                nickname = "test",
                phoneNumber = "010-0000-0000")

            HomeService(this).tryPostSignUp(postRequest)
        }
    }

    override fun onGetUserSuccess(response: UserResponse) {
        for (User in response.result){
            Log.d("HomeFragment",User.toString())
        }
        showCustomToast(response.message.toString())
    }

    override fun onGetUserFailure(message: String) {
        showCustomToast("오류: $message")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        response.message?.let { showCustomToast(it) }
    }

    override fun onPostSignUpFailure(message: String) {
        showCustomToast("오류: $message")
    }
}