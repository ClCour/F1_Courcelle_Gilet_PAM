package com.example.goodcook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.goodcook.databinding.FragmentMenuBinding

class SearchFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    val APIfood = APIFoodGestion()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button: Button = view.findViewById(R.id.button)
        button.setOnClickListener{
            val query: String = view.findViewById<EditText>(R.id.editText).text.toString() //recup query dans argument
            ChangeFragment(view, query)
        }
    }
    fun ChangeFragment(view: View, query: String){
        val bundle = bundleOf("query" to query)
        findNavController().navigate(R.id.action_SearchFragment_to_SearchResultFragment, bundle)
    }
}

