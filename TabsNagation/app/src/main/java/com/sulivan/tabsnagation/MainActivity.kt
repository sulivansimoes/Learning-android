package com.sulivan.tabsnagation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sulivan.tabsnagation.Fragments.FeedFragment
import com.sulivan.tabsnagation.Fragments.HomeFragment
import com.sulivan.tabsnagation.Fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationMenu = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationMenu.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId ){
                R.id.navigation_home -> {
                    replaceFragment(HomeFragment())
                }
                R.id.navigation_dashboard -> {
                    replaceFragment(FeedFragment())
                }
                R.id.navigation_profile -> {
                    replaceFragment(ProfileFragment())
                }
                else -> false
            }
        }

        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment:Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerview, fragment).commit()
        return true;
    }
}