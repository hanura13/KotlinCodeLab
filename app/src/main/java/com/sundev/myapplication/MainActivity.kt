package com.sundev.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val diceButton: Button = findViewById(R.id.button)
        diceButton.setOnClickListener {rollDice()}

        rollDice()

    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll the dice
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val dice2 = Dice(6)
        val diceRoll2 = dice2.roll()


        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        val dice2Image: ImageView = findViewById(R.id.imageView2)


        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {R.drawable.dice_1}
        }
        val drawableResource2 = when (diceRoll2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> {R.drawable.dice_1}
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)
        dice2Image.setImageResource(drawableResource2)


        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
        dice2Image.contentDescription = diceRoll2.toString()

    }
}

class Dice(val numSide: Int){
    fun roll(): Int{
        return (1..numSide).random()
    }
}