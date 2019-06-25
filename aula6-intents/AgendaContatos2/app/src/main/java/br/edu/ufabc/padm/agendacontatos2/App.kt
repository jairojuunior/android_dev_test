package br.edu.ufabc.padm.agendacontatos2

import android.app.Application
import android.content.Context

class App : Application() {

    companion object {
        lateinit var context: Context
            private set

        // constants to be used as contracts in the app
        val CONTACT_POSITION_EXTRA_KEY = "contactPosition"
        val CONTACT_EDIT_EXTRA_KEY = "isEditing"
        val CONTACT_EDIT_REQCODE = 0
    }


    override fun onCreate() {
        super.onCreate()

        context = applicationContext
    }

}