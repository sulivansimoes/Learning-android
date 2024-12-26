package com.sulivan.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val titleSharedPreference : String = "theme_preference"
    private lateinit var sharedPreference:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tollbar = findViewById<Toolbar>(R.id.toolbar)

        //Seta como action bar principal do App
        setSupportActionBar(tollbar)

        this.sharedPreference = getSharedPreferences(this.titleSharedPreference, Context.MODE_PRIVATE)

        apllySavedTheme()
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_theme, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.menu_theme_dark -> {
                apllyTheme(AppCompatDelegate.MODE_NIGHT_YES)
                true
            }
            R.id.menu_theme_light -> {
                apllyTheme(AppCompatDelegate.MODE_NIGHT_NO)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun apllyTheme(themeMode: Int){
        AppCompatDelegate.setDefaultNightMode(themeMode)
        saveTheme(themeMode)
    }

    private fun apllySavedTheme(){

        val savedThemeMode = this.sharedPreference.getInt(titleSharedPreference,AppCompatDelegate.MODE_NIGHT_NO)
        apllyTheme(savedThemeMode)
    }

    //persite o tema escolhido no sharedPreference (analogo ao localStorage)
    private fun saveTheme(themeMode:Int){
        val editorSharedPreference = this.sharedPreference.edit()
        editorSharedPreference.putInt(this.titleSharedPreference, themeMode)
        editorSharedPreference.apply()
    }
}