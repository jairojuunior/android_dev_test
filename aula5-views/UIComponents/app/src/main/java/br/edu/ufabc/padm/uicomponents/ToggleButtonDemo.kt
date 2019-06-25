package br.edu.ufabc.padm.uicomponents

import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity


class ToggleButtonDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toggle_button_demo)
    }

    fun handleToggle(view: View) {
        val id = view.id
        val on = (view as ToggleButton).isChecked

        if (id == R.id.popup_notification)
            (findViewById<Switch>(R.id.switch_popup_notification)).isChecked = on
        else if (id == R.id.email_notification)
            (findViewById<Switch>(R.id.switch_email_notification)).isChecked = on
        else if (id == R.id.sms_notification)
            (findViewById<Switch>(R.id.switch_sms_notification)).isChecked = on

    }

    fun handleSwitch(view: View) {
        val id = view.id
        val on = (view as Switch).isChecked

        if (id == R.id.switch_popup_notification)
            (findViewById<ToggleButton>(R.id.popup_notification)).isChecked = on
        else if (id == R.id.switch_email_notification)
            (findViewById<ToggleButton>(R.id.email_notification)).isChecked = on
        else if (id == R.id.switch_sms_notification)
            (findViewById<ToggleButton>(R.id.sms_notification)).isChecked = on
    }
}
