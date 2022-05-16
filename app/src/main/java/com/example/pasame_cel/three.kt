package com.example.pasame_cel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//se crea la clase constructor y se crea el adaptador y la variable cliclistener
class three_r constructor(private val besto_frientos:List<data>):
    RecyclerView.Adapter<three_r.MyViewHolder>(){
    private var clickListener:ClickListener<data>?=null
    //se crea una funcion para la vista del recycleview

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.design,parent,false)
        return MyViewHolder(view)
    }
    //se crea otra funcion para asignar los valores del viewholder que pasaran por la clase data
    override fun onBindViewHolder(holder: three_r.MyViewHolder, position: Int) {
        val  panes=besto_frientos[position]
        holder.who.text=panes.nombre
        holder.photos.setBackgroundResource(panes.imagen)
        holder.card_design.setOnClickListener { clickListener!!.onItemClick(panes) }
        holder.description.text="${panes.descripcion}"

    }
    //se crea otra funcion para retornar el tamaño de la lista
    override fun getItemCount(): Int {
        return besto_frientos.size
    }
    //se crea otra funcion para asignar valor a el cliclistener
    fun setOnItemClickListener(frClickListener: ClickListener<data>?){
        clickListener=frClickListener
    }
    //se crea una clase interna para asignar las variables con los item del layout del recycle
    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val who: TextView = itemView.findViewById(R.id.name)
        val photos: ImageView = itemView.findViewById(R.id.persona)
        val card_design: CardView = itemView.findViewById(R.id.card)
        val description: TextView = itemView.findViewById(R.id.descripcion)
    }


}
//se crea una interface clicklistener para pasar la informacion al mainactivity
interface ClickListener<R> {
    fun onItemClick(data: R)
}