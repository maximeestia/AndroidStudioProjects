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
import com.example.newsletter.models.Article


class ListArticlesAdapter(
        items: List<Article>
) : RecyclerView.Adapter<ListArticlesAdapter.ViewHolder>() {

    private val mArticles: List<Article> = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article: Article = mArticles[position]
        // Display Neighbour Name
        holder.mArticleTitre.text = article.title
        holder.mArticleAuteur.text = article.author
        holder.mArticleDate.text = article.publishedAt
        holder.mArticleAppercu.text = article.description

        val context = holder.mArticleTitre.context
// Display Neighbour Avatar
        Glide.with(context)
                .load(article.urlToImage)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_baseline_image_not_supported_24)
                .error(R.drawable.ic_baseline_image_not_supported_24)
                .skipMemoryCache(false)
                .into(holder.mArticleImage)
    }

    override fun getItemCount(): Int {
        return mArticles.size
    }

    class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
        val mArticleImage: ImageView
        val mArticleTitre: TextView
        val mArticleAuteur: TextView
        val mArticleDate: TextView
        val mArticleAppercu: TextView
        val mArticleFavori: ImageButton

        init {
            // Enable click on item
            mArticleImage = view.findViewById(R.id.item_list_article)
            mArticleTitre = view.findViewById(R.id.item_list_title)
            mArticleAuteur = view.findViewById(R.id.item_list_author)
            mArticleDate = view.findViewById(R.id.item_list_date)
            mArticleAppercu = view.findViewById(R.id.item_list_appercu)
            mArticleFavori = view.findViewById(R.id.item_list_favorite_button)
        }
    }
}