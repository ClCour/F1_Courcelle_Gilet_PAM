package com.example.goodcook

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.goodcook.databinding.FragmentMenuBinding
import com.squareup.picasso.Picasso

//Permet de representer visuellement un element de la liste de donnees dans le RecyclerView (Une ligne)
class CookItemViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.activity_cook_item, parent, false)) {
    private var _binding: FragmentMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    fun bind(cookItem: CookItem) {
        val mTitleView: TextView = itemView.findViewById(R.id.Title)
        val mImageView: ImageView = itemView.findViewById(R.id.imageView)


        mTitleView?.text = cookItem.title
        val mUrlView = cookItem.image

        Picasso.get().load(mUrlView).into(mImageView);

        }
    }
