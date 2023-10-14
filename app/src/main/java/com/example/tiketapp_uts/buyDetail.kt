package com.example.tiketapp_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiketapp_uts.databinding.ActivityBuyDescriptionBinding
import com.example.tiketapp_uts.databinding.ActivityBuyDetailBinding

class buyDetail : AppCompatActivity() {
    private lateinit var binding : ActivityBuyDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBuyDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val bioskop = intent.getStringExtra(buyDescription.bioskop)
        val seat = intent.getStringExtra(buyDescription.jenisTiket)
        val harga = intent.getStringExtra(buyDescription.harga)
        val payment = intent.getStringExtra(buyDescription.paymentMethod)
        val tanggal = intent.getStringExtra(buyDescription.tanggal)
        val bank = intent.getStringExtra(buyDescription.bank)
        var movie = intent.getParcelableExtra<movie>("movie")

        with(binding){
            if (movie != null) {
                imgs.setImageResource(movie.thumbnail)
                JUDUL.text = movie.name
            }

            BIOSKOP.text = bioskop
            tanggalTxt.text = tanggal
            SEAT.text = seat
            PRICE.text = harga
            if(payment != "Cash") {
                PAYMENT.text = "$payment, ($bank)"
            }else{
                PAYMENT.text = "$payment"
            }
        }
    }
}