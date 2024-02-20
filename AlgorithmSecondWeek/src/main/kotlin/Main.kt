package org.example

fun main() {
    var isOver = false
    greetingMessage()
    while (!isOver) {
        val firstNumber = inputNumber(1)
        val operation = inputMathOperation()
        val secondNumber = inputNumber(2)
        val result = calculateMathOperation(firstNumber, secondNumber, operation)
        println("result: $result")
        isOver = !continueOrNot()
    }
    println("Goodbye :(")
}

fun continueOrNot(): Boolean {
    while (true) {
        println("Would you like to continue with the program? (Y/N):")
        val answer = readln().lowercase()
        val optionalAnswers = arrayOf("y", "n", "yes", "no")

        if (answer in optionalAnswers && (answer == "y" || answer == "yes")) {
            return true
        } else if (answer in optionalAnswers && (answer == "n" || answer == "no")) {
            return false
        } else {
            println("Error: Please enter a valid answer.")
        }
    }
}

fun calculateMathOperation(number1: Float, number2: Float, operation: String): Float {
    var result: Float = 0f
    when (operation) {
        "+" -> result = number1 + number2
        "-" -> result = number1 - number2
        "*" -> result = number1 * number2
        "x" -> result = number1 * number2
        "/" -> result = number1 / number2
    }
    return result
}

fun greetingMessage() {
    println("Welcome to the Simple Calculator App!")
}

fun inputNumber(numberPosition: Int): Float {
    while (true) {
        try {
            print("Input $numberPosition. number: ")
            return readln().toFloat()
        } catch (e: Exception) {
            println("Error: Please enter a valid number. Error detail: $e")
        }
    }
}

fun inputMathOperation(): String {
    while (true) {
        print("(+, -, *, /) Input math operation: ")
        val operation = readln().lowercase()
        val operations = arrayOf("+", "-", "/", "*", "x")
        if (operation in operations) {
            return operation
        } else {
            println("Error: Please enter a valid operation (+, -, *, /)")
        }
    }
}
