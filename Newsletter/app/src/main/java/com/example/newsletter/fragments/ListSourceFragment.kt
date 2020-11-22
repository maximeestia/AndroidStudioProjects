package com.example.newsletter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.NavigationListener
import com.example.newsletter.R
import com.example.newsletter.adapters.ListArticlesAdapter
import com.example.newsletter.data.Source
import com.example.newsletter.data.SourcesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListSourceFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView




    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.source_list_fragment, container, false)

        recyclerView = view.findViewById(R.id.source_list)
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


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCountrySources()
        setHasOptionsMenu(true);

    }
    /**
     * Récupère la liste des sources dans un thread secondaire
     */
    private fun getCountrySources() {
        lifecycleScope.launch(Dispatchers.IO) {
            val sources = SourcesRepository.getInstance().getCountrySources()
            bindData(sources)
        }



    }

    /**
     * Rempli le recyclerview avec les données récupérées dans le web service
     * Cette action doit s'effectuer sur le thread principale
     * Car on ne peut mas modifier les éléments de vue dans un thread secondaire
     */
    private fun bindData(sources: List<Source>) {
        lifecycleScope.launch(Dispatchers.Main) {
            //créer l'adapter
            //associer l'adapteur au recyclerview
            val adapter = ListArticlesAdapter(sources)
            recyclerView.adapter = adapter


        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.action_pays) {
            (activity as? NavigationListener)?.let {
                it.showFragment(ListPaysFragment())
            }
        }
        if (id == R.id.action_categories) {
            (activity as? NavigationListener)?.let {
                it.showFragment(ListSourceFragment())
            }
        }
        if (id == R.id.action_editeurs) {
            (activity as? NavigationListener)?.let {
                it.showFragment(ListEditeursFragement())
            }

        }

        return super.onOptionsItemSelected(item)

    }

}
}