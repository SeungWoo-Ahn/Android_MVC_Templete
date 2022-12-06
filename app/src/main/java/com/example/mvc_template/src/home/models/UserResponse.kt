package com.example.mvc_template.src.home.models

import com.example.mvc_template.config.BaseResponse

data class UserResponse(
    val result: ArrayList<ResultUser>
) : BaseResponse()
