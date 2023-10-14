package com.example.tiketapp_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import com.example.tiketapp_uts.databinding.ActivityBuyDescriptionBinding
import com.example.tiketapp_uts.databinding.ActivityDeskripsiFilmBinding

private val BIOSKOP = arrayOf(
    "XXI Pakuwon Mall",
    "XXI JCM",
    "XXI Ambarukmo Plaza"
)

private val JENIS = arrayOf(
    "Reguler Seat",
    "4D",
    "VIP"
)

private val PAYMENT = arrayOf(
    "Bank Transfer",
    "Cash",
)

private val BANK = arrayOf(
    "BNI",
    "BRI",
    "Mandiri"
)

class buyDescription : AppCompatActivity() {
    companion object {
        var judul_film = "dwwd"
        var image = "image"
        var bioskop = "dwwd"
        var jenisTiket = "dwwd"
        var harga = "dwwd"
        var tanggal = "dwwd"
        var paymentMethod = ""
        var bank = ""
        var rekening =""
    }

    private lateinit var binding : ActivityBuyDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBuyDescriptionBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

            val adapterBioskop = ArrayAdapter(this@buyDescription, android.R.layout.simple_spinner_item, BIOSKOP);
            adapterBioskop.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinerBioskop.adapter = adapterBioskop

            binding.spinerBioskop.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(parent : AdapterView<*>, view: View, position: Int, id: Long) {
                    val selectedItemPos = parent.getItemAtPosition(position).toString()
                    bioskop = selectedItemPos
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        val adapterJenisTiket = ArrayAdapter(this@buyDescription, android.R.layout.simple_spinner_item, JENIS);
        adapterJenisTiket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinerJenisseat.adapter = adapterJenisTiket

        binding.spinerJenisseat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent : AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItemPos = parent.getItemAtPosition(position).toString()
                jenisTiket = selectedItemPos
                if(jenisTiket == "Reguler Seat"){
                    harga = "35000"
                }else if(jenisTiket == "4D"){
                    harga = "70000"
                }else{
                    harga = "100000"
                }
                binding.hargaTxt.text = harga
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val adapterPayment = ArrayAdapter(this@buyDescription, android.R.layout.simple_spinner_item, PAYMENT);
        adapterPayment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinerPaymethod.adapter = adapterPayment

        binding.spinerPaymethod.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent : AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItemPos = parent.getItemAtPosition(position).toString()
                paymentMethod = selectedItemPos
                if(paymentMethod=="Cash"){
                    binding.kolomBank.isVisible = false;
                }else{
                    binding.kolomBank.isVisible = true;
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val adapterJenisBank = ArrayAdapter(this@buyDescription, android.R.layout.simple_spinner_item, BANK);
        adapterJenisBank.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinerBank.adapter = adapterJenisBank

        binding.spinerBank.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent : AdapterView<*>, view: View, position: Int, id: Long) {
                val selectedItemPos = parent.getItemAtPosition(position).toString()
                bank = selectedItemPos
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }



        var judul = intent.getStringExtra(deskripsiFilm.judul_film)
        var images = intent.getStringExtra(deskripsiFilm.imagess)
        var movie = intent.getParcelableExtra<movie>("movie")

        with(binding){

            datePicker.init(
                datePicker.year,
                datePicker.month,
                datePicker.dayOfMonth
            ) { _, year, monthOfYear, dayOfMonth ->
                val selectedDate = "$dayOfMonth/${monthOfYear + 1}/$year"
                tanggal = selectedDate
            }

            buttonSubmit.setOnClickListener{
                val intentEnd = Intent(this@buyDescription, buyDetail::class.java)
                intentEnd.putExtra("movie", movie)
                intentEnd.putExtra(judul_film, judul)
                intentEnd.putExtra(tanggal, tanggal)
                intentEnd.putExtra(bioskop, bioskop)
                intentEnd.putExtra(jenisTiket, jenisTiket)
                intentEnd.putExtra(harga, harga)
                intentEnd.putExtra(paymentMethod, paymentMethod)
                if(paymentMethod != "Cash"){
                    intentEnd.putExtra(bank, bank)
                    intentEnd.putExtra(rekening, rekeningInp.text.toString())
                }
                startActivity(intentEnd)
            }
        }
    }
}

