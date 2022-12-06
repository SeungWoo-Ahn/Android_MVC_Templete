package com.example.mvc_template.src.home

import com.example.mvc_template.config.ApplicationClass
import com.example.mvc_template.src.home.models.PostSignUpRequest
import com.example.mvc_template.src.home.models.SignUpResponse
import com.example.mvc_template.src.home.models.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class HomeService(val homeFragmentInterface: HomeFragmentInterface) {

    fun tryGetUsers(){
        val homeRetrofitInterface = ApplicationClass.retrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getUsers().enqueue(object : retrofit2.Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                homeFragmentInterface.onGetUserSuccess(response.body() as UserResponse)
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                homeFragmentInterface.onGetUserFailure(t.message ?: "통신 오류")
            }

        })
    }

    fun tryPostSignUp(postSignUpRequest: PostSignUpRequest) {
        val homeRetrofitInterface = ApplicationClass.retrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postSignUp(postSignUpRequest).enqueue(object : Callback<SignUpResponse>{
            override fun onResponse(
                call: Call<SignUpResponse>,
                response: Response<SignUpResponse>
            ) {
                homeFragmentInterface.onPostSignUpSuccess(response.body() as SignUpResponse)
            }

            override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                homeFragmentInterface.onPostSignUpFailure(t.message ?: "통신 오류")
            }

        })
    }
}