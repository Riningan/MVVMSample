package com.riningan.mvvmsample.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.riningan.mvvmsample.R
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.databinding.ItemListBinding
import com.squareup.picasso.Picasso


class PokemonsAdapter(private val mListener: ItemClickListener,
                      pokemonsDiffUtilCallback: PokemonsDiffUtilCallback) : PagedListAdapter<PokemonResponse, PokemonsAdapter.ViewHolder>(pokemonsDiffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemListBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_list,
                parent,
                false
        )
        binding.listener = mListener
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.pokemon = getItem(position)
    }


    interface ItemClickListener {
        fun onClick(pokemonResponse: PokemonResponse)
    }


    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)


    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun bindImageUrl(view: ImageView, url: String) {
            Picasso.get().load(url).into(view)
        }
    }
}