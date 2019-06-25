package br.edu.ufabc.padm.agendacontatos2.model

/**
 * Here we implement two DAO Singleton strategies (via object and via class)
 */


import br.edu.ufabc.padm.agendacontatos2.App
import java.io.File
import java.util.ArrayList

/**
 * An alias that selects which strategy to employ application-wise
 */

typealias ContatoDAO = ContatoDAOObject

/**
 * Singleton pattern implemented with a Kotlin object declaration (https://bit.ly/31J1Ev2)
 */
object ContatoDAOObject {
    private val contatos: MutableList<Contato> = ArrayList()
    val instance = this

    init {
        // TODO: remove when "add" operation is implemented
        loadMockData()
    }

    fun add(contato: Contato) {
        contatos.add(contato)
    }

    fun update(position: Int, contato: Contato) {
        contatos.set(position, contato)
    }

    fun removeAll(removePositions: IntArray): Boolean {
        return contatos.removeAll(
                Array(removePositions.size) {
                    i -> contatos.get(removePositions[i])
                })
    }

    fun size(): Int {
        return contatos.size
    }

    fun getItemAt(pos: Int): Contato {
        return contatos[pos]
    }

    /**
     * Load mock data from an assets file
     */
    private fun loadMockData() {
        contatos.addAll(App.context.assets.open("contato_mock_data.csv")
                .bufferedReader().readLines()
                .map {
                    Array(5){ i -> it.split(",")[i]}}
                .map {
                    Contato(
                            nome = it[0],
                            endereco = it[1],
                            telefoneComercial = it[2],
                            telefoneResidencial = it[3],
                            email = it[4])
                })
    }
}

