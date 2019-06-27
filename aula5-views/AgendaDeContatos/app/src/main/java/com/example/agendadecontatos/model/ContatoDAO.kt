package com.example.agendadecontatos.model

import java.util.ArrayList

class ContatoDAO {
    private var contatos: MutableList<Contato> = ArrayList()

    init {
        // TODO: remove when "add" operation is implemented
        loadTestData()
    }

    private fun loadTestData() {
        var c: Contato

        c = Contato()

        c.nome = "Joao"
        c.email = "joao@email.com"
        c.endereco = "Rua Apolinario"
        c.telefoneComercial = "123445"
        c.telefoneResidencial = "123458"

        contatos.add(c)

        c = Contato()
        c.nome = "Maria"
        c.email = "maria@email.com"
        c.endereco = "Rua Joana"
        c.telefoneComercial = "123445"
        c.telefoneResidencial = "123458"

        contatos.add(c)
    }

    companion object {
        val instance = ContatoDAO()
    }


    fun add(contato: Contato) {
        contatos.add(contato)
    }

    fun size(): Int {
        return contatos.size
    }

    fun getItemAt(pos: Int): Contato {
        return contatos[pos]
    }


}