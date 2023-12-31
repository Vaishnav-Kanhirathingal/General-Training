package com.example.retrofit.api

import com.example.retrofit.data.brands_list.BrandsList
import com.example.retrofit.data.product_list.ProductsList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

var retrofit: Retrofit = Retrofit
    .Builder()
    .baseUrl("https://automationexercise.com/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val retroService by lazy { retrofit.create(AutomationExerciseApi::class.java) }

interface AutomationExerciseApi {
    @GET("productsList")
    suspend fun getProductList(): ProductsList

    @GET("brandsList")
    suspend fun getBrandsList(): BrandsList

    @POST("searchProduct")
    @FormUrlEncoded
    suspend fun searchProduct(@Field("search_product") body: String): ProductsList
}