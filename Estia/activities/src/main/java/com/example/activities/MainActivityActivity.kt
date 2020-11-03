package com.example.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivityActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var instanceText: TextView
    private lateinit var computeButton: Button
    private var nbClick = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        clickButton = findViewById(R.id.btn_click_me)
        instanceText= findViewById(R.id.text_field)
        computeButton =findViewById(R.id.btn_compute)
        if (nbClick==0){
            instanceText.isEnabled=false
        }
        clickButton.setOnClickListener {
            if (nbClick>=4){
                clickButton.isEnabled=false
            }
            instanceText.isEnabled=true
            nbClick++

            val newText = "Vous avez cliquez $nbClick fois "
            instanceText.text=newText
        }
        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
    }

}
