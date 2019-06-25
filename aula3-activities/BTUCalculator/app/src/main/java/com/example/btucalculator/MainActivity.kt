package com.example.btucalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var areaText: TextView
    private lateinit var pessoasText: TextView
    private lateinit var btuText: TextView
    private lateinit var areaSeek: SeekBar
    private lateinit var pessoasSeek: SeekBar
    private lateinit var luzSolarSwitch: Switch


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        bindComponents()
        bindSeekbarHandlers()
        bindSwitchs()
        init()
    }

    private fun bindComponents() {
        areaText = findViewById(R.id.area_text)
        pessoasText = findViewById(R.id.pessoas_text)
        btuText = findViewById(R.id.btu_text)
        areaSeek = findViewById(R.id.area_seek)
        pessoasSeek = findViewById(R.id.pessoas_seek)
        luzSolarSwitch = findViewById(R.id.luz_solar_switch)
    }

    private fun bindSeekbarHandlers() {
        areaSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                updateArea(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
        pessoasSeek.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                updatePessoas(progress)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    private fun bindSwitchs(){
        luzSolarSwitch.setOnCheckedChangeListener{ _, _ ->
            updateBTU()
        }
    }


    private fun init() {
        areaSeek.progress = 30
        pessoasSeek.progress = 5
    }

    private fun updateArea(progress: Int){
        areaText.text = "$progress m²"
        updateBTU()
    }

    private fun updatePessoas(progress: Int){
        pessoasText.text = "$progress pss"
        updateBTU()
    }
/*
    private fun updateLuzSolar(){
        updateBTU()
    }
*/

    private fun updateBTU(){
        val area = areaSeek.progress.toDouble()
        val pessoas = pessoasSeek.progress.toDouble() - 1.0
        var luz_solar = if(luzSolarSwitch.isChecked) 800.0 else 600.0

        val btu  = luz_solar*(area + pessoas)
        btuText.text = "${btu.toInt()} BTUs"
    }
}
