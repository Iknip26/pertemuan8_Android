package com.example.tiketapp_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiketapp_uts.databinding.ActivityDeskripsiFilmBinding

class deskripsiFilm : AppCompatActivity() {
    companion object {
        var judul_film = "dwwd"
        var imagess = "image"
    }

    private lateinit var binding : ActivityDeskripsiFilmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDeskripsiFilmBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var movie = intent.getParcelableExtra<movie>("movie")
        if (movie != null){
            binding.image.setImageResource(movie.thumbnail)
            binding.judulTxt.text = movie.name
            binding.genreTxt.text = "genre : ${movie.genre}"
            binding.rateImg.setImageResource(movie.rate)
            binding.sutradaraTxt.text = "Directed by : " + movie.sutradara
            binding.ratingTxt.text = movie.rate_txt
            binding.sinopsisTxt.text = movie.deskripsiFilm
        }

        with(binding){
            submitButton.setOnClickListener {
                val intentPayment = Intent(this@deskripsiFilm, buyDescription::class.java)
                if (movie != null) {
                    intentPayment.putExtra("movie", movie)
                    startActivity(intentPayment)
                }
            }
        }
    }
}