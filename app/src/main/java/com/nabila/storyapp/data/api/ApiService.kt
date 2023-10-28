package com.nabila.storyapp.data.api

import com.nabila.storyapp.data.response.AddStoryResponse
import com.nabila.storyapp.data.response.DetailResponse
import com.nabila.storyapp.data.response.LoginResponse
import com.nabila.storyapp.data.response.RegisterResponse
import com.nabila.storyapp.data.response.StoryResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): RegisterResponse

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("stories")
    suspend fun getStories(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): StoryResponse

    @GET("stories/{id}")
    fun detailStory(
        @Header("Authorization") token: String,
        @Path("id") id: String
    ): Call<DetailResponse>

    @Multipart
    @POST("stories")
    suspend fun addStory(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("description") description: RequestBody,
    ): AddStoryResponse

    @GET("stories")
    fun getStoriesWithLocation(
        @Header("Authorization") token: String,
        @Query("location") location : Int = 1
    ): Call<StoryResponse>
}