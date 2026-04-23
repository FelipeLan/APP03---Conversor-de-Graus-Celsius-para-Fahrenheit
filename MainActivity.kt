package com.example.appcelsius23_04_26

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val txtCelsius = findViewById<EditText>(R.id.txtCelsius)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val btnConverter = findViewById<Button>(R.id.btnConverter)

        btnConverter.setOnClickListener {
            if (txtCelsius.text.isEmpty()) {
                txtCelsius.error = "Digite a Temperatura em Celsius"
            } else {
                val celsius = txtCelsius.text.toString().toDouble()
                val resultado: Double
                resultado = (9 * celsius + 160) / 5
                txtResultado.text = "$celsius Graus Celsius equivale a $resultado graus Fahrenheit"
                txtCelsius.text.clear()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}