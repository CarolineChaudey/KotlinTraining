package fr.caro

import java.util.*
import kotlin.system.exitProcess

/**
 * author : Caroline Chaudey
 * created : 02/09/2017
 * modified : 03/10/2017
 */

fun main(args: Array<String>) {

    val pair = getMinMax(args)
    val goal = if (pair == null) randomNumberPicker()
               else randomNumberPicker(pair.first, pair.second)

    var nbAttempts = 0
    do {
        nbAttempts++
        "What's your guess?".outputAsComputer()
    } while(tryingToGuess(goal) != goal)

    "Congratulation ! You found in $nbAttempts attemps.".outputAsComputer()
}

fun randomNumberPicker(min: Int = 0, max: Int = 100): Int {
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

fun getMinMax(args: Array<String>) : Pair<Int, Int>? {
    when {
        args.isEmpty() -> return null
        args.size == 1 -> closeApp("You must provide the minimum AND maximum value. Or nothing. Not just one argument.")
    }
    try {
        val min = args[0].toInt()
        val max = args[1].toInt()
        if (min >= max) closeApp("The max value must be above the minimum value.")
        return Pair(min, max)
    } catch (e: NumberFormatException) {
        closeApp("The first 2 arguments must be integers.")
    }
    return null
}

fun closeApp(message: String = "Error. Closing the app.") {
    println(message)
    exitProcess(0)
}

fun String.outputAsComputer() {
    println("Computer : " + this)
}