package com.example.newsletter.fragments

import ListArticleHandler
import android.os.Bundle
import android.view.*
import android.widget.ListAdapter
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


//class ListArticleFragment(query:String,nomTrier:String): Fragment(),ListArticleHandler {
class ListArticleFragment(query:String,nomTrier:String): Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var trier_par: FloatingActionButton
    private val query =query
    private val nomTrier=nomTrier



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
        getArticles(this.query,this.nomTrier)
        setHasOptionsMenu(true);

    }
    /**
     * Récupère la liste des articles dans un thread secondaire
     */
    private fun getArticles(query: String, nomTrier: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            lateinit var articles: List<Article>
            if (nomTrier == "pays") {
                articles = ArticleRepository.getInstance().getCountryArticle(query)

            }
            if (nomTrier == "source") {
                articles = ArticleRepository.getInstance().getEditeurArticle(query)

            }
            if (nomTrier == "categorie") {
                articles = ArticleRepository.getInstance().getCategorieArticle(query)

            }
            if (nomTrier == "all") {
                articles = ArticleRepository.getInstance().getArticles()

            }


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
            //val adapter = ListArticlesAdapter(articles,this@ListArticleFragment)
            val adapter = ListArticlesAdapter(articles)
            recyclerView.adapter = adapter


        }
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

//    override fun selectArticle(article: Article) {
//      it.it.showFragment(ArticleDetailFragment(article))
//    }

}