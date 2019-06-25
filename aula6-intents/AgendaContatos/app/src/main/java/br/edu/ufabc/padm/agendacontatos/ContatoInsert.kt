package br.edu.ufabc.padm.agendacontatos

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ufabc.padm.agendacontatos.model.Contato
import br.edu.ufabc.padm.agendacontatos.model.ContatoDAO


class ContatoInsert : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_insert)
    }

    private fun handleInsert() {
        val nome = (findViewById<EditText>(R.id.insert_contato_nome)).text.toString()
        val email = (findViewById<EditText>(R.id.insert_contato_email)).text.toString()
        val endereco = (findViewById<EditText>(R.id.insert_contato_endereco)).text.toString()
        val telefoneComercial = (findViewById<EditText>(R.id.insert_contato_telefone_comercial)).text.toString()
        val telefoneResidencial = (findViewById<EditText>(R.id.insert_contato_telefone_residencial)).text.toString()
        val contato = Contato()

        contato.nome = nome
        contato.email = email
        contato.endereco = endereco
        contato.telefoneComercial = telefoneComercial
        contato.telefoneResidencial = telefoneResidencial

        ContatoDAO.instance.add(contato)

        Toast.makeText(this, getString(R.string.insert_status_ok), Toast.LENGTH_SHORT).show()
        finish()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_contato_insert, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_save) {
            handleInsert()
            true
        } else super.onOptionsItemSelected(item)

    }
}
