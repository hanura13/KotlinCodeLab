package com.sundev.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

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
        val textDice1: TextView = findViewById(R.id.textView)
        textDice1.text = diceroll.toString()

        val dice2 = Dice(6)
        val diceroll2 = dice2.roll()
        val textDice2: TextView = findViewById(R.id.textView2)
        textDice2.text = diceroll2.toString()
    }
}

class Dice(val numSide: Int){
    fun roll(): Int{
        return (1..numSide).random()
    }
}