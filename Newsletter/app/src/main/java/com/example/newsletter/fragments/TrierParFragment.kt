package com.example.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.newsletter.NavigationListener
import com.example.newsletter.R


class TrierParFragment: Fragment(){
    private lateinit var spinner_pays: Spinner
    private lateinit var spinner_categorie: Spinner




    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.article_trier, container, false)
        spinner_pays = view.findViewById(R.id.spinner_pays)
        spinner_categorie = view.findViewById(R.id.spinner_categorie)

        val pays=spinner_pays.getSelectedItem().toString()

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
                it.showFragment(ListArticleFragment())
            }
        }
//        if (id == R.id.action_Favori) {
//            (activity as? NavigationListener)?.let {
//                it.showFragment()
//            }
//        }
//        if (id == R.id.action_nous) {
//            (activity as? NavigationListener)?.let {
//                it.showFragment()
//            }

//        }

        return super.onOptionsItemSelected(item)

    }

}

