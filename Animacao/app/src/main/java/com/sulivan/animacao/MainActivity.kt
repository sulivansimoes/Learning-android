package com.sulivan.animacao

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.sulivan.animacao.databinding.ActivityMainBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TOTAL_ROLLS = 6

class MainActivity : AppCompatActivity() {

    private lateinit var biding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      enableEdgeToEdge()

        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)

        biding.rollButton.setOnClickListener {

            lifecycleScope.launch {
                for( i in 0 until TOTAL_ROLLS){
                    delay(100)
                    val random = Dice( 6 ).roll()
                    biding.resultValue.text = random.toString()
                }
            }
        }

    }
}