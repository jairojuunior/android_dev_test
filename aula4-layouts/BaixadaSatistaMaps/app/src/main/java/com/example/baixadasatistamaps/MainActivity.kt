package com.example.baixadasatistamaps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast

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
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, view, i, _ ->
            val city = "${(view as TextView).text.toString()} + , SP, Brazil".replace(' ', '+')
            val geoIntent: Intent
            getResources().getResourceEntryName(gridView[i])
            geoIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$city"))
            startActivity(geoIntent)
        }
    }
}
