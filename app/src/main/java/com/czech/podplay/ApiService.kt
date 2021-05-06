package com.czech.podplay

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://listen-api.listennotes.com/api/v2"

private val httpClient = OkHttpClient.Builder()
    .addInterceptor(
        Interceptor { chain ->
            val builder = chain.request().newBuilder()
                .header("X-ListenAPI-Key", "bf54986bcb1440e79e996875bf884c22")
                .build()

            return@Interceptor chain.proceed(builder)
        }
    )
    .build()

interface ApiService {

    companion object {
        fun getService(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}