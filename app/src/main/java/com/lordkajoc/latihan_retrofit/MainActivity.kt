package com.lordkajoc.latihan_retrofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lordkajoc.latihan_retrofit.databinding.ActivityMainBinding
import com.lordkajoc.latihan_retrofit.model.GetAllNewsResponesItem
import com.lordkajoc.latihan_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNews.setOnClickListener {
            val pindahNews = Intent(this, NewsActivity::class.java)
            startActivity(pindahNews)
        }
        binding.buttonFilm.setOnClickListener {
            val pindahFilm = Intent(this, FilmActivity::class.java)
            startActivity(pindahFilm)
        }
    }
}