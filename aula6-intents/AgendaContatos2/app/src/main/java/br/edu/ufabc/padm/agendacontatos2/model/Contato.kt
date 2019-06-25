package br.edu.ufabc.padm.agendacontatos2.model


data class Contato(
        val nome: String = "",
        var endereco: String = "",
        var telefoneResidencial: String = "",
        var telefoneComercial: String = "",
        var email: String = "") {

    override fun toString(): String {
        return nome
    }

}
