package com.example.neighbors.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.neighbors.R
import com.example.neighbors.data.NeighborRepository
import com.example.neighbors.data.service.DummyNeighborApiService
import com.example.neighbors.models.Neighbor
import com.example.neighbors.neighborsActivity

class AddNeighbourFragment : Fragment(), TextWatcher {
    private lateinit var name: EditText
    private lateinit var image: EditText
    private lateinit var telephone: EditText
    private lateinit var webset: EditText
    private lateinit var adresse: EditText
    private lateinit var more: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbor, container, false)
        val nombre = NeighborRepository.getInstance().getNeighbours().size.toLong() + 1

        name = view.findViewById(R.id.edit_nom)
        image = view.findViewById(R.id.edit_image_2)
        telephone = view.findViewById(R.id.edit_telelphone)
        webset = view.findViewById(R.id.edit_webste)
        adresse = view.findViewById(R.id.edit_adresse)
        more = view.findViewById(R.id.edit_more)
        name.addTextChangedListener(this)
        image.addTextChangedListener(this)
        telephone.addTextChangedListener(this)
        webset.addTextChangedListener(this)
        adresse.addTextChangedListener(this)
        more.addTextChangedListener(this)
        saveButton = view.findViewById(R.id.edit_button)
        saveButton.isEnabled = false
        saveButton.setOnClickListener {
            val neighbors = Neighbor(
                nombre,
                name.text.toString(),
                image.text.toString(),
                adresse.text.toString(),
                telephone.text.toString(),
                more.text.toString(),
                false,
                webset.text.toString()
            )

            NeighborRepository.getInstance().addNeighbours(neighbors)


        }


        return view
    }

    fun emailValide(email: String): Boolean {
        return (email.contains("@"))
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        saveButton.isEnabled = name.text.isNotBlank() &&
                image.text.isNotBlank() &&
                adresse.text.isNotBlank() &&
                telephone.text.isNotBlank() &&
                more.text.isNotBlank() &&
                webset.text.isNotBlank()
    }

    override fun afterTextChanged(s: Editable?) {
    }
}