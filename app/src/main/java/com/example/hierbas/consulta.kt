package com.example.hierbas

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_consulta.*

class consulta : AppCompatActivity() {


    private var sex:Spinner?=null
    private var contador=0
    private var preferencia:SharedPreferences?=null
    private var sexo=0
    private var nombre:TextView?=null
    private var apellido:TextView?=null
    private var edad:TextView?=null
    private var diagnostico:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consulta)
        nombre=findViewById(R.id.txtnombre)
        apellido=findViewById(R.id.txtnombre)
        edad=findViewById(R.id.txtedad)
        diagnostico=findViewById(R.id.dianostico)
        preferencia=getSharedPreferences("consulta",Context.MODE_PRIVATE)

        val n=preferencia!!.getString("nombre_paciente",null)
        nombre!!.text=n
        apellido!!.text=preferencia!!.getString("apellido",null)
        edad!!.text= preferencia!!.getInt("edad",0).toString()
        diagnostico!!.text=preferencia!!.getString("diagnostico",null)
        sexo=preferencia!!.getInt("sexo",0)
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
                sexo=position
            } //obtiene la posicion del elemento seleccionado
        }
        sex!!.setSelection(sexo)


    }



    fun Guardar(view: View){

        val nombre=txtnombre.text.toString()
        val apellido=txtapellido.text.toString()
        val edad=txtedad.text.toString().toInt()
        val diagnostico=dianostico.text.toString()
        val editor=preferencia!!.edit()
        editor.putString("nombre_paciente",nombre)
        editor.putString("apellido",apellido)
        editor.putInt("edad",edad)
        editor.putString("diagnostico",diagnostico)
        editor.putInt("sexo",sexo)
        editor!!.commit()
        Toast.makeText(this,"Guardado correctamente",Toast.LENGTH_LONG).show()

    }
}
