package com.example.mvc_template.config

import android.app.Application
import android.content.SharedPreferences
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//앱이 실행될 때 1번만 실행
class ApplicationClass : Application() {

    //서버 주소
    val API_URL = "http://dev-api.test.com/"

    //전역 변수
    companion object {

        lateinit var sharedPref: SharedPreferences //sharedPreferences
        val X_ACCESS_TOKEN = "X_ACCESS_TOKEN"   // JWT TOKEN Header의 키 값
        lateinit var retrofit: Retrofit //retrofit 인스턴스

    }

    override fun onCreate() {
        super.onCreate()
        sharedPref = applicationContext.getSharedPreferences("MAIN_SP", MODE_PRIVATE)
        initRetrofitInstance() // retrofit 인스턴스 생성
    }


    // retrofit 각종 설정값 지정
    // 연결 타임아웃은 5초, Interceptor를 통해 어떤 요청이 나가고 들어오는지 보여줌
    private fun initRetrofitInstance() {
        val clinet : OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000,TimeUnit.MILLISECONDS)
            .connectTimeout(5000,TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) //로그캣에 okhttp.OkHttpClient로 검색
            .addNetworkInterceptor(XAccessTokenInterceptor()) // JWT 자동 헤더 전송
            .build()


        // retrofit 이라는 전역변수에 API_URL, 인터셉터, Gson 넣어주고
        // 이 변수로 http 요청을 서버로 보내면 된다
        retrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(clinet)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}