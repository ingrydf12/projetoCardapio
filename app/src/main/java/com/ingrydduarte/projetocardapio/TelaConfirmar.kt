package com.ingrydduarte.projetocardapio

//import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.ingrydduarte.projetocardapio.databinding.ActivityTelaConfirmarBinding

class TelaConfirmar : AppCompatActivity() {
    private lateinit var binding: ActivityTelaConfirmarBinding
    private lateinit var btnConfirmado: Button
    private lateinit var btnVolte: RelativeLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_confirmar)
        binding = ActivityTelaConfirmarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //referenciando o botão confirmar
        btnConfirmado = binding.btnconfirma
        //referenciando o botão de voltar
        btnVolte = binding.btnvoltar
        // Recupera os textos dos TextViews da tela anterior
        val stringsChecks = intent.getStringArrayListExtra("stringsChecks")

        // Exibe os textos dos TextViews na segunda tela
        val checkDados = binding.txtVDados
        val recap = stringsChecks?.joinToString("\n") ?: "Nenhuma opção selecionada"
        checkDados.text = recap

        //como é opcional o cliente escrever algo, é colocada a ação de toast direto.
        btnConfirmado.setOnClickListener{
            Toast.makeText(this, "Pedido enviado ao restaurante.", Toast.LENGTH_LONG).show()
        }

        //evento botão de volta
        btnVolte.setOnClickListener {
            finish() //finaliza a atividade atual e volta a anterior
        }
    }
}
