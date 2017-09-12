package fr.caro

import java.util.*

/**
 * Created by caroline on 02/09/17.
 */

fun main(args: Array<String>) {

    val goal = chooseANumber()
    var nbAttempts = 0
    do {
        nbAttempts++
        "What's your guess?".outputAsComputer()
    } while(tryingToGuess(goal) != goal)

    "Congratulation ! You found in $nbAttempts attemps.".outputAsComputer()
}

fun chooseANumber(min: Int = 0, max: Int = 100): Int {
    val random = SplittableRandom()
    val goal = random.nextInt(min, max)
    "I chose a number between $min and $max".outputAsComputer()
    return goal
}

fun tryingToGuess(goal: Int) : Int {
    val reader = Scanner(System.`in`)
    val userGuess = reader.nextInt()
    when {
        userGuess > goal -> "less !".outputAsComputer()
        userGuess < goal -> "more !".outputAsComputer()
    }
    return userGuess
}

fun String.outputAsComputer() {
    println("Computer : " + this)
}