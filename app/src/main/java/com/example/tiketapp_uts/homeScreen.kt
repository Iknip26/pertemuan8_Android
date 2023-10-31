package com.example.tiketapp_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tiketapp_uts.databinding.ActivityHomeScreenBinding

class homeScreen : AppCompatActivity() {
    private lateinit var binding: ActivityHomeScreenBinding

    companion object{
        var names = ""
        var emails = ""
        var phones = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceFragment(home())

        names = intent.getStringExtra(Login.usernames).toString()
        emails = intent.getStringExtra(Login.phones).toString()
        phones = intent.getStringExtra(Login.emails).toString()

        with(binding){

            bottomNav.setOnItemSelectedListener{
                when(it.itemId){
                    R.id.home_menu -> replaceFragment(home())
                    R.id.notification_menu -> replaceFragment(ticket())
                    R.id.profile_menu -> replaceFragment(profile())

                    else->{}
                }
                true
            }
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}