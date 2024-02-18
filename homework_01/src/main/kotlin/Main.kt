package org.example


fun main() {
    printHello()
    runCalculator()
}

fun runCalculator() {
    var continueTransaction: Boolean

    do {
        continueTransaction = true
        try {
            val (firstNumber, operator, secondNumber) = getNumberOperation()
            performOperation(operator, firstNumber, secondNumber)

            println("Do you want to continue? (Y or N)")
            when (val answer = readln().uppercase()) {
                "Y" -> continueTransaction = true
                "N" -> continueTransaction = false
                "Yes".uppercase() -> continueTransaction = true
                "No".uppercase() -> continueTransaction = false
                else -> println("$answer Please enter a valid answer.")
            }
        } catch (ex: NumberFormatException) {
            println("You did not enter a numerical expression.")
        }
    } while (continueTransaction)
}

fun getNumberOperation(): Triple<Double, String, Double> {
    print("Enter the First Number: ")
    val firstNumber = readln().toDouble()

    print("Enter the Operation Type (+, -, *, /): ")
    val operation = readln()

    print("Enter the Second Number: ")
    val numberSecond = readln().toDouble()

    return Triple(firstNumber, operation, numberSecond)
}


fun performOperation(operationType: String, firstNumber: Double, secondNumber: Double) {
    val result = when (operationType) {
        "+" -> firstNumber + secondNumber
        "-" -> firstNumber - secondNumber
        "/" -> firstNumber / secondNumber
        "*" -> firstNumber * secondNumber
        else ->  "Invalid Operator Entered"
    }
    println("Result: $result")
}

fun printHello() {
    println("Hello")
}