fun main() {
    println("Welcome!")
    startCalculator()
}

fun startCalculator() {
    val numbOne = getNumberFromUser(text = "Please enter the first number")
    val numbTwo = getNumberFromUser(text = "Please enter the second number")
    val operator = getOperator()
    val result = calculateResult(numberOne = numbOne, numberTwo = numbTwo, operator = operator)
    println("Result : $result")
    askUserForContinuation()
}

fun askUserForContinuation() {
    println("Do you want to continue? [y: Yes, n: No]")
    val userAnswer = readLine()!!
    when (userAnswer) {
        "y" -> startCalculator()
        "n" -> println("Calculator is closed! Thank you")
        else -> {
            println("Please enter the valid answer")
            askUserForContinuation()
        }
    }

}

fun getNumberFromUser(text: String): Number {
    while (true) {
        try {
            println(text)
            val number = readLine()!!
            return when {
                number.contains(".") -> number.toDouble()
                else -> number.toInt()
            }
        } catch (e: NumberFormatException) {
            println("Please enter a valid number!")
        }
    }
}

fun getOperator(): String {
    println("Please select the operator!")
    while (true) {
        val operator = readLine()!!
        if (operator in listOf("+", "-", "*", "/")) {
            return operator
        } else {
            println("Please enter a valid mathematical operator!")
        }
    }
}

fun calculateResult(numberOne: Number, numberTwo: Number, operator: String): Number {
    val result = when (operator) {
        "+" -> sumNumbers(numberOne = numberOne, numberTwo = numberTwo)
        "-" -> subtractNumbers(numberOne = numberOne, numberTwo = numberTwo)
        "*" -> multiplyNumbers(numberOne = numberOne, numberTwo = numberTwo)
        else -> divideNumbers(numberOne = numberOne, numberTwo = numberTwo)
    }
    return result
}

fun sumNumbers(numberOne: Number, numberTwo: Number): Number {
    return when {
        numberOne is Int || numberTwo is Int -> numberOne.toInt() + numberTwo.toInt()
        numberOne is Double || numberTwo is Double -> numberOne.toDouble() + numberTwo.toDouble()
        else -> numberOne.toLong() + numberTwo.toLong()
    }
}

fun subtractNumbers(numberOne: Number, numberTwo: Number): Number {
    return when {
        numberOne is Int || numberTwo is Int -> numberOne.toInt() - numberTwo.toInt()
        numberOne is Double || numberTwo is Double -> numberOne.toDouble() - numberTwo.toDouble()
        else -> numberOne.toLong() - numberTwo.toLong()
    }
}

fun multiplyNumbers(numberOne: Number, numberTwo: Number): Number {
    return when {
        numberOne is Int || numberTwo is Int -> numberOne.toInt() * numberTwo.toInt()
        numberOne is Double || numberTwo is Double -> numberOne.toDouble() * numberTwo.toDouble()
        else -> numberOne.toLong() * numberTwo.toLong()
    }
}

fun divideNumbers(numberOne: Number, numberTwo: Number): Number {
    return when {
        numberOne is Int || numberTwo is Int -> numberOne.toInt() / numberTwo.toInt()
        numberOne is Double || numberTwo is Double -> numberOne.toDouble() / numberTwo.toDouble()
        else -> numberOne.toLong() / numberTwo.toLong()
    }
}