package fr.caro

import java.util.*

/**
 * Created by caroline on 02/09/17.
 */

fun main(args: Array<String>) {
    val min = 0
    val max = 100
    var nbAttempts = 0
    val random = SplittableRandom()
    val reader = Scanner(System.`in`)
    val goal = random.nextInt(min, max)
    var userGuess: Int

    computerSays("I chose a number between $min and $max")
    do {
        nbAttempts++
        computerSays("What's your guess?")
        userGuess = reader.nextInt()
        if (userGuess > goal) computerSays("less !")
        else if (userGuess < goal) computerSays("more !")
    } while(userGuess != goal)

    computerSays("Congratulation ! You found in $nbAttempts attemps.")
}

fun computerSays(text: String) {
    println("Computer : " + text)
}
