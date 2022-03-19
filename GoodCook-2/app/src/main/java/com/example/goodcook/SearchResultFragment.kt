package com.example.goodcook
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.goodcook.databinding.FragmentMenuBinding
import kotlinx.coroutines.launch

class SearchResultFragment : Fragment() {
    private var _binding: FragmentMenuBinding? = null
    var test : Boolean = true

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_search_result, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var APIfood = APIFoodGestion()
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val query: String? = arguments?.getString("query") //recup query dans argument

        APIfood.liveData.observe(viewLifecycleOwner) { cookItems ->

            recyclerView.adapter = CookListAdapter(cookItems) { cookItem ->
                val idItem: String = cookItem.id.toString()
                ChangeFragment(view, idItem)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            if (query != null) {
                test = APIfood.requestAPI(query)
                if (!test){
                    ChangeFragment2(view)
                }
            }
        }
    }
    fun ChangeFragment(view: View, query: String){
        val bundle = bundleOf("query" to query)
        findNavController().navigate(R.id.action_SearchFragment_to_RecipeFragment, bundle)
    }
    fun ChangeFragment2(view: View){
        //val bundle = bundleOf("query" to query)
        findNavController().navigate(R.id.action_SearchResultFragment_to_ErreurFragment)
    }
}