package com.fgomes.listacontatos_dio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    //Cria visualmente o item na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    //Passa por cada item no array e popula o item na lista/tela
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])

    }
    //Conta os itens na lista
    override fun getItemCount(): Int {
        return list.size
    }

    //Gerencia cada item
    class ContactAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(contact: Contact){

        }
    }

}

