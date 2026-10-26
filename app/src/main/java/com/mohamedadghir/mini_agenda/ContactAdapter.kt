package com.mohamedadghir.mini_agenda


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private val contactList: List<Contact>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    // El ViewHolder busca els 3 TextView del teu LinearLayout per ID
    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNom: TextView = itemView.findViewById(R.id.txtTitulo)        // O el ID que hagis posat pel nom
        val txtCognom: TextView = itemView.findViewById(R.id.txtSubtitulo)  // Pel cognom
        val txtTelefon: TextView = itemView.findViewById(R.id.txtFecha)     // Pel telèfon
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        // Infla el disseny del teu ítem (el LinearLayout amb els 3 TextView)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contacte = contactList[position]
        // Assigna les dades aleatòries a cada TextView
        holder.txtNom.text = contacte.nom
        holder.txtCognom.text = contacte.cognom
        holder.txtTelefon.text = contacte.telefon
    }

    override fun getItemCount(): Int = contactList.size
}
