package com.example.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsletter.R
import com.example.newsletter.data.Article
import com.example.newsletter.data.Source

class ListSourceAdapter (
        items: List<Source>
    ) : RecyclerView.Adapter<ListSourceAdapter.ViewHolder>() {

        private val mSources: List<Source> = items
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.source_item, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val source: Source = mSources[position]
            // Display Neighbour Name
            holder.mSourceName.text = source.name
            holder.mSourceDescription.text = source.description
            holder.mSourceCategory.text = source.category
            holder.mSourceLanguage.text = source.language
            holder.mSourceCountry.text = source.country


        }

        override fun getItemCount(): Int {
            return mSources.size
        }

        class ViewHolder(view: View) :
                RecyclerView.ViewHolder(view) {
            val mSourceName: TextView
            val mSourceDescription: TextView
            val mSourceCategory: TextView
            val mSourceLanguage: TextView
            val mSourceCountry: TextView

            init {
                // Enable click on item
                mSourceName = view.findViewById(R.id.item_source_name)
                mSourceDescription = view.findViewById(R.id.item_source_description)
                mSourceCategory = view.findViewById(R.id.item_source_categorie)
                mSourceLanguage = view.findViewById(R.id.item_source_langue)
                mSourceCountry = view.findViewById(R.id.item_source_country)
            }
        }
}