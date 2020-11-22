package com.example.newsletter.fragments

import android.os.Bundle
import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.newsletter.NavigationListener
import com.example.newsletter.R


class AboutUsFragment:Fragment() {
    private lateinit var git: TextView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.about_us, container, false)
        git = view.findViewById(R.id.git)
        git.isClickable = true
        git.movementMethod = LinkMovementMethod.getInstance()
        val text = "<a href='https://github.com/maximeestia/AndroidStudioProjects/tree/main/Newsletter'> Git </a>"
        git.text = Html.fromHtml(text)

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
                it.showFragment(ListArticleFragment("all", "all"))
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