package com.sulivan.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val itemList = listOf(
            "Tela 1 Titulo 1",
            "Tela 2 Titulo 2",
            "Tela 3 Titulo 3",
        )

        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        viewPager2.adapter = ViewPager2Adapter(this, itemList)

        val tablayout = findViewById<TabLayout>(R.id.tabLayout)

        TabLayoutMediator(tablayout, viewPager2){ _, _ ->
        }.attach()


    }
}