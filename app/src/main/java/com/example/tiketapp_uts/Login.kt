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
        var emails = ""
        var passwords = ""
        var phones = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        usernames = intent.getStringExtra(Register.usernames).toString()
        emails = intent.getStringExtra(Register.emails).toString()
        passwords = intent.getStringExtra(Register.passwords).toString()
        phones = intent.getStringExtra(Register.phones).toString()

        with(binding){
            loginButton.setOnClickListener{
                if(emailInp.text.toString()!="" && passInp.text.toString()!=""){
                    if(emailInp.text.toString() == emails && passInp.text.toString() == passwords){
                        val intentHome = Intent(this@Login, homeScreen::class.java)
                        intentHome.putExtra(usernames, usernames)
                        intentHome.putExtra(emails, emails)
                        intentHome.putExtra(passwords, passwords)
                        intentHome.putExtra(phones, phones)
                        startActivity(intentHome)
                        finish()
                        true
                    }else{
                        Toast.makeText(this@Login, "Password / Username salah", Toast.LENGTH_SHORT).show()
                    }
                } else{
                    Toast.makeText(this@Login, "Semua kolom harus di isi", Toast.LENGTH_SHORT).show()
                }
            }

            link.setOnClickListener{
                val intentRegis = Intent(this@Login, Register::class.java)
                startActivity(intentRegis)
            }
        }
    }
}