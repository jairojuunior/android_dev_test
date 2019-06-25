package br.edu.ufabc.padm.uicomponents

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ButtonDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_button_demo)
        registerClickHandlers()
    }

    private fun registerClickHandlers() {
        val normalButton = findViewById<Button>(R.id.button)
        val imageButton = findViewById<ImageButton>(R.id.image_button)
        val iconTextButton = findViewById<Button>(R.id.icon_text_button)

        normalButton.setOnClickListener {
            Toast.makeText(applicationContext,
                    resources.getString(R.string.normal_button_message),
                    Toast.LENGTH_SHORT).show()
        }
        imageButton.setOnClickListener {
            Toast.makeText(applicationContext,
                    resources.getString(R.string.image_button_message),
                    Toast.LENGTH_SHORT).show()
        }
        iconTextButton.setOnClickListener {
            Toast.makeText(applicationContext,
                    resources.getString(R.string.icon_text_button_message),
                    Toast.LENGTH_SHORT).show()
        }

    }
}
