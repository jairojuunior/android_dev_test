package br.edu.ufabc.padm.uicomponents

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private inner class ComponentChoiceListener() : AdapterView.OnItemSelectedListener {
        var intent = Intent()

        override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

            when (parent.getItemAtPosition(position).toString()) {
                "Button" -> intent.setClass(
                        this@MainActivity,
                        ButtonDemo::class.java)
                "Text field" -> intent.setClass(
                        this@MainActivity,
                        EditTextDemo::class.java)
                "Checkbox" -> intent.setClass(
                        this@MainActivity,
                        CheckboxDemo::class.java)
                "Radio button" -> intent.setClass(
                        this@MainActivity,
                        RadioButtonDemo::class.java)
                "Toggle button" -> intent.setClass(
                        this@MainActivity,
                        ToggleButtonDemo::class.java)
                "Spinner" -> intent.setClass(
                        this@MainActivity,
                        SpinnerDemo::class.java)
                "Action bar" -> intent.setClass(
                        this@MainActivity,
                        ActionBarDemo::class.java)
                "Menu" -> intent.setClass(
                        this@MainActivity,
                        MenuDemo::class.java)
                "Button theme" -> intent.setClass(
                        this@MainActivity,
                        ButtonStyleDemo::class.java)
            }

            if (position > 0) startActivity(intent)
        }

        override fun onNothingSelected(parent: AdapterView<*>) {
            showToast()
        }

        fun showToast() {
            Toast.makeText(
                    this@MainActivity,
                    "No option has been selected",
                    Toast.LENGTH_LONG)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        populateComponentChooser()
    }

    private fun populateComponentChooser() {
        val componentChooser = findViewById<Spinner>(R.id.component_chooser)
        val adapter = ArrayAdapter.createFromResource(this,
                R.array.component_choices,
                android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        componentChooser.adapter = adapter
        componentChooser.onItemSelectedListener = ComponentChoiceListener()
    }
}
