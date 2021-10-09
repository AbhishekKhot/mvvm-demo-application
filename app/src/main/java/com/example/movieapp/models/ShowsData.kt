package com.example.movieapp.models

data class ShowsData(
    val id: Int,
    val name: String,
    val image: Image,
    val language: String,
    val rating: Rating,
    val runtime: Int,
    val type: String,
)