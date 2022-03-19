package com.example.goodcook
//Connexion a l'API spoonacular
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.webkit.URLUtil
import androidx.core.os.bundleOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
class APIFoodGestion : ViewModel() {
        val liveData: MutableLiveData<List<CookItem>> = MutableLiveData(listOf())
        val liveDataRecipe:MutableLiveData<String> = MutableLiveData()

        //2 apiKey dans le cas ou on a depasse le nombre de requetes autorisees en 24h
        val apiKey = "09c563aa700b4f2f99989679c2ae2a2f"
        //val apiKey = "5dfff41abf464072bf5558b058bffee9"

        val client = HttpClient()
        suspend fun requestAPI(query: String): Boolean {
            val test: Boolean
            val url = "https://api.spoonacular.com/recipes/complexSearch?query=$query&number=60&apiKey=$apiKey"
            val response: HttpResponse = client.request(url)
            val stringBody: String = response.receive()

            //On extrait de la reponse le resultat car s'il est vide, rien ne sera affiche (pas de recette correspondant a la query)
            val delim = ":"
            val list = stringBody.split(delim)
            val test_string : String = list[1].split(",")[0]
            if (stringBody !=null && test_string!="[]") {
                val obj = Json.decodeFromString<Response>(stringBody)
                liveData.value = obj.results
                test = true
            }
            else
                test = false
            return test
        }

        suspend fun requestRecipe(idItem: String): Boolean {
            var testRecipe: Boolean
            try{
                val url = "https://api.spoonacular.com/recipes/$idItem/card?&apiKey=$apiKey"
                val reciperesponse: HttpResponse = client.request(url)
                val stringBody: String = reciperesponse.receive()
                val obj = Json.decodeFromString<RecipeResponse>(stringBody)
                liveDataRecipe.value = obj.url
                testRecipe = true
            }
            catch(e : ClientRequestException){
                testRecipe = false
            }
            return testRecipe
        }
}