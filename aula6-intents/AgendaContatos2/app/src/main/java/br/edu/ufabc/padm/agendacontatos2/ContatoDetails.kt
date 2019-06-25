package br.edu.ufabc.padm.agendacontatos2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ufabc.padm.agendacontatos2.model.Contato
import br.edu.ufabc.padm.agendacontatos2.model.ContatoDAO


class ContatoDetails : AppCompatActivity() {

    private lateinit var position: Integer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_show)

        position = Integer(intent.extras?.getInt(App.CONTACT_POSITION_EXTRA_KEY) ?: 0)
        showContato()

    }

    private fun showContato() {
        val contato = ContatoDAO.instance.getItemAt(position.toInt())

        (findViewById<TextView>(R.id.contato_item_nome)).text = contato.nome
        (findViewById<TextView>(R.id.contato_item_endereco)).text = contato.endereco
        (findViewById<TextView>(R.id.contato_item_email)).text = contato.email
        (findViewById<TextView>(R.id.contato_item_telcom)).text = contato.telefoneComercial
        (findViewById<TextView>(R.id.contato_item_telres)).text = contato.telefoneResidencial
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == App.CONTACT_EDIT_REQCODE)
            showContato()
        else
            Toast.makeText(this, getString(R.string.edited_status_failed), Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_contato_show, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_edit) {
            val intent = Intent(this, ContatoInsertEdit::class.java)

            intent.putExtra(App.CONTACT_POSITION_EXTRA_KEY, position)
            intent.putExtra(App.CONTACT_EDIT_EXTRA_KEY, true)

            startActivityForResult(intent, App.CONTACT_EDIT_REQCODE)
        }


        return super.onOptionsItemSelected(item)
    }
}
