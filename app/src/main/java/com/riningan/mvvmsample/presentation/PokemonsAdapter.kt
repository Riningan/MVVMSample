package com.riningan.mvvmsample.presentation

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.riningan.mvvmsample.data.PokemonModel


class PokemonsAdapter(private val mItemClickListener: ItemClickListener) : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {
    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    interface ItemClickListener {
        fun onClick(pokemonModel: PokemonModel)
    }


    class ViewHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {

//        var titleTv = itemVIew.findViewById<TextView>(R.id.title_tv)
//        var descTv = itemVIew.findViewById<TextView>(R.id.desc_tv)


        fun bind(pokemonModel: PokemonModel) {
//            titleTv.text = article.title
//            descTv.text = article.description
        }
    }
}