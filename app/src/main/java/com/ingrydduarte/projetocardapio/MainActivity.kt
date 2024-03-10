package com.ingrydduarte.projetocardapio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClickMe = findViewById(R.id.btentrada) as Button

        btnClickMe.setOnClickListener {
            //Here MainActivity.this is a Current Class Reference (context)
            // Código para passar para a tela MainApresentacao
            val intent = Intent(this, mainApresentacao::class.java)
            startActivity(intent)
        }
    }
    }
