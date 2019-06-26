package com.example.baixadasatistamaps

import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateGrid()
    }

    private fun populateGrid() {
        val gridView = findViewById<View>(R.id.base_grid) as GridView

        gridView.adapter = ImageAdapter()
        gridView.setNumColumns(3)

        val res: Resources = resources
        val city_names = res.getStringArray(R.array.string_array_images_baixada)

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, view, i, _ ->
            val city = "${city_names[i]} + , SP, Brazil".replace(' ', '+')
            val geoIntent: Intent
            geoIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$city"))
            startActivity(geoIntent)
        }
    }
}
