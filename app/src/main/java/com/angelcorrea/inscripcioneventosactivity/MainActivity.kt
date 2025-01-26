package com.angelcorrea.inscripcioneventosactivity

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angelcorrea.inscripcioneventosactivity.R.*
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editTextNombre = findViewById<TextInputEditText>(R.id.editText) // Cambia el ID si es necesario
        val editTextEmail = findViewById<TextInputEditText>(R.id.editText2)
        val radioSi = findViewById<RadioButton>(R.id.radioButton)
        val radioNo = findViewById<RadioButton>(R.id.radioButton2)
        val buttonInscribirse = findViewById<Button>(R.id.button)

        buttonInscribirse.setOnClickListener {
            val nombre = editTextNombre.text?.toString().orEmpty()
            val email = editTextEmail.text?.toString().orEmpty()
            val decision = when {
                radioSi.isChecked -> "Sí"
                radioNo.isChecked -> "No"
                else -> "Sin respuesta"
            }
            val mensaje = "Nombre: $nombre\nEmail: $email\nAsistirá: $decision"
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}