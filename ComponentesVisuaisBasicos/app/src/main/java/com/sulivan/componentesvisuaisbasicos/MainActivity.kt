package com.sulivan.componentesvisuaisbasicos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val campoDeTexto = findViewById<EditText>(R.id.campoPesquisas)
        val botaoProcurar = findViewById<Button>(R.id.botaoPesquisa)
        val barraProgresso = findViewById<ProgressBar>(R.id.BarraProgresso)
        val containerPesquisa = findViewById<ScrollView>(R.id.containerPesquisa)
        val imagemResultado = findViewById<ImageView>(R.id.imagemResultado)
        val tituloRsultado =  findViewById<TextView>(R.id.tituloResultado)
        val descricaoResultado =  findViewById<TextView>(R.id.descricaoResultado)

        botaoProcurar.setOnClickListener {

            val valorPesquisado = campoDeTexto.text
            val toast = Toast.makeText(this,"Valor do campo texto é: ${valorPesquisado.toString()}",Toast.LENGTH_SHORT)
            toast.show()

            //Inicia funcao assincrona
            //lifecycleScope fornece um escopo protegido
            //e local para executar funcoes assincronas
            lifecycleScope.launch {

                //Iniciando pesquisa
                barraProgresso.isVisible = true
                botaoProcurar.isVisible = false
                campoDeTexto.isEnabled = false
                containerPesquisa.isVisible = false
                tituloRsultado.text = ""
                descricaoResultado.text = ""
                imagemResultado.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@MainActivity,
                        R.mipmap.ic_launcher
                    )
                )

                //Pesquisando resultado
                if (valorPesquisado.toString().trim() == "lagarto") {
                    val result = consultarLagarto()
                    tituloRsultado.text = result.titulo
                    descricaoResultado.text = result.descricao

                    //Com o ?.let o codigo o setImageDrawable
                    //só será chamado se a imagem não for null
                    result.imagem?.let {
                        imagemResultado.setImageDrawable(it)
                    }
                }
                containerPesquisa.isVisible = true

                //Resetando valores para nova pesquisa
                barraProgresso.isVisible = false
                botaoProcurar.isVisible = true
                campoDeTexto.isEnabled = true

            }
        }
    }

    suspend fun consultarLagarto(): InsetoModel{
        delay(1500)
        return InsetoModel(
            titulo = "lagarto",
            descricao = "Lagarto, calango, labigó, dependendo de onde você mora no Brasil, esses animais vão receber diferentes nomes populares que, no entanto, pertencem à mesma linhagem. Os lagartos, assim como as serpentes, pertencem à linhagem Lepidosauria (Lepisidos = escamas; sayros = lagartos), uma linhagem irmã das aves, crocodilos e dos dinossauros não-avianos. Juntamente com as serpentes, eles compõe a ordem Squamatta, que é um termo em latim para plural de escamado, se referindo à principal característica externa dos lagartos que é ter a pele coberta por escamas. Uma das principais diferenças entre lagartos e os répteis da linhagem dos dinossauros e das aves é em relação ao posicionamento dos membros, nos lagartos eles ficam posicionados lateralmente ao corpo enquanto nos répteis da linhagem dos dinossauros e das aves, os membros ficam posicionados abaixo do corpo. Atualmente existem cerca de 5500 espécies de lagartos e essas estão distribuídas em quatorze famílias que são: Amphisbaenidae (com 164 espécies), Lacertidae (306), Teiidae (135), Gymnophtalmidae (231), Anguidae (118), Helodermatidae (2), Varanidae (73), Iguanidae (38), Phrynosomatidae (137), Dactyloidae (377), Chamaleonidae (187), Agamidae (416), Scincidae (1503) e Gekkonidae (881). Dessas famílias, as únicas em que nenhuma espécie ocorrem no Brasil são Agamidae, Chamaleonidae, Phrysonomatidae, Varanidae, Helodermatidae e Lacertidae.",
            imagem = ContextCompat.getDrawable(this@MainActivity,R.mipmap.lagarto)
        )
    }
}

