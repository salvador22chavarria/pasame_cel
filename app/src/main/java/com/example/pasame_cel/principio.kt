package com.example.pasame_cel

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

//se declaran las variables privadas para despues llamarlas en la ejecucion
class principio : AppCompatActivity() {
    private var recyclerView:RecyclerView?=null
    private var recyclerViewAdapter:three_r?=null
    private var besto_frientos= mutableListOf<data>()
    //se asignan los datos a las variables, se crea la vista del layout, se asigna el recycle view
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principio)
        besto_frientos=ArrayList()
        recyclerView=findViewById(R.id.cartos)as RecyclerView
        recyclerViewAdapter= three_r(besto_frientos)
        val layoutManager:RecyclerView.LayoutManager= LinearLayoutManager(this)
        recyclerView!!.layoutManager=layoutManager
        recyclerViewAdapter!!.setOnItemClickListener(object:ClickListener<data>{
            override fun onItemClick(data: data) {
                //Un intent explicito cuando se quiere llamar al numero de cada recycler
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:"+data.descripcion)
                startActivity(dialIntent)

            }
        })
        recyclerView!!.adapter=recyclerViewAdapter
        r_amiguis()
        //se conecta el activity con el nombre de los integrantes


    }
    //se asignan los parametros de la lista de amigos y se agregan a dicha lista por ultimo el recycleviewadapter notifica el cambio de los datos
    private fun r_amiguis(){
        var amigui=data("Gabriel",R.drawable.gabo,"72413299")
        besto_frientos.add(amigui)
        amigui=data("Jaime",R.drawable.jaime,"74955783")
        besto_frientos.add(amigui)
        amigui=data("Adiel",R.drawable.adiel,"79201055")
        besto_frientos.add(amigui)
        amigui=data("Melvito",R.drawable.melvito,"no lo agrego por chistoso")
        besto_frientos.add(amigui)
        amigui=data("Melvin perez",R.drawable.mango,"no tiene telefono por que no existe")
        besto_frientos.add(amigui)
        recyclerViewAdapter?.notifyDataSetChanged()
    }



}
