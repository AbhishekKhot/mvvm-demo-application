package com.example.movieapp.api

import com.example.movieapp.util.Constants
import com.example.movieapp.models.ApiResponse
import retrofit2.http.GET
import retrofit2.Response

interface ApiInterface {

    @GET(Constants.END_POINT)
    suspend fun getShowsDetail():Response<ApiResponse>

}