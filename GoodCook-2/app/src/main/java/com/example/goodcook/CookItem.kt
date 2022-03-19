package com.example.goodcook

import kotlinx.serialization.Serializable
//Definition des differentes recettes
@Serializable
data class CookItem (val id:Int=0, val title: String="nul", val image: String="nul", val imageType:String="nul")
