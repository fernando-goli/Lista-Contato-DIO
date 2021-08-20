package com.fgomes.listacontatos_dio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    private val list: MutableList<Contact> = mutableListOf()

    //Cria visualmente o item na tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
    }

    //Passa por cada item no array e popula o item na lista/tela
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.bind(list[position])

    }

    //Conta os itens na lista
    override fun getItemCount(): Int {
        return list.size
    }

    fun updateList(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    //Gerencia cada item
    class ContactAdapterViewHolder(
        itemView: View,
        var list: List<Contact>,
        var listener: ClickItemContactListener
    ) : RecyclerView.ViewHolder(itemView) {
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val tvImage: ImageView = itemView.findViewById(R.id.contactCirclerImage)

        init{
            itemView.setOnClickListener{
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone

        }
    }

}

