package com.conexcacao2.jogodaforca


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.conexcacao2.jogodaforca.R.*
import com.conexcacao2.jogodaforca.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {

    private lateinit var questaoTextView: TextView

    //Lista das perguntas e respostas
    private val questoes = listOf(
        Questao("Qual é a capital do Brasil?", "Brasília", listOf("São Paulo", "Brasília", "Rio de Janeiro", "Salvador")),
        Questao("Qual é a capital da Nova zelândia?", "Wellington", listOf("Wellington", "Ottawa", " Bogotá", "Quebec")) ,
        Questao("Qual é a capital da França?", "Paris", listOf("Lima", "Washigton", "Veneza", "Paris")),
        Questao("Qual é a capital da Estados Unidos?", "Washington", listOf("Buenos Aires", "Washigton", "Flórida", "Rio de janeiro")),
        Questao("Qual é a capital da Noruega?", "Oslo", listOf("Bergen", "Santiago", "Oslo", "Bruxelas")),
        Questao("Qual é a capital da Finlândia?", "Helsinque", listOf("Copenhage", "Hamburgo", "londres", "Helsinque")),
        Questao("Qual é a capital da Alemanha?", "Berlim", listOf("Munique", "Corfu", "Berlim", "Milão")),
        Questao("Qual é a capital da Grécia?", "Atenas", listOf("Atenas", "Capadócia", "Teerão", "Santorini")) ,
        Questao("Qual é a capital da Turquia?", "Ancara", listOf("Haifa", "Istambul", " Ancara", "Cairo")) ,
        Questao("Qual é a capital da México?", "Cidade do México", listOf("La Paz", "Montreal", "Cancún", "Cidade do México")) ,
        Questao("Qual é a capital da Chile?", "Santiago", listOf("La Serena", "Valparaíso", "Valdivia","Santiago" )) ,
        Questao("Qual é a capital da Venezuela?", "Caracas", listOf("Caracas", "Santiago", "Maracaibo", "Bergen")) ,
        Questao("Qual é a capital da Angola?", "Luanda", listOf("Cairo", "Luanda", "Caboledo", "Malange")) ,
        Questao("Qual é a capital da Bélgica?", "Bruxelas", listOf("Gante", "Bruges", " Corfu", "Bruxelas")) ,
        Questao("Qual é a capital da Portugal?", "Lisboa", listOf("Sevilha", "Madeira", " Lisboa", "Cabo Verde")) ,
        Questao("Qual é a capital da Canadá?", "Ottawa", listOf("Toronto", "Ottawa", " Quebec", "São Francisco")) ,
        Questao("Qual é a capital da Guiné-Bissau?", "Bissau", listOf("Bafatá", "Canhabaque", "Bissau", "Cacheu")) ,
        Questao("Qual é a capital da Cabo Verde ?", "Praia", listOf("Boa Vista", "Cidade Velha", "Picos", "Praia")) ,
        Questao("Qual é a capital da Jamaica?", "Kingston", listOf("Kingston", "Negril", "Ocho Rios", "Montego Bay")) ,
        Questao("Qual é a capital da Panamá?", "Cidade do Panamá", listOf("Colón", "Coiba", "Cidade do Panamá", "Boquete")) ,
        Questao("Qual é a capital da Costa Rica?", "San José", listOf("San José", "Cartago", "Heredia", "Uvita")) ,
        Questao("Qual é a capital da Burkina Faso?", "Uagadugu", listOf("Nouna", "Banfora", "Uagadugu", "Réo")) ,
        Questao("Qual é a capital da Nicarágua?", "Manágua", listOf("Granada", "León", "San Juan del Sur", "Manágua")) ,
        Questao("Qual é a capital da Haiti?", "Porto Princípe", listOf("Port Royal", "Porto Princípe", "Labadee", "Cabo Haitiano")) ,
        Questao("Qual é a capital da Egito?", "Cairo", listOf("Cairo", "Luxor", "Alexandria", "Guizé")) ,
        Questao("Qual é a capital da Israel?", "Jerusalém", listOf("Telavive", "Haifa", "Nazaré","Jerusalém" )) ,







    )

    //Criando as variáveis de tipo Botão.
    private var questaoRecenteIndex = 0
    lateinit var opcao1Button: Button
    lateinit var opcao2Button: Button
    lateinit var opcao3Button: Button
    lateinit var opcao4Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        var binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)




        questaoTextView = findViewById(id.questaoTextView)
        opcao1Button = findViewById(id.opcao1Button)
        opcao2Button = findViewById(id.opcao2Button)
        opcao3Button = findViewById(id.opcao3Button)
        opcao4Button = findViewById(id.opcao4Button)

        carregarQuestao()

        opcao1Button.setOnClickListener { verificarResposta(opcao1Button.text.toString()) }
        opcao2Button.setOnClickListener { verificarResposta(opcao2Button.text.toString()) }
        opcao3Button.setOnClickListener { verificarResposta(opcao3Button.text.toString()) }
        opcao4Button.setOnClickListener { verificarResposta(opcao4Button.text.toString()) }


    }

    //Função de carregar a questão.
    private fun carregarQuestao() {
        val questaoRecente = questoes[questaoRecenteIndex]
        questaoTextView.text = questaoRecente.texto
        val opcoes = questaoRecente.opcoes.shuffled()
        opcao1Button.text = opcoes[0]
        opcao2Button.text = opcoes[1]
        opcao3Button.text = opcoes[2]
        opcao4Button.text = opcoes[3]
    }
    //Função de verificar a resposta.
    private fun verificarResposta(opcaoSelecionada: String) {
        val respostaCorreta = questoes[questaoRecenteIndex].resposta
        if (opcaoSelecionada == respostaCorreta) {
            //Se a opção selecionada pelo usuário for a correta, aparecerá para ele uma mensagem dizendo que ele ganhou.
            Toast.makeText(this, "Você ganhou :)", Toast.LENGTH_LONG).show()
           //Se não aparecerá que ele perdeu.
        } else {
            Toast.makeText(this, "Você Perdeu :(", Toast.LENGTH_LONG).show()
        }
        // Ir para a outra pergunta.
        questaoRecenteIndex = (questaoRecenteIndex + 1) % questoes.size
        carregarQuestao()

        var binding = ActivityMainBinding.inflate(layoutInflater)

        //Botão para voltar ao menu.
        binding.btVoltar.setOnClickListener {
            val intent = Intent(this@MainActivity, Menu::class.java)
            startActivity(intent)
            finish()
        }

    }

}

data class Questao(val texto: String, val resposta: String, val opcoes: List<String>)


