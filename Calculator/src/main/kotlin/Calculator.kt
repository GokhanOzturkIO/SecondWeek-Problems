package org.example

class Calculator {
    private val operators = charArrayOf('+', '-', '*', '/', '\\', 'x', 'X')

    fun start() {
        printGreeting()
        while (true) {
            val firstNumber = getNumber("First Number: ")
            val operator = getOperator()
            val secondNumber = getNumber("Second Number: ")
            val result = makeOperation(firstNumber, secondNumber, operator)
            println("$firstNumber $operator $secondNumber = $result")
            if (!continueToRun()) break
        }
    }

    private fun printGreeting() {
        val greetingMessage = "Calculator App".padStart(19, ' ')
        val lines = "+-*/".repeat(6)
        println("/$lines\n$greetingMessage\n/$lines")
    }

    private fun getNumber(message: String): Int {
        while (true) {
            print(message)
            try {
                return readln().trim().toInt()
            } catch (e: Exception) {
                println("Error: Please enter a valid number.")
            }
        }
    }

    private fun getOperator(): Char {
        while (true) {
            print("Choose an operation(+,-,*,/): ")
            try {
                val userInput = readln().trim().first()
                if (userInput in operators) {
                    return userInput
                } else {
                    println("Error: Please choose a valid operator.")
                }
            } catch (e: Exception) {
                println("Error: Please choose a valid operator.")
            }
        }
    }

    private fun makeOperation(firstNumber: Int, secondNumber: Int, operator: Char): Comparable<*> {
        return when (operator) {
            '+' -> firstNumber + secondNumber
            '-' -> firstNumber - secondNumber
            'x', 'X', '*' -> firstNumber * secondNumber
            '/', '\\' -> {
                if (secondNumber == 0) {
                    "Error: Division by zero"
                } else {
                    firstNumber / secondNumber
                }
            }
            else -> "Error: Unexpected result"
        }
    }

    private fun continueToRun(): Boolean {
        while (true) {
            print("Would you like to continue? (\"y\" or \"n\"): ")
            val response = readln().trim().lowercase()
            return when (response) {
                "y", "yes" -> true
                "n", "no" -> false
                else -> {
                    println("Error: Please Enter a valid response.")
                    continue
                }
            }
        }
    }

}