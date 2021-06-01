package com.bme.aut.craftedcocktails.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bme.aut.craftedcocktails.R
import com.bme.aut.craftedcocktails.model.Cocktail
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.cocktail_item.view.*

class CocktailsAdapter(
    private val context: Context,
    private val clickListener: (Cocktail) -> Unit,
    private val longClickListener: (Cocktail) -> Boolean
) : ListAdapter<Cocktail, CocktailsAdapter.ViewHolder>(object : DiffUtil.ItemCallback<Cocktail>() {
    override fun areItemsTheSame(oldItem: Cocktail, newItem: Cocktail) =
        oldItem.idDrink == newItem.idDrink

    override fun areContentsTheSame(oldItem: Cocktail, newItem: Cocktail) =
        oldItem == newItem
}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.cocktail_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(getItem(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(cocktail: Cocktail) {
            itemView.cocktail_name.text = cocktail.strDrink
            itemView.cocktail_type.text = cocktail.strAlcoholic
            itemView.cocktail_thumbnail

            itemView.setOnClickListener {
                clickListener(cocktail)
            }
            itemView.setOnLongClickListener {
                longClickListener(cocktail)
            }

            Glide.with(itemView.cocktail_thumbnail)
                .load(cocktail.strDrinkThumb)
                .into(itemView.cocktail_thumbnail)
        }
    }
}