package br.edu.ufabc.padm.agendacontatos2

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

import androidx.appcompat.app.AppCompatActivity
import br.edu.ufabc.padm.agendacontatos2.model.Contato
import br.edu.ufabc.padm.agendacontatos2.model.ContatoDAO


class ContatoInsertEdit : AppCompatActivity() {

    private lateinit var contatoForm: ContatoForm
    private val isEditing: Boolean
        get() = intent.extras?.getBoolean(App.CONTACT_EDIT_EXTRA_KEY) ?: false

    /**
     * A utility class to process the input form
     */
    private inner class ContatoForm {
        private val nome: EditText
        private val email: EditText
        private val endereco: EditText
        private val telefoneComercial: EditText
        private val telefoneResidencial: EditText
        private val toString: (EditText) -> String  = {
            it.text.toString().trim()
        }

        init {
            nome = findViewById(R.id.insert_contato_nome)
            email = findViewById(R.id.insert_contato_email)
            endereco = findViewById(R.id.insert_contato_endereco)
            telefoneComercial = findViewById(R.id.insert_contato_telefone_comercial)
            telefoneResidencial = findViewById(R.id.insert_contato_telefone_residencial)
        }

        fun isValid(): Boolean {
            return arrayOf(nome, email, endereco)
                    .map {
                        if (toString(it).isEmpty()) {
                            it.error = getString(R.string.required_field)
                            false
                        } else true
                    }
                    .fold(true) { a: Boolean, b: Boolean ->
                        a && b
                    }
        }

        fun fill(contato: Contato) {
            nome.setText(contato.nome)
            email.setText(contato.email)
            endereco.setText(contato.endereco)
            telefoneComercial.setText(contato.telefoneComercial)
            telefoneResidencial.setText(contato.telefoneResidencial)
        }

        fun toContato(): Contato {
            val contato = Contato(
                    nome = toString(nome),
                    email = toString(email),
                    endereco = toString(endereco),
                    telefoneResidencial = toString(telefoneResidencial),
                    telefoneComercial = toString(telefoneComercial))
            return contato
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contato_insert)
        contatoForm = ContatoForm()
    }

    override fun onStart() {
        super.onStart()

        if (isEditing) {
            setTitle(R.string.title_activity_contato_edit)
            fillForm()
        } else
            setTitle(R.string.title_activity_contato_insert)
    }

    private fun handleInsert() {
        if (contatoForm.isValid()) {
            ContatoDAO.instance.add(contatoForm.toContato())

            Toast.makeText(this, getString(R.string.insert_status_ok), Toast.LENGTH_LONG).show()
            finish()
        } else
            Toast.makeText(this, getString(R.string.insert_status_error), Toast.LENGTH_LONG).show()
    }

    private fun fillForm() {
        val position = intent.extras?.getInt(App.CONTACT_POSITION_EXTRA_KEY) ?: 0
        val contato = ContatoDAO.instance.getItemAt(position)

        contatoForm.fill(contato)
    }

    private fun handleEdit() {
        if (contatoForm.isValid()) {
            val position = intent.extras?.getInt(App.CONTACT_POSITION_EXTRA_KEY) ?: 0

            ContatoDAO.instance.update(position, contatoForm.toContato())
            Toast.makeText(this, getString(R.string.edit_status_ok), Toast.LENGTH_LONG).show()
            finish()
        } else
            Toast.makeText(this, getString(R.string.insert_status_error), Toast.LENGTH_LONG).show()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_contato_insert, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_save)
            if (isEditing)
                handleEdit()
            else
                handleInsert()


        return super.onOptionsItemSelected(item)
    }
}
