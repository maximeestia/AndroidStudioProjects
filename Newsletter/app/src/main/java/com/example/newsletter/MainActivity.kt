package com.example.newsletter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.newsletter.fragments.ListArticleFragment

class MainActivity : AppCompatActivity(),NavigationListener {
    private lateinit var toolbar: Toolbar
    lateinit var mon_editText: EditText
    var isFavori:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.article_article)
        toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(toolbar)
        // showFragment(AddNeighbourFragment())
        showFragment(ListArticleFragment())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.mon_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item?.itemId)
        {

            R.id.configuration -> { Toast.makeText(this,"Paramètres",Toast.LENGTH_LONG).show() }

        }
        return true
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