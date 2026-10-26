package com.mohamedadghir.mini_agenda

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. Generamos la lista de 40 contactos aleatorios
        val llistaContactes = generarContactesAleatoris()

        // 2. Buscamos el RecyclerView por su ID (asegúrate de que en tu activity_main.xml se llame así)
        val recyclerView: RecyclerView = findViewById(R.id.myRecyclerView)

        // 3. Le decimos al RecyclerView que se muestre como una lista vertical
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 4. Le pasamos los datos al Adaptador (crearemos esta clase en el siguiente paso)
        recyclerView.adapter = ContactAdapter(llistaContactes)
    }

    // Función para crear la lista de 40 contactos combinados al azar
    private fun generarContactesAleatoris(): ArrayList<Contact> {
        val llista = ArrayList<Contact>()

        val noms = arrayOf("Joan", "Maria", "Antoni", "Laura", "Pere", "Anna", "Jordi", "Marta", "David", "Sílvia")
        val cognoms = arrayOf("Garcia", "Martínez", "López", "Sánchez", "Rodríguez", "Fernández", "Pérez", "Gómez", "Vila", "Serra")

        for (i in 1..40) {
            val nomRandom = noms[Random.nextInt(noms.size)]
            val cognomRandom = cognoms[Random.nextInt(cognoms.size)]
            val telefonRandom = Random.nextInt(100000000, 1000000000).toString()

            llista.add(Contact(nomRandom, cognomRandom, telefonRandom))
        }
        return llista
    }
}

