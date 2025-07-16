package com.example.tareasemana2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnRegister: Button
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los componentes de la interfaz
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        // Inicializar el helper de la base de datos
        dbHelper = DatabaseHelper(this)

        // Acción cuando se presiona el botón de login
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                if (dbHelper.validateUser(email, password)) {
                    Toast.makeText(this, "Login exitoso", Toast.LENGTH_SHORT).show()

                    // Redirigir a MenuActivity después del login exitoso
                    val intent = Intent(this, MenuActivity::class.java)
                    startActivity(intent)
                    finish() // Cierra la actividad de login para que no se pueda volver atrás
                } else {
                    Toast.makeText(this, "Correo o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, ingrese los datos", Toast.LENGTH_SHORT).show()
            }
        }

        // Acción cuando se presiona el botón de registrarse
        btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}