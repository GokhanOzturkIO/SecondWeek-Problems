package org.example

fun main() {
    println("Hello Welcome!")
    startCalculator()
}

fun startCalculator() {
    println("Enter first number:")
    val firstNumber = readln()

    if (!firstNumber.isNumeric()) {
        println("First number value can't be empty or include any text character")
        startCalculator()
    }
    val localMathOpList = listOf("+", "-", "*", "/")
    println("Enter what math calculation operation want to use(allows: +,-,*,/ )")
    val mathOperation = readln()

    if (!localMathOpList.contains(mathOperation)) {
        println("Your math operation not supported or you write wrong type, which program not allow")
        startCalculator()
    }

    println("Enter second number of calculation")
    val secondNumber = readln()

    if (!secondNumber.isNumeric()) {
        println("Second number value can't be empty or include any text character")
        startCalculator()
    }

    val result = when (mathOperation) {
        "+" -> firstNumber.toInt().plus(secondNumber.toInt())
        "-" -> firstNumber.toInt().minus(secondNumber.toInt())
        "*" -> firstNumber.toInt().times(secondNumber.toInt())
        else -> {
            firstNumber.toInt().div(secondNumber.toInt())
        }
    }

    println("Result is: $result")
    checkContinuityOrFinish()
}

fun checkContinuityOrFinish() {
    println("Do you wanna continue (e: for yes n: for no)")
    val userAnswer = readln()
    when (userAnswer) {
        "e" -> startCalculator()
        "n" -> {
            println("Calculator closed")
        }
        else -> {
            println("You didn't write acceptable format")
            checkContinuityOrFinish()
        }
    }
}

fun String.isNumeric(): Boolean {
    return this.all { perChar ->
        perChar.isDigit()
    }
}