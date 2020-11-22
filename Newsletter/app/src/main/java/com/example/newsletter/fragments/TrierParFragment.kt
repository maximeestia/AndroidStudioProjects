package com.example.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.newsletter.NavigationListener
import com.example.newsletter.R


class TrierParFragment: Fragment(){
    private lateinit var spinner_pays: Spinner
    private lateinit var spinner_categorie: Spinner
    private lateinit var button_pays : Button
    private lateinit var button_source : Button
    private lateinit var button_categorie : Button
    private lateinit var source: EditText




    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.article_trier, container, false)
        spinner_pays = view.findViewById(R.id.spinner_pays)
        spinner_categorie = view.findViewById(R.id.spinner_categorie)
        source = view.findViewById(R.id.edit_source)
        button_pays = view.findViewById(R.id.edit_button_pays)
        button_source = view.findViewById(R.id.edit_button_source)
        button_categorie = view.findViewById(R.id.edit_button_categorie)

        button_pays.setOnClickListener {
            val pays = spinner_pays.selectedItem.toString()
            (activity as? NavigationListener)?.let {
                it.showFragment(ListArticleFragment(pays, "pays"))
            }
        }
        button_source.setOnClickListener {
            val source = source.text.toString()
            (activity as? NavigationListener)?.let {
                it.showFragment(ListArticleFragment(source, "source"))

            }
        }
        button_categorie.setOnClickListener {
            val categorie = spinner_categorie.selectedItem.toString()
            (activity as? NavigationListener)?.let {
                it.showFragment(ListArticleFragment(categorie, "categorie"))
            }
        }


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

