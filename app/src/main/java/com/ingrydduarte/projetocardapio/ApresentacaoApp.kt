package com.ingrydduarte.projetocardapio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

//import android.widget.Toast


class ApresentacaoApp : AppCompatActivity() {
    //declarações de variáveis
    private lateinit var textoLabel: TextView
    private lateinit var btnPedir: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_apresentacao)

        btnPedir = findViewById(R.id.btnPedido)//referenciando o btnPedido
        textoLabel = findViewById(R.id.labelTotal) //referenciando o textView que contém o valor total
    }
}
