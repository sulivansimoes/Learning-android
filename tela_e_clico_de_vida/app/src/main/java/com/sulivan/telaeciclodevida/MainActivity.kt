package com.sulivan.telaeciclodevida

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val TAG = "ActivityLifeCycle::"

class MainActivity : AppCompatActivity() {

    val meufragment = BlankFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonAdd).setOnClickListener {

            //finish(); finaliza activity
            val fragmentTransicao = supportFragmentManager.beginTransaction(); //supportFragmentManager gerencia a fragment dentro do activity
            fragmentTransicao.replace(R.id.fragmentComponet,meufragment).commit(); //Substitui o que estiver fragmentTransicao pelo fragmentBlank criado
        }

        findViewById<Button>(R.id.buttonRemove).setOnClickListener {

            val fragmentTransicao = supportFragmentManager.beginTransaction(); //supportFragmentManager gerencia a fragment dentro do activity
            fragmentTransicao.remove(meufragment).commit(); //Substitui o que estiver fragmentTransicao pelo fragme
        }

        println("$TAG${javaClass.simpleName} onCreate")
    }

    override fun onStart(){
        super.onStart()
        println("$TAG${javaClass.simpleName} onStart")
    }

    override fun onRestart(){
        super.onRestart()
        println("$TAG${javaClass.simpleName} onRestart")
    }

    override fun onResume(){
        super.onResume()
        println("$TAG${javaClass.simpleName} onResume")
    }

    override fun onPause(){
        super.onPause()
        println("$TAG${javaClass.simpleName} onPause")
    }

    override fun onStop(){
        super.onStop()
        println("$TAG${javaClass.simpleName} onStop")
    }

    override fun onDestroy(){
        super.onDestroy()
        println("$TAG${javaClass.simpleName} onDestroy")
    }
}