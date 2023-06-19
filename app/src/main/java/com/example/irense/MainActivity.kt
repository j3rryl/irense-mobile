package com.example.irense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<MeowBottomNavigation>(R.id.btm_nav)
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.person))
        bottomNavigation.add(MeowBottomNavigation.Model(2, R.drawable.bar_chart))
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.list))

    }
}