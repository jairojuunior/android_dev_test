package com.example.simplecronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.TextView
import android.widget.Chronometer
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var cronometroText: Chronometer
    private lateinit var buttonStartStop: Button
    private lateinit var buttonReset: Button
    private var lastPause: Long = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onStart() {
        super.onStart()
        bindComponents()
        bindButtons()
        init()
        //cronometroText.start()
    }

    private fun bindComponents(){
        cronometroText = findViewById(R.id.cronometro_text)
        buttonStartStop = findViewById(R.id.button_start_stop)
        buttonReset = findViewById(R.id.button_reset)
    }

    private fun bindButtons(){
        buttonStartStop.setOnClickListener {
            startStopCronometro()
        }
        buttonReset.setOnClickListener {
            resetCronometro()
        }
    }

    private fun startStopCronometro(){
        if(buttonStartStop.text == "START"){
            //INICIA CRONOMETRO E MUDA LABEL PARA STOP
            cronometroText.setBase(cronometroText.getBase() + SystemClock.elapsedRealtime() -lastPause)
            cronometroText.start()
            buttonStartStop.setText("STOP")
        }else{
            //PARA CRONOMETRO, MUDA LABEL PARA START
            cronometroText.stop()
            lastPause = SystemClock.elapsedRealtime()
            buttonStartStop.setText("START")
        }
    }

    private fun resetCronometro(){
        cronometroText.setBase(SystemClock.elapsedRealtime())
    }

    private fun init(){
        cronometroText.setBase(SystemClock.elapsedRealtime())
        cronometroText.start()
    }

}
