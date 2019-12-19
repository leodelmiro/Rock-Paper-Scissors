package com.example.leodelmiroms.pedrapapeloutesoura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var appChoice = 0
    private var userChoice = 0
    private val ROCK = 1
    private val PAPER = 2
    private val SCISSOR = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rockButton.setOnClickListener {
            appChoice = Random.nextInt(1,4)
            userChoice = ROCK
            appChoiceImageUpdate(appChoice)
            whoWon(appChoice, userChoice)
        }

        paperButton.setOnClickListener {
            appChoice = Random.nextInt(1,4)
            userChoice = PAPER
            appChoiceImageUpdate(appChoice)
            whoWon(appChoice, userChoice)
        }

        scissorButton.setOnClickListener {
            appChoice = Random.nextInt(1,4)
            userChoice = SCISSOR
            appChoiceImageUpdate(appChoice)
            whoWon(appChoice, userChoice)
        }

    }

    private fun whoWon(appChoice:Int, userChoice: Int){
        if((appChoice==ROCK && userChoice==SCISSOR) ||
            (appChoice==PAPER && userChoice==ROCK) ||
            (appChoice==SCISSOR && userChoice==PAPER)) gameAnnouncement.text = getString(R.string.you_lose)
        else if ((appChoice==ROCK && userChoice==PAPER) ||
            (appChoice==PAPER && userChoice==SCISSOR) ||
            (appChoice==SCISSOR && userChoice==ROCK)) gameAnnouncement.text = getString(R.string.you_win)
        else gameAnnouncement.text = getString(R.string.draw)
        }

    private fun appChoiceImageUpdate(appChoice: Int){
        when (appChoice) {
            1 -> appChoiceImage.setImageResource(R.drawable.pedra)
            2 -> appChoiceImage.setImageResource(R.drawable.papel)
            3 -> appChoiceImage.setImageResource(R.drawable.tesoura)
        }
    }
}
