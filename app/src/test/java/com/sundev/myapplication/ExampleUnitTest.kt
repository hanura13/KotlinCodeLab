package com.sundev.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun generateNumber(){
        val dice = Dice(6)
        val rollDice = dice.roll()
        assertTrue("The value of rollResult was not between 1 and 6", rollDice in 1..6)
    }
}