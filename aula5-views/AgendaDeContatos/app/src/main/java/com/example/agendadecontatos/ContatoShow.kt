package com.example.agendadecontatos

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.agendadecontatos.model.ContatoDAO



class ContatoShow : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_show)
        showContato()
    }

    private fun showContato() {
        val pos = intent.extras?.getInt("contactPosition") ?: 0
        val contato = ContatoDAO.instance.getItemAt(pos)

        (findViewById<TextView>(R.id.contato_item_nome)).text = contato.nome
        (findViewById<TextView>(R.id.contato_item_endereco)).text = contato.endereco
        (findViewById<TextView>(R.id.contato_item_email)).text = contato.email
        (findViewById<TextView>(R.id.contato_item_telcom)).text = contato.telefoneComercial
        (findViewById<TextView>(R.id.contato_item_telres)).text = contato.telefoneResidencial
    }
}
