package com.example.mvc_template.src.home

import com.example.mvc_template.src.home.models.SignUpResponse
import com.example.mvc_template.src.home.models.UserResponse

interface HomeFragmentInterface {

    fun onGetUserSuccess(response: UserResponse)

    fun onGetUserFailure(message: String)

    fun onPostSignUpSuccess(response: SignUpResponse)

    fun onPostSignUpFailure(message: String)
}