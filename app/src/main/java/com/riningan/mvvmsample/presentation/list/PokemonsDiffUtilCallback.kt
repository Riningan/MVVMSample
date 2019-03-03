package com.riningan.mvvmsample.presentation.list

import androidx.recyclerview.widget.DiffUtil
import com.riningan.mvvmsample.data.model.PokemonResponse


class PokemonsDiffUtilCallback : DiffUtil.ItemCallback<PokemonResponse>() {
    override fun areItemsTheSame(oldItem: PokemonResponse, newItem: PokemonResponse) = oldItem.name == newItem.name

    override fun areContentsTheSame(oldItem: PokemonResponse, newItem: PokemonResponse) = oldItem == newItem
}