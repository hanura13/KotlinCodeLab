package com.sundev.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceButton: Button = findViewById(R.id.button)
        diceButton.setOnClickListener {
            rollDice()
        }

    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val diceroll = dice1.roll()
        val luckyNumber = 5

        when(diceroll) {
            luckyNumber -> Toast.makeText(this, "Got You", Toast.LENGTH_SHORT).show()
            1 -> Toast.makeText(this, "So sorry! You rolled a 1. Try again!", Toast.LENGTH_SHORT).show()
            2 -> Toast.makeText(this, "Sadly, you rolled a 2. Try again!", Toast.LENGTH_SHORT).show()
            3 -> Toast.makeText(this, "Unfortunately, you rolled a 3. Try again!", Toast.LENGTH_SHORT).show()
            4 -> Toast.makeText(this, "Don't cry! You rolled a 4. Try again!", Toast.LENGTH_SHORT).show()
            6 -> Toast.makeText(this, "Apologies! You rolled a 6. Try again!", Toast.LENGTH_SHORT).show()
        }
    }
}

class Dice(val numSide: Int){
    fun roll(): Int{
        return (1..numSide).random()
    }
}