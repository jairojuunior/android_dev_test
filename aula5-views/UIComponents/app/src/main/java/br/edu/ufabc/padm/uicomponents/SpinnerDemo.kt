package br.edu.ufabc.padm.uicomponents

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class SpinnerDemo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
    }

    fun goHome(view: View)  = finish()
}
