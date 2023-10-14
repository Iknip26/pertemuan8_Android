package com.example.tiketapp_uts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tiketapp_uts.databinding.ActivityHomeScreenBinding

class homeScreen : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var movieList: ArrayList<movie>
    private lateinit var movieAdapter: movieAdapter
    private lateinit var binding: ActivityHomeScreenBinding
    private lateinit var deskripsi: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHomeScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        deskripsi = resources.getStringArray(R.array.list_deskripsi)

        binding.recycleView.setHasFixedSize(true)
        binding.recycleView.layoutManager = GridLayoutManager(this, 2)

        movieList = ArrayList()

        movieList.add(movie(R.drawable.img1, "Grand Turismo", "Sports, Action", "Neill Blomkamp", R.drawable.rate4, "4",  deskripsi[0]))
        movieList.add(movie(R.drawable.img2, "The Nun 2", "Horror, Thriller", "Michael Chaves", R.drawable.rate5, "5", deskripsi[1]))
        movieList.add(movie(R.drawable.img3, "Doraemon Sky Utopia", "Anime, Sci fi", "Takumi Dôyama", R.drawable.rate4, "4", deskripsi[2]))
        movieList.add(movie(R.drawable.img4, "Spy X Family", "Anime, Comedy",  "Tatsuya Endo", R.drawable.rate4, "4", deskripsi[3]))
        movieList.add(movie(R.drawable.img5, "Loki", "Sci fi, Action",  "Michael Waldron", R.drawable.rate3, "3",  deskripsi[4]))
        movieList.add(movie(R.drawable.img6, "Ice Cold", "Documenter, Politics", "Rob Sixsmith", R.drawable.rate5, "5", deskripsi[5]))

        movieAdapter = movieAdapter(movieList)
        binding.recycleView.adapter = movieAdapter

        val name = intent.getStringExtra(Login.names)
        binding.username.text = name

        with(binding){
            movieAdapter.onItemClick = {
                val intentToDescription = Intent(this@homeScreen, deskripsiFilm::class.java)
                intentToDescription.putExtra("movie", it)
                startActivity(intentToDescription)
            }
        }
    }
}