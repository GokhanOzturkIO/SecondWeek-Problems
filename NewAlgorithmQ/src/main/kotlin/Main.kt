package org.example

import java.util.*

fun main() {
    println("Hi")
    var operator: String

    do {
        firstInfo()
        operator = readln().trim()

        if (selectOperator(operator)) {
            try {
                println("Please enter the first number")
                val number1 = readln().toDouble()
                println("Please enter the second number")
                val number2 = readln().toDouble()
                println(calculate(number1, number2, operator))
            } catch (e: Exception) {
                println("Something went wrong")
            }
        }

        print("Do you want to continue (Y/N): ")
    } while (readln().trim().uppercase(Locale.getDefault()) == "Y")

    println("Bye")
}

fun firstInfo() {
    println("what mathematical operation will you do. Please enter ")
    println("For addition: + \nFor subtraction: - \nFor division: / \nFor multiplication: *")
}

fun selectOperator(operator: String): Boolean {
    return when (operator) {
        "+", "-", "*", "/" -> true
        else -> {
            println("Please enter a valid operator (+, -, *, /)")
            false
        }
    }
}

fun calculate(number1: Double?, number2: Double?, operator: String?): String {
    if (number1 == null || number2 == null || operator == null) {
        return "One, both or operator of the numbers is empty"
    }

    return try {
        when (operator) {
            "+" -> (number1 + number2).toString()
            "-" -> (number1 - number2).toString()
            "*" -> (number1 * number2).toString()
            "/" -> {
                if (number2 != 0.0) {
                    (number1 / number2).toString()
                } else {
                    "The second number for division must not be zero"
                }
            }
            else -> "Wrong choice, Please choose one of (+, -, *, /)"
        }
    } catch (e: Exception) {
        "Something went wrong"
    }
}





