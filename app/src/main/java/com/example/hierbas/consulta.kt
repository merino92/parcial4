package com.example.hierbas

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_consulta.*

class consulta : AppCompatActivity() {


    private var sex:Spinner?=null
    private var contador=0
    private var preferencia:SharedPreferences?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)
        preferencia=getSharedPreferences("consulta",Context.MODE_PRIVATE)
        sex=findViewById(R.id.sexo)
        val arreglo=arrayOf("M","F")
        sex!!.adapter= ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,arreglo)
        //le paso el areglo para que despliegue las opciones el espiner
        sex!!.onItemSelectedListener=object : AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }


            override fun onNothingSelected(parent: AdapterView<*>?) {


            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                contador=position

            } //obtiene la posicion del elemento seleccionado
        }



    }



    fun Guardar(view: View){

        val nombre=txtnombre.text.toString()
        val editor=preferencia!!.edit()
        editor.putString("nombre_paciente",nombre)
        editor!!.commit()


        val no=preferencia!!.getString("nombre_paciente","")





    }
}
