package com.example.mvc_template.src.home

import com.example.mvc_template.src.home.models.PostSignUpRequest
import com.example.mvc_template.src.home.models.SignUpResponse
import com.example.mvc_template.src.home.models.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeRetrofitInterface {

    @GET("/templates/users")
    fun getUsers() : Call<UserResponse>

    @POST("/templates/users")
    fun postSignUp(@Body params: PostSignUpRequest) : Call<SignUpResponse>
}