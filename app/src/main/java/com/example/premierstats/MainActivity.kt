package com.example.premierstats

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencia al botón y al campo de texto
        val boton = findViewById<Button>(R.id.navigateToCreditsButton)
        val editText = findViewById<EditText>(R.id.usernameInput)

        // Al hacer clic en el botón, validamos el nombre y pasamos a la siguiente actividad
        boton.setOnClickListener {
            val nombre = editText.text.toString()
            if (nombre.isBlank()) {
                // Si no se introdujo un nombre, mostramos un Toast
                Toast.makeText(this, "Debe introducir un nombre", Toast.LENGTH_SHORT).show()
            } else {
                // Si hay nombre, se pasa a la actividad de créditos
                val intent = Intent(this, CreditActivity::class.java)
                intent.putExtra("USERNAME", nombre) // Pasamos el nombre a CreditActivity
                startActivity(intent)
            }
        }
    }
}
