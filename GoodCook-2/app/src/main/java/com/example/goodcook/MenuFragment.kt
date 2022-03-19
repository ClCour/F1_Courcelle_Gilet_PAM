package com.example.goodcook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.goodcook.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonRecetteJour.setOnClickListener {
            findNavController().navigate(R.id.action_MenuFragment_to_SearchFragment)
        }
        binding.buttonSale.setOnClickListener {
            val query: String = "main course"
            ChangeFragmentSale(view, query)

        }
        binding.buttonSucre.setOnClickListener {
            val query: String = "dessert"
            ChangeFragmentSucre(view, query)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun ChangeFragmentSale(view: View, query: String){
        val bundle = bundleOf("query" to query)
        findNavController().navigate(R.id.action_MenuFragment_to_SearchMenuFragment, bundle)
    }
    fun ChangeFragmentSucre(view: View, query: String){
        val bundle = bundleOf("query" to query)
        findNavController().navigate(R.id.action_MenuFragment_to_SearchMenuFragment, bundle)
    }
}