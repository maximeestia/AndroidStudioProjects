package com.example.neighbors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.neighbors.fragments.AddNeighbourFragment
import com.example.neighbors.fragments.ListNeighborsFragment

class neighborsActivity : AppCompatActivity() ,NavigationListener {
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.neighbors_neighbors)
        toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(toolbar)
       // showFragment(AddNeighbourFragment())
        showFragment(ListNeighborsFragment())
    }

    override fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }
    override fun updateTitle(title: Int) {
        toolbar.setTitle(title)
    }
}