package com.example.clase05

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CovidCaseDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_case_detail)

            val case = intent.getParcelableExtra<CovidCase>("case")
            findViewById<TextView>(R.id.titleLabel).text = "Covid Case Detail from ${case?.date}"
            findViewById<TextView>(R.id.dateLabel).text = "${case?.date}"
            findViewById<TextView>(R.id.positiveLabel).text = "${case?.positive}"
            findViewById<TextView>(R.id.negativeLabel).text = "${case?.negative}"


    }
}