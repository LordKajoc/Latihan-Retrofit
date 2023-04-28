package com.lordkajoc.latihan_retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lordkajoc.latihan_retrofit.databinding.ActivityFilmBinding
import com.lordkajoc.latihan_retrofit.model.GetAllFIlmResponseItem
import com.lordkajoc.latihan_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class FilmActivity : AppCompatActivity() {
    lateinit var binding: ActivityFilmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFilmBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataFilm()
    }

    fun getDataFilm() {
        ApiClient.instance.getAllFilm()
            .enqueue(object : retrofit2.Callback<List<GetAllFIlmResponseItem>> {

                override fun onResponse(
                    call: Call<List<GetAllFIlmResponseItem>>,
                    response: Response<List<GetAllFIlmResponseItem>>
                ) {
                    if (response.isSuccessful) {
                        val lm = LinearLayoutManager(
                            applicationContext,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        binding.rvlistfilm.layoutManager = lm
                        binding.rvlistfilm.adapter = AdapterFilm(response.body()!!)
                    } else {
                        Toast.makeText(this@FilmActivity, "Failed Load Data", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllFIlmResponseItem>>, t: Throwable) {
                    Toast.makeText(this@FilmActivity, t.message, Toast.LENGTH_LONG).show()
                }
            })
    }
}