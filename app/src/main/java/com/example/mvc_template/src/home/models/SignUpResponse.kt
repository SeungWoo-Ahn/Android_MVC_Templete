package com.example.mvc_template.src.home.models

import com.example.mvc_template.config.BaseResponse
import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("result") val result: ResultSignUp
) : BaseResponse()
