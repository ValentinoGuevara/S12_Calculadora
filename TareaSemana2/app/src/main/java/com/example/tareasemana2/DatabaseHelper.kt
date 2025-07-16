package com.example.tareasemana2

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "usuarios.db"
        private const val DATABASE_VERSION = 2  // Incrementar la versión de la base de datos
        private const val TABLE_USERS = "usuarios"
        private const val COLUMN_ID = "codigo"
        private const val COLUMN_EMAIL = "correo"
        private const val COLUMN_PASSWORD = "contrasena"
        private const val COLUMN_NAME = "nombre"
        private const val COLUMN_LASTNAME = "apellidos"
        private const val COLUMN_STUDENT_CODE = "codigo_estudiante" // Nuevo campo
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE $TABLE_USERS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_EMAIL TEXT,
                $COLUMN_PASSWORD TEXT,
                $COLUMN_NAME TEXT,
                $COLUMN_LASTNAME TEXT,
                $COLUMN_STUDENT_CODE TEXT  // Nuevo campo para código de estudiante
            )
        """
        db?.execSQL(createTable)

        // Insertar un usuario de ejemplo
        val insertQuery = """
            INSERT INTO $TABLE_USERS ($COLUMN_EMAIL, $COLUMN_PASSWORD, $COLUMN_NAME, $COLUMN_LASTNAME, $COLUMN_STUDENT_CODE)
            VALUES ('202114033@uns.edu.pe', '1234', 'Juan', 'Pérez', '202114033')  // Ejemplo con código de estudiante
        """
        db?.execSQL(insertQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) {
            // Agregar la nueva columna si estamos en una versión anterior
            db?.execSQL("ALTER TABLE $TABLE_USERS ADD COLUMN $COLUMN_STUDENT_CODE TEXT")
        }
    }

    // Validar usuario (sin cambios)
    fun validateUser(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_USERS WHERE $COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?"
        val cursor = db.rawQuery(query, arrayOf(email, password))

        val isValid = cursor.count > 0
        cursor.close()
        db.close()

        return isValid
    }

    // Agregar usuario (con el nuevo campo)
    fun addUser(email: String, password: String, name: String, lastName: String, studentCode: String): Boolean {
        val db = this.writableDatabase
        val insertQuery = """
            INSERT INTO $TABLE_USERS ($COLUMN_EMAIL, $COLUMN_PASSWORD, $COLUMN_NAME, $COLUMN_LASTNAME, $COLUMN_STUDENT_CODE)
            VALUES (?, ?, ?, ?, ?)
        """
        val stmt = db.compileStatement(insertQuery)
        stmt.bindString(1, email)
        stmt.bindString(2, password)
        stmt.bindString(3, name)
        stmt.bindString(4, lastName)
        stmt.bindString(5, studentCode) // Se guarda el código de estudiante
        val rowId = stmt.executeInsert()
        db.close()
        return rowId != -1L
    }


    fun getAllUsers(): List<String> {
        val users = mutableListOf<String>()
        val db = this.readableDatabase
        val query = "SELECT * FROM $TABLE_USERS"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val studentCode = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_STUDENT_CODE))
                val lastName = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_LASTNAME))
                val name = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                val email = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL))

                val userInfo = "Código: $studentCode\nApellidos: $lastName\nNombres: $name\nCorreo: $email"
                users.add(userInfo)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()
        return users
    }



}