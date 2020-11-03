package com.example.estia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Afficher une page web
//        showWebPage()
        //Appeler un numero
//        callMe()
    }
    //Fonction permet afficher page web
        fun showWebPage(){
            val chemin: Uri = Uri.parse("http://www.google.fr")
            val naviguer: Intent = Intent(Intent.ACTION_VIEW, chemin)
        startActivity(naviguer)
        }
    //Fonction permet appeler
    fun callMe(){
        val numero : Uri = Uri.parse("tel:0673289552")
        val appeler : Intent = Intent (Intent.ACTION_VIEW,numero)
        startActivity(appeler)
    }

}