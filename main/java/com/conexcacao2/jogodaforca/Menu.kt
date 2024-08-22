package com.conexcacao2.jogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import com.conexcacao2.jogodaforca.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //Quando o botão do jogo é clicado, ele abre a atividade principal.
        binding.btJogo.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Botão de Fechamento da atividade.
        binding.btSair.setOnClickListener {

            finishAffinity( )

        }

    }
}
