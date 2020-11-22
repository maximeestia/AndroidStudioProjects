package com.example.newsletter.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.NavigationListener
import com.example.newsletter.R
import com.example.newsletter.adapters.ListArticlesAdapter
import com.example.newsletter.data.Article
import com.example.newsletter.data.ArticleRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ListArticleFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var trier_par: FloatingActionButton



    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.article_list_fragment, container, false)

        recyclerView = view.findViewById(R.id.article_list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                )
        )

//        detailleArticle = view.findViewById(R.id.more_button)
//        detailleArticle.setOnClickListener {
//            (activity as? NavigationListener)?.let {
//                it.showFragment(ArticleDetailFragment())
//            }
//        }
         trier_par= view.findViewById(R.id.Trier_par)
        trier_par.setOnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(TrierParFragment())
            }
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArticles()
        setHasOptionsMenu(true);

    }
    /**
     * Récupère la liste des articles dans un thread secondaire
     */
    private fun getArticles() {
        lifecycleScope.launch(Dispatchers.IO) {
             val articles = ArticleRepository.getInstance().getArticles()
             bindData(articles)
        }



    }

    /**
     * Rempli le recyclerview avec les données récupérées dans le web service
     * Cette action doit s'effectuer sur le thread principale
     * Car on ne peut mas modifier les éléments de vue dans un thread secondaire
     */
    private fun bindData(articles: List<Article>) {
        lifecycleScope.launch(Dispatchers.Main) {
            //créer l'adapter
            //associer l'adapteur au recyclerview
            val adapter = ListArticlesAdapter(articles)
            recyclerView.adapter = adapter


        }
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