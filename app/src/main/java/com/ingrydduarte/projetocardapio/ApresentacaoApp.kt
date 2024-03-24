package com.ingrydduarte.projetocardapio

import android.content.Intent
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
            binding.checkBeb1 to 6, binding.checkBeb2 to 5, binding.checkBeb3 to 8
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
                // lista dos textos dos TextViews relacionados às CheckBoxes marcadas
                val stringsCheck = checkCaixas.filterKeys { checkBox ->
                    checkBox.isChecked
                }.keys.mapNotNull { checkBox ->
                    // encontra o TextView relacionado à CheckBox
                    when (checkBox) {
                        binding.checkEnt1 -> binding.textEntrada1
                        binding.checkEnt2 -> binding.textEntrada2
                        binding.checkEnt3 -> binding.textEntrada3
                        binding.checkPrato1 -> binding.textPrato1
                        binding.checkPrato2 -> binding.textPrato2
                        binding.checkPrato3 -> binding.textPrato3
                        binding.checkSob1 -> binding.textSob1
                        binding.checkSob2 -> binding.textSob2
                        binding.checkSob3 -> binding.textSob3
                        binding.checkBeb1 -> binding.textBeb1
                        binding.checkBeb2 -> binding.textBeb2
                        binding.checkBeb3 -> binding.textBeb3
                        else -> null
                    }
                }.map { it.text.toString() }

                // inicia a segunda tela e passa armazenando os valores
                val intent = Intent(this, TelaConfirmar::class.java)
                intent.putStringArrayListExtra("stringsChecks", ArrayList(stringsCheck))
                startActivity(intent)
            } else {
                // se nenhum opção marcada
                Toast.makeText(this, "Marque pelo menos uma opção", Toast.LENGTH_LONG).show()
            }
        }
    }

    // atualiza o texto do label com o novo total
    fun atualizarLabelTotal() {
        textoLabel.text = getString(R.string.labelPreco, total)
    }
}

