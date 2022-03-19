package com.example.goodcook

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView

//Permet de faire la liaison entre la vue RecyclerView et une liste de donnees.
//C’est le cœur de l'affichage de la liste dans une application.
class CookListAdapter(val cooks: List<CookItem>, val onRecipeClickedListener: OnRecipeClickedListener): RecyclerView.Adapter<CookItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return CookItemViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: CookItemViewHolder, position: Int) {
        val cookItem: CookItem = cooks[position]
        holder.bind(cookItem)
        holder.itemView.setOnClickListener{
            onRecipeClickedListener.onRecipeClicked(cookItem)
        }
    }

    override fun getItemCount(): Int {
        return cooks.size
    }

}
fun interface OnRecipeClickedListener{
    fun onRecipeClicked(cookItem : CookItem)
}