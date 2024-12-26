package com.sulivan.navegacaoentretelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val MAIN_ACTIVITY_PARAMETER  = "MAIN_ACTIVITY_PARAMETER"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //      enableEdgeToEdge() -> faz a tela ocupar toda area da tela, inclusive area de status
        setContentView(R.layout.activity_main)

        //esse intent é gerado automaticamente pelo android quando
        //a actitivy é lançada
        intent.extras?.getString(SECOND_ACTIVITY_PARAMETER).let {
            findViewById<TextView>(R.id.originText).text = it
        }

        findViewById<Button>(R.id.buttonOpenSecondActivity).setOnClickListener {
            val intent = Intent(this,SecondViewActivity::class.java)
            //putExtra envia parametros para o intent, para que possa ser interceptado na activity acionada
            intent.putExtra(MAIN_ACTIVITY_PARAMETER, "Aberto pela main actitivy")
            startActivity(intent)
        }

    }
}