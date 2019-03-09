package com.example.hierbas

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class Adaptador(val lista:ArrayList<Modelo>,context: Context,val itemClick: (Int) -> Unit):RecyclerView.Adapter<Adaptador.MyViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val vista=LayoutInflater.from(p0.context).inflate(R.layout.carta_producto,p0,false)
        return MyViewHolder(vista)
    }

    override fun getItemCount(): Int {
       return lista.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val dat=lista[p1]
        p0.imagen.setImageResource(dat.Imagen!!)
        p0.producto.text=dat.nombre
        p0.precio.text=dat.Precio.toString()

    }


    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
      internal var imagen:ImageView
        internal var producto:TextView
        internal var precio:TextView
        internal  var carta:CardView

    init{

        precio=itemView.findViewById(R.id.precio)
       producto=itemView.findViewById(R.id.txtnombre)
        imagen=itemView.findViewById(R.id.imagen)
        carta=itemView.findViewById(R.id.carta)

        itemView.setOnClickListener( {itemClick(layoutPosition)} )

    }

    }
}