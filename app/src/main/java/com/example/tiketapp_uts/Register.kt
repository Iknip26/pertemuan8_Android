package com.example.tiketapp_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tiketapp_uts.databinding.ActivityLoginBinding
import com.example.tiketapp_uts.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    companion object{
        var usernames = "user"
        val names = "nama"
        var passwords = "password"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            regisButton.setOnClickListener{
                if(username.text.toString()!="" && password.text.toString()!="" && nama.text.toString()!=""){
                    val intentLogin = Intent(this@Register, Login::class.java)
                    intentLogin.putExtra(usernames, username.text.toString())
                    intentLogin.putExtra(passwords, password.text.toString())
                    intentLogin.putExtra(names, nama.text.toString())
                    startActivity(intentLogin)
                }else{
                    Toast.makeText(this@Register, "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }

            link.setOnClickListener{
                val intentRegis = Intent(this@Register, Login::class.java)
                startActivity(intentRegis)
            }
        }
    }
}