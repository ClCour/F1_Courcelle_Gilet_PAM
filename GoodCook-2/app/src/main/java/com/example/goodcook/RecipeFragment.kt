package com.example.goodcook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.goodcook.databinding.FragmentMenuBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class RecipeFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    var testRecipe : Boolean = true

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_recipe, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var APIfood = APIFoodGestion()
        super.onViewCreated(view, savedInstanceState)
        val mImageView: ImageView = view.findViewById(R.id.imageView2)
        val query: String? = arguments?.getString("query") //recup query dans argument
        var url: String

        APIfood.liveDataRecipe.observe(viewLifecycleOwner) {
                urlResponse ->
            url = urlResponse
            Picasso.get().load(url).into(mImageView)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            if (query != null) {
                testRecipe = APIfood.requestRecipe(query.toString())
                if (!testRecipe){
                    ChangeFragment(view)
                }

            }
        }
    }
    fun ChangeFragment(view: View){
        findNavController().navigate(R.id.action_RecipeFragment_to_ErreurRecipeFragment)
    }
}