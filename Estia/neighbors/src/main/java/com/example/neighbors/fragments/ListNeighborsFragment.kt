package com.example.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neighbors.NavigationListener
import com.example.neighbors.R
import com.example.neighbors.adapters.ListNeighborHandler
import com.example.neighbors.data.NeighborRepository
import com.example.neighbors.models.Neighbor
import com.example.neighbors.neighborsActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mbds.myapplication.adapters.ListNeighborsAdapter

class ListNeighborsFragment: Fragment(),ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNeighbor: FloatingActionButton
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        return inflater.inflate(R.layout.list_neighbors_fragment, container, false)
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
//        addNeighbor = view.findViewById(R.id.addNeighbor)
//        neighborsActivity.updateTitle("Liste des voisins")
//        (activity as? NavigationListener)?.let {
//            it.updateTitle(R.string.list_neighbours_toolbar_name)
//        }
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        addNeighbor = view.findViewById(R.id.addNeighbor)
        addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
            }
        }
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors)
        recyclerView.adapter = adapter

        
    }

    override fun deleteNeighbour(neighbor: Neighbor) {
        TODO("Not yet implemented")
    }
}