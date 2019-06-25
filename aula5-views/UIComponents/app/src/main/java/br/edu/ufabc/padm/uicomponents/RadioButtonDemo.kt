package br.edu.ufabc.padm.uicomponents

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class RadioButtonDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button_demo)
    }

    fun radioButtonClickHandler(view: View) {
        val id = view.getId()
        var message = "You are "

        if (id == R.id.option_professor)
            message += " a Professor"
        else if (id == R.id.option_ta)
            message += " a Teaching Assistant"
        else if (id == R.id.option_grad)
            message += " a Graduate Student"
        else if (id == R.id.option_undergrad)
            message += " a Undergrad student"
        else
            message = "Your role is unknown"

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
