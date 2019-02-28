package com.riningan.mvvmsample.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.riningan.mvvmsample.R
import com.riningan.mvvmsample.data.model.PokemonResponse
import com.riningan.mvvmsample.databinding.ItemPokemonsListBinding


class PokemonsAdapter(private val mListener: ItemClickListener) : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {
    private val mPokemons = mutableListOf<PokemonResponse>()


    override fun getItemCount() = mPokemons.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemPokemonsListBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_pokemons_list,
            parent,
            false
        )
        binding.listener = mListener
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.pokemon = mPokemons[position]
    }


    interface ItemClickListener {
        fun onClick(pokemonModel: PokemonResponse)
    }


    class ViewHolder(val binding: ItemPokemonsListBinding) : RecyclerView.ViewHolder(binding.root)


    companion object {
        @JvmStatic
        @BindingAdapter("pokemons")
        fun RecyclerView.bindItems(pokemons: List<PokemonResponse>) {
            (adapter as PokemonsAdapter).apply {
                mPokemons.clear()
                mPokemons.addAll(pokemons)
                notifyDataSetChanged()
            }
        }

        @JvmStatic
        @BindingAdapter("clickListener")
        fun bindListAdapter(recyclerView: RecyclerView, clickListener: ItemClickListener) {
            recyclerView.adapter = PokemonsAdapter(clickListener)
        }
    }
}