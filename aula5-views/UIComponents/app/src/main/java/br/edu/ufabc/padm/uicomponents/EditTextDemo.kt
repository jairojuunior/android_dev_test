package br.edu.ufabc.padm.uicomponents

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class EditTextDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_text_demo)
        registerActionHandler()
        registerAutocompleteAdapter()
    }

    private fun registerActionHandler() {
        findViewById<EditText>(R.id.send_text)
                .setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEND) {
                Toast.makeText(applicationContext,
                        resources.getString(R.string.text_send_status),
                        Toast.LENGTH_SHORT).show()
                return@setOnEditorActionListener true
            }
            return@setOnEditorActionListener false
        }
    }

    private fun registerAutocompleteAdapter() {
        findViewById<AutoCompleteTextView>(R.id.autocomplete_text)
                .setAdapter(
                        ArrayAdapter(
                                this,
                                android.R.layout.simple_list_item_1,
                                resources.getStringArray(R.array.cities_list)))
    }
}
