package com.sulivan.navegacaoentretelas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val SECOND_ACTIVITY_PARAMETER  = "SECOND_ACTIVITY_PARAMETER"

class SecondViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//      enableEdgeToEdge() -> faz a tela ocupar toda area da tela, inclusive area de status

        setContentView(R.layout.activity_second)

        //esse intent é gerado automaticamente pelo android quando
        //a actitivy é lançada
        intent.extras?.getString(MAIN_ACTIVITY_PARAMETER).let {
            findViewById<TextView>(R.id.originText).text = it
        }

        findViewById<Button>(R.id.buttonOpenMainActivity).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(SECOND_ACTIVITY_PARAMETER, "Aberto pela ${javaClass.simpleName}")
            startActivity(intent)
        }

    }
}