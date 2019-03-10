package com.example.hierbas

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class receta : AppCompatActivity() {


    private var preferencias:SharedPreferences?=null
    private var nombre:TextView?=null
    private var apellido:TextView?=null
    private var receta:TextView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receta)
        preferencias=getSharedPreferences("consulta",Context.MODE_PRIVATE)
        nombre=findViewById(R.id.txtnombre)
        apellido=findViewById(R.id.txtapellido)
        receta=findViewById(R.id.receta)
        val n=preferencias!!.getString("nombre_paciente",null)
        nombre!!.text=n
        apellido!!.text=preferencias!!.getString("apellido",null)
        receta!!.text=preferencias!!.getString("receta","n")
    }




    fun GuardarReceta(view:View){

        val editor=preferencias!!.edit()
        editor.putString("receta",receta!!.text.toString())
        editor.commit()
        Toast.makeText(this,"almacenado correctamente",Toast.LENGTH_LONG).show()
    }
}
