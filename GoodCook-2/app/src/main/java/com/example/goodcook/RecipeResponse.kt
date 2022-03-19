package com.example.goodcook
import kotlinx.serialization.Serializable
//Definition de la reponse qui permet d'obtenir les infos sur une recette en particulier
@Serializable
data class RecipeResponse (val url:String="", val status:String="", val code:Int=0, val time:String="", val message:String="")
