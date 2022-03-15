package com.example.fishwatch.view.fishDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fishwatch.databinding.FragmentDetailsBinding
import com.example.fishwatch.data.model.FishResponse


class DetailsFragment : Fragment() {
    private lateinit var viewModel: DetailsFragmentViewModel
    private lateinit var binding: FragmentDetailsBinding
    // the initial was set to zero

    private lateinit var fishArg: FishResponse
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            fishArg = DetailsFragmentArgs.fromBundle(it).fishArg
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        binding.fish = this.fishArg
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailsFragmentViewModel::class.java)

        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.fishLiveData.observe(viewLifecycleOwner, Observer { fish ->
            fish?.let {
                binding.fish = fish

            }
        })
    }
}
