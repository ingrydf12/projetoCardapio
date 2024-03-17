package com.ingrydduarte.projetocardapio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ingrydduarte.projetocardapio.databinding.ActivityMainApresentacaoBinding
import android.widget.Toast

class ApresentacaoApp : AppCompatActivity() {
    // declarações de variáveis
    private lateinit var textoLabel: TextView
    private lateinit var btnPedir: Button
    private lateinit var binding: ActivityMainApresentacaoBinding
    private var total: Int = 0 // Variável para armazenar o total
    private var identificarCheck: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_apresentacao)
        // referenciando as views usando View Binding
        binding = ActivityMainApresentacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnPedir = binding.btnPedido// referenciando o btnPedido
        textoLabel = binding.labelTotal // referenciando o textView que contém o valor total

        // map com os CheckBoxes e valores de cada um
        val checkCaixas = mapOf(
            binding.checkEnt1 to 50, binding.checkEnt2 to 35, binding.checkEnt3 to 40,
            binding.checkPrato1 to 50, binding.checkPrato2 to 60, binding.checkPrato3 to 35,
            binding.checkSob1 to 8, binding.checkSob2 to 10, binding.checkSob3 to 12,
            binding.checkBeb1 to 3, binding.checkBeb2 to 5, binding.checkBeb3 to 7
        )

        // adicionando um listener para cada CheckBox
        for ((checkBox, value) in checkCaixas) {
            checkBox.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    total += value // adiciona o valor do CheckBox no total se estiver marcado
                    identificarCheck = true //verificação de check e torna true
                } else {
                    total -= value // remove o valor do CheckBox do total se estiver desmarcado
                    identificarCheck = checkCaixas.any { it.key.isChecked } //verificação de check
                }
                atualizarLabelTotal() // Atualiza o texto do label com o novo total
            }
        }

        //evento botão de Pedido
        btnPedir.setOnClickListener {
            //identificar se o usuário marcou pelo menos um checkbox depois de clicar no btnPedido
            if (identificarCheck) {
                Toast.makeText(this, "Pedido enviado ao restaurante", Toast.LENGTH_LONG).show()
            } else {
                // se nenhum opção marcada
                Toast.makeText(this, "Marque pelo menos uma opção", Toast.LENGTH_LONG).show()
            }
        }
    }

    // atualiza o texto do label com o novo total
    private fun atualizarLabelTotal() {
        textoLabel.text = getString(R.string.labelPreco, total)
    }
}

