package com.example.tiketapp_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tiketapp_uts.databinding.ActivityLoginBinding

class Login : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding

    companion object{
        var usernames = ""
        val names = ""
        var passwords = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var username = intent.getStringExtra(Register.usernames)
        var name = intent.getStringExtra(Register.names)
        var password = intent.getStringExtra(Register.passwords)

        with(binding){
            loginButton.setOnClickListener{
                if(email.text.toString() == username && pass.text.toString() == password){
                    val intentHome = Intent(this@Login, homeScreen::class.java)
                    intentHome.putExtra(usernames, username)
                    intentHome.putExtra(names, name)
                    intentHome.putExtra(passwords, password)
                    startActivity(intentHome)
                }else{
                    Toast.makeText(this@Login, "Password / Username salah", Toast.LENGTH_SHORT).show()
                }
            }

            link.setOnClickListener{
                val intentRegis = Intent(this@Login, Register::class.java)
                startActivity(intentRegis)
            }
        }
    }
}