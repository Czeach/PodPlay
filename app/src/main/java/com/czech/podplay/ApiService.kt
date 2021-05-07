package com.czech.podplay

import com.czech.podplay.models.Curated
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val BASE_URL = "https://listen-api.listennotes.com/api/v2/"

private val httpClient = OkHttpClient.Builder()
    .addInterceptor(
        Interceptor { chain ->
            val builder = chain.request().newBuilder()
                .header("X-ListenAPI-Key", BuildConfig.API_KEY)
                .build()

            return@Interceptor chain.proceed(builder)
        }
    )
    .build()

//val retrofit2 = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addCallAdapterFactory(CoroutineCallAdapterFactory())
//    .addConverterFactory(GsonConverterFactory.create())
//    .client(httpClient)
//    .build()

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

//    @GET("curated_podcasts")
//    fun getCurated(
//        @Query("page") page: Int
//    ): Call<Curated>
}

//object PodcastApi {
//    val retrofitService: ApiService by lazy {
//        retrofit2.create(ApiService::class.java)
//    }
//}