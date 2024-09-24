package com.si.logginview

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.si.logginview.secondscreen.SecondScreenActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.password)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun enterBtn(view: View){
        val senhaInput: TextView = findViewById(R.id.passField)
        val emailInput: TextView = findViewById(R.id.emailField)


        val nomeUsuario = "Davi"
        val senhaUsuario = "abc"
        val emailUsuario = "abc@gmail.com"


        if (senhaInput.text.toString() == senhaUsuario && emailInput.text.toString() == emailUsuario){
            val bundle = Bundle()
            bundle.putString("nome", nomeUsuario)
            bundle.putString("email", emailUsuario)

            val intent = Intent(this, SecondScreenActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        } else {
            val text = "Credenciais erradas, verifique os dados e tente novamente."

            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(this, text, duration)
            toast.show()


            emailInput.text = ""
            senhaInput.text = ""
        }
    }
}
