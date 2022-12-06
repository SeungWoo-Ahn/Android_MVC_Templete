package com.example.mvc_template.config

import com.example.mvc_template.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.mvc_template.config.ApplicationClass.Companion.sharedPref
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class XAccessTokenInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sharedPref.getString(X_ACCESS_TOKEN,null)
        if(jwtToken != null) {
            builder.addHeader("X_ACCESS_TOKEN",jwtToken)
        }
        return chain.proceed(builder.build())
    }
}