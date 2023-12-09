package com.javier.cursokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import firstapp.FirstAppActivity
import imcCalculator.IMCActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val btnSaludApp = findViewById<Button>(R.id.btnSaludApp)
        btnSaludApp.setOnClickListener {navigateSaludApp()}
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnSaludApp.setOnClickListener {navigateIMCApp()}
    }

    private fun navigateIMCApp() {
    val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }

    private fun navigateSaludApp(){
    val intent= Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}