package com.example.fishwatch.view.fishList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.fishwatch.R
import com.example.fishwatch.databinding.ItemFishBinding
import com.example.fishwatch.data.model.FishResponse

class FishListAdapter(private val fishList: ArrayList<FishResponse>) :
    RecyclerView.Adapter<FishListAdapter.FishViewHolder>() {
    inner class FishViewHolder(val binding: ItemFishBinding) :
        RecyclerView.ViewHolder(binding.root)


    fun updateFishList(newNewsList: List<FishResponse>) {
        fishList.clear()
        fishList.addAll(newNewsList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ItemFishBinding>(inflater, R.layout.item_fish, parent, false)
        return FishViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FishViewHolder, position: Int) {
        holder.binding.fish = fishList[position]

        holder.binding.root.setOnClickListener {
            val action =
                ListFragmentDirections.actionListFragmentToDetailsFragment(fishList[position])
           // Navigation.findNavController(it).navigate(action)
            Navigation.findNavController(it).navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return fishList.size
    }
}