package com.example.premierstats

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CreditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        // Referencia al TextView donde mostraremos el nombre
        val textView = findViewById<TextView>(R.id.welcomeText)
        val botonContacto = findViewById<Button>(R.id.contactButton)

        // Recuperamos el nombre pasado desde MainActivity
        val username = intent.getStringExtra("USERNAME")
        textView.text = "Hola $username, estás usando la versión 1.0 de Premier Stats"

        // Configuración del botón para enviar un correo
        botonContacto.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("tuemail@dominio.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app Premier Stats")
            intent.putExtra(Intent.EXTRA_TEXT, "Escribe aquí tu mensaje...")

            // Verificamos que haya una app para manejar el correo
            try {
                startActivity(Intent.createChooser(intent, "Enviar correo..."))
            } catch (e: android.content.ActivityNotFoundException) {
                Toast.makeText(this, "No hay ninguna aplicación de correo instalada", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
