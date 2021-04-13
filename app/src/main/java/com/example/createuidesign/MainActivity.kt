package com.example.createuidesign

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * CONFIGURING THE SWITCH BUTTON
         * */

        val switchBack : SharedPreferences = getSharedPreferences("switchBack", 0)
        val sharedPreferences: SharedPreferences.Editor = switchBack.edit()
        val isNightModeOn: Boolean = switchBack.getBoolean("NightMode", false)

        if (isNightModeOn) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        }

        var btn = findViewById<Button>(R.id.btn)
        btn.setOnClickListener {
            if (isNightModeOn) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedPreferences.putBoolean("NightMode", false)
                sharedPreferences.apply()
            } else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedPreferences.putBoolean("NightMode", true)
                sharedPreferences.apply()
            }
        }

        /**
         * REMOVE THE NAME OF THE ACTIVITY
         */
        var bar = supportActionBar
        bar?.hide()

    }
}