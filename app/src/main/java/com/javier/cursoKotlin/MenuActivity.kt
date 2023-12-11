package com.javier.cursokotlin

import todoApp.TodoActivity
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
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)

        //Listener
        btnSaludApp.setOnClickListener {navigateSaludApp()}
        btnIMCApp.setOnClickListener {navigateIMCApp()}
        btnTODO.setOnClickListener{navigateTodoApp()}

    }


    private fun navigateIMCApp() {
    val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }

    private fun navigateSaludApp(){
    val intent= Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateTodoApp(){
        val intent= Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}