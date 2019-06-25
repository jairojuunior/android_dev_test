package br.edu.ufabc.padm.uicomponents

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class CheckboxDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox_demo)
    }

    fun handleCheckboxClick(view: View) {
        val checked = (view as CheckBox).isChecked
        val id = view.getId()
        var message = "Nothing has changed"

        if (id == R.id.read_check)
            message = "Read permission"
        else if (id == R.id.write_check)
            message = "Write permission"
        else if (id == R.id.execute_check)
            message = "Execute permission"
        if (checked)
            message += " enabled"
        else
            message += " disabled"

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
