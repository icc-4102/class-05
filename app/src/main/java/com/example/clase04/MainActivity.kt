package com.example.clase04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.text.set
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {


    lateinit var covidRecyclerView: RecyclerView
    lateinit var adapter: CovidRecyclerViewAdapter
    lateinit var cases: Array<CovidCase>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycler_view)
        covidRecyclerView = findViewById(R.id.covid_recycler_view)
        covidRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CovidRecyclerViewAdapter()
        //Se designa el adaptador para la recyclerView
        covidRecyclerView.adapter = adapter
        //Libreria externa para transformar un json a data class
        val gson = Gson()
        cases = gson.fromJson(dataJson,Array<CovidCase>::class.java)

        //Boton que agrega un caso al recycler view
        val addCaseButton = findViewById<Button>(R.id.add_case_button)
        addCaseButton.setOnClickListener {
            adapter.addCase(cases[0])
            // Metodo que lo ordena nuevamente, se utiliza para que no entregue el mismo siempre
            cases.shuffle()
        }
    }



}