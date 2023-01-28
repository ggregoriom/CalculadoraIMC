package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar UI component no arquivo Kotlin
        // Colocar ação num botão
        val btnCalc: Button = findViewById(R.id.btnCalc)
        val edtPeso : EditText = findViewById(R.id.edtPeso)
        val edtAltura : EditText = findViewById(R.id.edtAltura)
        btnCalc.setOnClickListener {

            val message : String = edtPeso.text.toString()

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()
            if(alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                    var altura: Float = alturaStr.toFloat()
                    var peso: Float = pesoStr.toFloat()
                    val result: Float = peso / (altura * altura)
                    val intent = Intent(this, ResultActivity::class.java)
                        .apply {
                            putExtra("EXTRA_RESULT", result)
                        }
                    startActivity(intent)
            } else {
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
    }
}