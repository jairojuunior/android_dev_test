package br.edu.ufabc.padm.agendacontatos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class ContatoShow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_show)
        showContato()
    }

    private fun showContato() {
        // TODO: handle contact details
    }
}
