package com.example.httpdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import okhttp3.*
import java.io.IOException


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun fetchJson(){
        TODO("not yet implemented")

        Log.i("HttpDemo", "Loading JSON")

        var url= "https://my-json-server.typicode.com/johnrowley/demojson/posts"

        Log.i("HTTPDemo", "url= $url")

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")

                println("FAiled to load json")

            }

            override fun onResponse(call: Call, response: Response) {
                TODO("Not yet implemented")

                println("successfully loaded json")

                val body = response?.body?.string()
                println(body)

                if (body != null) {
                    Log.i("HTTPDEMO", body)

                }
            }

        })

    }
}