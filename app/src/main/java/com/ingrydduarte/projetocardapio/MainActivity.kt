package com.ingrydduarte.projetocardapio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import com.ingrydduarte.projetocardapio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var buttonEntrar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //referenciar o botão (relative layout)
        buttonEntrar = binding.btentrada

        buttonEntrar.setOnClickListener {
            //Here MainActivity.this is a Current Class Reference (context)
            // Código para passar para a tela MainApresentacao
            val intent = Intent(this, ApresentacaoApp::class.java)
            startActivity(intent)
        }
    }
    }
