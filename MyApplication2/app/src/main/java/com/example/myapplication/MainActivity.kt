package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var predictionList = arrayListOf(

        "It is certain",
        "It is decidedly so",
        "Without a doubt",
        "Yes - definitely",
        "You may rely on it",
        "As I see it, yes",
        "Most likely",
        "Outlook good",
        "Yes",
        "Signs point to yes",
        "Reply hazy, try again",
        "Ask again later",
        "Better not tell you now",
        "Cannot predict now",
        "Concentrate and ask again",
        "Don't count on it",
        "My reply is no",
        "My sources say no",
        "Outlook not so good",
        "Very doubtful"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val demoButton : Button =findViewById(R. id.buttonDemo)

        demoButton.setOnClickListener {showPrediction()}


    }
    fun getPrediction() : String {

        val selectedPrediction = predictionList[0]

        return selectedPrediction

    }

    private fun showPrediction() {

        Log.i(  "DEBUG",  "APP HAS STARTED")
        Log.i(  "DEBUG",getPrediction())

        textViewMessage.text = getPrediction()

    }
}