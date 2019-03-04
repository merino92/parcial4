package com.example.hierbas

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView

class MainActivity : AppCompatActivity() {

    private var carta_consulta:CardView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val barra=supportActionBar

        if(barra!=null){
            barra.hide()
        }

        carta_consulta=findViewById(R.id.cardconsulta)
        MostrarConsulta(carta_consulta!!)

    }


    fun MostrarConsulta(carta:CardView){

        carta.setOnClickListener {

            val intento=Intent(this,consulta::class.java)
            startActivity(intento)

        }
    }
}
