package com.example.goodcook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.example.goodcook.databinding.ErreurRecipeFragmentBinding
import com.example.goodcook.databinding.FragmentErreurBinding
import com.example.goodcook.databinding.FragmentMenuBinding

class ErreurRecipeFragment : Fragment() {
    private var _binding: ErreurRecipeFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = ErreurRecipeFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonRetour.setOnClickListener {
            findNavController().navigate(R.id.action_ErreurRecipeFragment_to_MenuFragment)
        }
    }
}