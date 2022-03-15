package com.example.fishwatch.view.fishList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fishwatch.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private lateinit var viewModel: ListFragmentViewModel
    private var fishAdapter = FishListAdapter(arrayListOf())
    private lateinit var binding: FragmentListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ListFragmentViewModel::class.java)
        viewModel.refresh()

        binding.fishListRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = fishAdapter


        }
        binding.refreshLayout.setOnRefreshListener {
            binding.fishListRv.visibility = View.GONE
            binding.listError.visibility = View.GONE
            binding.loadingBar.visibility = View.VISIBLE
            //viewModel.refreshBypassCache()
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }

        observerViewModel()
    }

    fun observerViewModel() {
        viewModel.fish.observe(viewLifecycleOwner, Observer { fish ->
            fish?.let {
                binding.fishListRv.visibility = View.VISIBLE
                fishAdapter.updateFishList(fish)
            }

        })
        viewModel.fishLoadingError.observe(viewLifecycleOwner, Observer { isError ->
            isError?.let {
                binding.listError.visibility = if (it) View.VISIBLE else View.GONE

            }
        })
        viewModel.loading.observe(viewLifecycleOwner, Observer { isLoading ->
            isLoading?.let {
                binding.loadingBar.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    binding.listError.visibility = View.GONE
                    binding.fishListRv.visibility = View.GONE
                }
            }
        })

    }

}