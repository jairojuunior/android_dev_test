package com.example.agendadecontatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var contatosListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateContatos()
    }


    private fun populateContatos() {
        contatosListView = findViewById(R.id.contatosListView)

        contatosListView.adapter = ContatoAdapter()

        contatosListView.onItemClickListener = AdapterView.OnItemClickListener { parent, _, position, _ ->
            val intent = Intent(parent.context, ContatoShow::class.java)

            intent.putExtra("contactPosition", position)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        (contatosListView.adapter as BaseAdapter).notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        if (id == R.id.action_add) {
            startActivity(Intent(this, ContatoInsert::class.java))

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
