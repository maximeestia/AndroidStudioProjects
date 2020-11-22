package com.example.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsletter.NavigationListener
import com.example.newsletter.R
import com.example.newsletter.data.Article

class ArticleDetailFragment(article: Article): Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.article_detaille, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true);

    }





    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.action_home) {
            (activity as? NavigationListener)?.let {
                it.showFragment(ListArticleFragment("all","all"))
            }
        }
//        if (id == R.id.action_Favori) {
//            (activity as? NavigationListener)?.let {
//                it.showFragment()
//            }
//        }
        if (id == R.id.action_nous) {
            (activity as? NavigationListener)?.let {
                it.showFragment(AboutUsFragment())
            }

        }

        return super.onOptionsItemSelected(item)

    }

}
