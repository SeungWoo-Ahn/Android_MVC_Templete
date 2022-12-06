package com.example.mvc_template.config

import com.google.gson.annotations.SerializedName

//open class: 다른 클래스에서 상속 가능
//반복되는 리스펀스 내용 중복을 줄이기 위해 사용
open class BaseResponse (
    @SerializedName("isSuccess") val isSuccess: Boolean = false,
    @SerializedName("code") val code: Int = 0,
    @SerializedName("message") val message: String? = null
)