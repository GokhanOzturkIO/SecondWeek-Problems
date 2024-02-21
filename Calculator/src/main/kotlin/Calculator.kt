package org.example

class Calculator {

    private val supportedOperators = charArrayOf('+', '-', '*', '/', 'x')

    fun runCalculator() {
        printWelcomeMessage()

        while (true) {
            val firstNumber = enterNumber("Please enter first number:")
            val enteredOperator = enterOperator()
            val secondNumber = enterNumber("Please enter second number:")

            val result = calculate(firstNumber, secondNumber, enteredOperator)

            println("Result: $result")

            if (shouldContinue().not()) break
        }
    }

    private fun printWelcomeMessage() {
        println()
        println("======================================================")
        println("Welcome to the Calculator App")
        println("======================================================")
        println()
    }

    private fun enterNumber(message: String): Float {
        while (true) {
            try {
                println(message)
                return readln().toFloat()
            } catch (e: NumberFormatException) {
                printErrorMessage("Error: Please enter a valid number.")
            }
        }
    }

    private fun enterOperator(): Char {
        while (true) {
            println("Choose the operation: (+, -, *, /):")
            val enteredOperator = readln().firstOrNull()
            enteredOperator?.let {
                if (enteredOperator !in supportedOperators) {
                    printErrorMessage("Please choose the right operations")
                } else {
                    return enteredOperator
                }
            } ?: run {
                printErrorMessage("Please choose the right operations")
            }
        }
    }

    private fun calculate(firstNumber: Float, secondNumber: Float, operator: Char): Float {
        return when (operator) {
            '+' -> firstNumber + secondNumber
            '-' -> firstNumber - secondNumber
            '*', 'x' -> firstNumber * secondNumber
            '/' -> {
                if (secondNumber == 0.0f) {
                    printErrorMessage("Division by zero")
                }
                firstNumber / secondNumber
            }

            else -> throw IllegalArgumentException()
        }
    }

    private fun shouldContinue(): Boolean {
        println("Do you want to continue? (Enter 'y' or 'n'): ")
        val result = readlnOrNull()?.trim()?.lowercase() ?: return false
        return when (result) {
            "yes", "y" -> true
            "no", "n" -> false
            else -> throw IllegalArgumentException()
        }
    }

    private fun printErrorMessage(message: String?) {
        println()
        println("== ERROR OCCURRED ==")
        println("Error $message")
        println()
    }
}
