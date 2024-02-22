package com.example.secondweek_problems

fun main() {
    println("Hello Welcome")

    print("Please enter the first number: ")
    val num1 = readLine()?.toDoubleOrNull()

    if (num1 == null) {
        println("Error: Please enter a valid number.")
        return
    }

    print("Please enter mathematical operation (+, -, *, /): ")
    val operator = readLine()

    print("Please enter the second number: ")
    val num2 = readLine()?.toDoubleOrNull()

    if (num2 == null) {
        println("Error: Please enter a valid number.")
        return
    }

    val result = when (operator) {
        "+" -> num1 + num2
        "-" -> num1 - num2
        "*" -> num1 * num2
        "/" -> if (num2 != 0.0) num1 / num2 else {
            println("Error: Divide by zero error!")
            return
        }
        else -> {
            println("Error: Invalid operator: $operator")
            return
        }
    }

    println("Sonuç: $result")
}