package br.edu.ufabc.padm.contentadaptation

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById<ListView>(R.id.demo_list)
        populateList()
    }

    private fun populateList() {
        listView.adapter = ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                resources.getStringArray(R.array.demo_list))
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> startActivity(Intent(this,
                        StaticFragmentActivity::class.java))
                1 -> startActivity(Intent(this,
                        DynamicFragmentsActivity::class.java))
                2 -> startActivity(Intent(this,
                        DeviceDetectionActivityDeclarative::class.java))
                3 -> startActivity(Intent(this,
                        DeviceDetectionActivityImperative::class.java))
            }
        }
    }
}
