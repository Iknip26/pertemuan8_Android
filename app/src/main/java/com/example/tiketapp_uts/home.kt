package com.example.tiketapp_uts

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tiketapp_uts.databinding.ActivityHomeScreenBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [home.newInstance] factory method to
 * create an instance of this fragment.
 */
class home : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var movieList: ArrayList<movie>
    private lateinit var movieAdapter: movieAdapter
    private lateinit var deskripsi: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val fragmentHome = inflater.inflate(R.layout.fragment_home, container, false)
        deskripsi = resources.getStringArray(R.array.list_deskripsi)

        var rView = fragmentHome.findViewById<RecyclerView>(R.id.recycle_view)
        rView.setHasFixedSize(true)
        rView.layoutManager = GridLayoutManager(activity, 2)

        movieList = ArrayList()
        movieList.add(movie(R.drawable.img1, "Grand Turismo", "Sports, Action", "Neill Blomkamp", R.drawable.rate4, "4",  deskripsi[0]))
        movieList.add(movie(R.drawable.img2, "The Nun 2", "Horror, Thriller", "Michael Chaves", R.drawable.rate5, "5", deskripsi[1]))
        movieList.add(movie(R.drawable.img3, "Doraemon Sky Utopia", "Anime, Sci fi", "Takumi Dôyama", R.drawable.rate4, "4", deskripsi[2]))
        movieList.add(movie(R.drawable.img4, "Spy X Family", "Anime, Comedy",  "Tatsuya Endo", R.drawable.rate4, "4", deskripsi[3]))
        movieList.add(movie(R.drawable.img5, "Loki", "Sci fi, Action",  "Michael Waldron", R.drawable.rate3, "3",  deskripsi[4]))
        movieList.add(movie(R.drawable.img6, "Ice Cold", "Documenter, Politics", "Rob Sixsmith", R.drawable.rate5, "5", deskripsi[5]))

        movieAdapter = movieAdapter(movieList)
        rView.adapter = movieAdapter

        val username_txt = fragmentHome.findViewById<TextView>(R.id.username_home)
        username_txt.text = homeScreen.names

        movieAdapter.onItemClick = {
            val intentToDescription = Intent(activity, deskripsiFilm::class.java)
            intentToDescription.putExtra("movie", it)
            startActivity(intentToDescription)
        }

        // Inflate the layout for this fragment
        return fragmentHome
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Home_fragmet.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}