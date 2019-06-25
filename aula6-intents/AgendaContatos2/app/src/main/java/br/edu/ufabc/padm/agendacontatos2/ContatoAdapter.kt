package br.edu.ufabc.padm.agendacontatos2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import br.edu.ufabc.padm.agendacontatos2.model.ContatoDAO


class ContatoAdapter : BaseAdapter() {

    override fun getCount(): Int {
        return ContatoDAO.instance.size()
    }

    override fun getItem(position: Int): Any {
        return ContatoDAO.instance.getItemAt(position)
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = App.context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val localView = convertView ?: inflater.inflate(R.layout.contato_list_item, null)
        val contato = ContatoDAO.instance.getItemAt(position)
        val nome = localView.findViewById<TextView>(R.id.contact_name)
        val email = localView.findViewById<TextView>(R.id.contact_email)

        nome.text = contato.nome
        email.text = contato.email

        return localView
    }
}
