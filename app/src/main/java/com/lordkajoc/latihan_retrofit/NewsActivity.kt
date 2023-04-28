package com.lordkajoc.latihan_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lordkajoc.latihan_retrofit.databinding.ActivityMainBinding
import com.lordkajoc.latihan_retrofit.databinding.ActivityNewsBinding
import com.lordkajoc.latihan_retrofit.model.GetAllNewsResponesItem
import com.lordkajoc.latihan_retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Response

class NewsActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getDataNews()
    }

    fun getDataNews() {
        ApiClient.instance.getAllNews()
            .enqueue(object : retrofit2.Callback<List<GetAllNewsResponesItem>> {

                override fun onResponse(
                    call: Call<List<GetAllNewsResponesItem>>,
                    response: Response<List<GetAllNewsResponesItem>>
                ) {
                    if (response.isSuccessful) {
                        val lm = LinearLayoutManager(
                            applicationContext,
                            LinearLayoutManager.VERTICAL,
                            false
                        )
                        binding.rvlistnews.layoutManager = lm
                        binding.rvlistnews.adapter = AdapterNews(response.body()!!)
                    } else {
                        Toast.makeText(this@NewsActivity, "Failed Load Data", Toast.LENGTH_LONG)
                            .show()
                    }
                }

                override fun onFailure(call: Call<List<GetAllNewsResponesItem>>, t: Throwable) {
                    Toast.makeText(this@NewsActivity, t.message, Toast.LENGTH_LONG).show()
                }
            })
    }
}