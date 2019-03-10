package com.example.hierbas

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView

class productos : AppCompatActivity() {

    private val total:TextView?=null
    private val reciclador:RecyclerView?=null
    private var listado:ArrayList<Modelo>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)


        //ListarProducto(this)
    }

    fun Mostrar(view: View){
        ListarProducto(this)
    }


    fun ListarProducto(contexto:Context){
        val vista_producto= LayoutInflater.from(contexto).inflate(R.layout.listado_producto,null)
        val lis=vista_producto.findViewById<RecyclerView>(R.id.listado_productos)
        var mLayoutManager = LinearLayoutManager(contexto, LinearLayoutManager.VERTICAL, false)

        val cancelar=vista_producto.findViewById<Button>(R.id.btncancelar)
        val scroll=vista_producto.findViewById<ScrollView>(R.id.scroll)
        lis.layoutManager=mLayoutManager
        val bilder= AlertDialog.Builder(contexto)
            .setView(vista_producto)


        val dialogo=bilder.show()
        cancelar.setOnClickListener {
            dialogo.dismiss()
        }


        val lista=ArmarLista()
        listado=lista
        val adaptador=Adaptador(lista,this){p->

            val data= listado!![p]
            Cantidad()


        }
        //na la posicion del elemento que selecciono el usuario y acontinuacion obtiene el producto y se lo envia a la alerta de agregar producto
        scroll.scrollTo(0,0) //manda a la posicion inicial del scroll
        lis.adapter=adaptador




    }
    fun ArmarLista(): ArrayList<Modelo> {
        val lista=ArrayList<Modelo>()
        var uno=Modelo(
            "Aloe evera",
            24.99,
           R.drawable.aceite)
        lista.add(uno)
        var udos=Modelo(
            "Aloe evera",
            24.99,
            R.drawable.crema)
        lista.add(udos)
        var t=Modelo(
            "Aloe evera",
            24.99,
            R.drawable.floricundia)
        lista.add(t)
        var c=Modelo(
            "Aloe evera",
            24.99,
            R.drawable.diente)
        lista.add(c)
        var ci=Modelo(
            "Aloe evera",
            24.99,
            R.drawable.mari)
        lista.add(ci)
        var se=Modelo(
            "Aloe evera",
            24.99,
            R.drawable.hierbas2)
        lista.add(se)
        lista.add(se)
        return lista



    }


        var canti=0
    fun Cantidad(p:Int): Int {

        val dialogView = LayoutInflater.from(this).inflate(R.layout.cantidad, null)
        //se inicia el cuadro del dialogo
       var cantidad=dialogView!!.findViewById<TextView>(R.id.cantidad)
        var title = "Cantidad"

        val builder = AlertDialog.Builder(this)
            .setView(dialogView)
            .setTitle(title)
            .setPositiveButton("Aceptar", null)
            .setNegativeButton("Cancelar", null)
        val dialog = builder.show()

       dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener({

           var c=cantidad.text.toString().toInt()

           if(c>0){
               return canti
           }else{
              return  canti=1
           }

           dialog.dismiss()
       } )

        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener({
            canti=0
            dialog.dismiss()


        } )
    }



}
