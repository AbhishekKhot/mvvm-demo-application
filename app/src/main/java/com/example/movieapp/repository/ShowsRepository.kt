package com.example.movieapp.repository

import com.example.movieapp.api.ApiInterface
import javax.inject.Inject

class ShowsRepository
@Inject
constructor(private val apiInterfaceService: ApiInterface) {
    suspend fun shows() = apiInterfaceService.getShowsDetail()
}