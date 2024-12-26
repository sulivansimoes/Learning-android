package com.sulivan.componentescustomizados

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView

class BotaoCategoria(context:Context, attrs:AttributeSet) : LinearLayout (context,attrs){

    init {
        inflate(context, R.layout.botao_categoria, this@BotaoCategoria)
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.CategoryButton,
            0,0
        ).apply {
            try {
                findViewById<TextView>(R.id.buttonTitle).text = getString(R.styleable.CategoryButton_titleButton)
                findViewById<TextView>(R.id.emojiICon).text = getString(R.styleable.CategoryButton_emojiIcon)
            } finally {
                recycle()
            }
        }
    }
}