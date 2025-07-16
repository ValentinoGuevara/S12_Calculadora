package com.example.tareasemana2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var etName: EditText
    private lateinit var etLastName: EditText
    private lateinit var etStudentCode: EditText  // Nuevo campo para código de estudiante
    private lateinit var btnRegister: Button
    private lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Referencias a los componentes de la interfaz
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etName = findViewById(R.id.etName)
        etLastName = findViewById(R.id.etLastName)
        etStudentCode = findViewById(R.id.etStudentCode)  // Nuevo campo
        btnRegister = findViewById(R.id.btnRegister)

        // Inicializar el helper de la base de datos
        dbHelper = DatabaseHelper(this)

        btnRegister.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val name = etName.text.toString().trim()
            val lastName = etLastName.text.toString().trim()
            val studentCode = etStudentCode.text.toString().trim()  // Obtener el código de estudiante

            if (email.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty() && lastName.isNotEmpty() && studentCode.isNotEmpty()) {
                if (dbHelper.addUser(email, password, name, lastName, studentCode)) {
                    Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Cierra la actividad de registro
                } else {
                    Toast.makeText(this, "Error al registrar usuario", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Por favor, ingrese todos los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}