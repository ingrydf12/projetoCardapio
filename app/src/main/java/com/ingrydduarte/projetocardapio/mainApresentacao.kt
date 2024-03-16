package com.ingrydduarte.projetocardapio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ingrydduarte.projetocardapio.databinding.ActivityMainBinding

class mainApresentacao : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPedido.setOnClickListener(this)

        fun onClick(view: View){

        }

        fun calcular(){

        }
    }
}