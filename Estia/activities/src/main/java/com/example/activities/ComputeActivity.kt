package com.example.activities

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ComputeActivity : AppCompatActivity(), TextWatcher {
    private lateinit var computeButton: Button
    private lateinit var instanceText: TextView
    private lateinit var champ1: EditText
    private lateinit var champ2: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        computeButton = findViewById(R.id.btn_calculer)
        instanceText = findViewById(R.id.resultat)
        champ1 = findViewById(R.id.field_1)
        champ2 = findViewById(R.id.field_2)
        champ1.inputType = InputType.TYPE_CLASS_NUMBER
        champ2.inputType = InputType.TYPE_CLASS_NUMBER
        computeButton.setOnClickListener {
            val champ1 = champ1.text.toString().toIntOrNull() ?: 0
            val champ2 = champ2.text.toString().toIntOrNull() ?: 0
            val resultat = champ1 + champ2
            instanceText.text = "$resultat"

        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        computeButton.isEnabled = champ1.text.isNotBlank() && champ2.text.isNotBlank()
    }

    override fun afterTextChanged(s: Editable?) {

    }
}


