package com.example.newsletter.fragments

import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.example.newsletter.R
import com.example.newsletter.models.Article
import androidx.databinding.DataBindingUtil
import com.example.newsletter.data.Article
import com.google.android.material.snackbar.Snackbar
import javax.security.auth.callback.Callback


class ArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentArticleBinding>(
            inflater,
            R.layout.article_item,
            container,

        ).apply {
            viewModel = article
            lifecycleOwner = ViewLifcycleOwner
            callback = Callback { article ->
                article?.let{
                    hideAppbarFab(fab)
                    Article.addArticleToFavoris()
                    snackbar.make(root,"Added to favoris", Snackbar.LENGTH_LONG)
                        .show()
                }

            }
        }
        return binding.root
    }



}