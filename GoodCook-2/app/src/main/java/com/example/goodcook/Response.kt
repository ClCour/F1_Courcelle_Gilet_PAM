package com.example.goodcook

import kotlinx.serialization.Serializable

@Serializable
data class Response(val offset: Int, val number: Int, val results: List<CookItem>, val totalResults: Int)
