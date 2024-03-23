/*
Ferec Hamitbeyli
18.03.2024
 */

fun main() {
    println("-----------------------------------------\n GREETINGS \n-----------------------------------------")
    runTheCalculator()
}

fun getTheFirstNumber(): Double {
    println("Please enter the first number: ")
    val firstNumberAsString = readlnOrNull()
    val isFirstNumberDigit = firstNumberAsString?.all { it.isDigit() }
    if (isFirstNumberDigit == false) {
        println("Please enter a valid number.")
        return getTheFirstNumber()
    } else {
        return firstNumberAsString?.toDouble() ?: getTheFirstNumber()
    }
}

fun getTheOperator(): String {
    println("Please enter the operation type (+, -, * or /): ")
    val operatorAsString = readlnOrNull()
    val isOperatorValid = when(operatorAsString) {
        "+" -> true
        "-" -> true
        "*" -> true
        "/" -> true
        else -> false
    }
    if (!isOperatorValid) {
        println("Please enter a valid operator.")
        return getTheOperator()
    } else {
        return operatorAsString ?: getTheOperator()
    }
}

fun getTheSecondNumber(): Double {
    println("Please enter the second number: ")
    val secondNumberAsString = readlnOrNull()
    val isSecondNumberDigit = secondNumberAsString?.all { it.isDigit() }
    if (isSecondNumberDigit == false) {
        println("Please enter a valid number.")
        return getTheSecondNumber()
    } else {
        return secondNumberAsString?.toDouble() ?: getTheSecondNumber()
    }
}

fun performTheCalculation(firstNumber: Double, operator: String, secondNumber: Double) {
    var result = Double.MIN_VALUE
    when(operator) {
        "+" -> result = firstNumber + secondNumber
        "-" -> result = firstNumber - secondNumber
        "*" -> result = firstNumber * secondNumber
        "/" -> {
            if (secondNumber != 0.toDouble()) {
                result = firstNumber / secondNumber
            } else {
                println("You can not divide a number with zero. Please try again!")
                performTheCalculation(getTheFirstNumber(), getTheOperator(), getTheSecondNumber())
            }

        }
    }
    println("The result is $result")
}

fun askToContinue(): Boolean {
    println("Do you want to make another calculation? Please enter y or n.")
    val decision = readlnOrNull()?.lowercase()
    return when(decision) {
        "y" -> true
        "n" -> false
        else -> {
            println("Please enter a valid answer!")
            askToContinue()
        }
    }
}


fun runTheCalculator() {
    var shouldContinue = true

    while (shouldContinue) {
        performTheCalculation(getTheFirstNumber(), getTheOperator(), getTheSecondNumber())

        if (askToContinue()) {
            shouldContinue = true
        } else {
            shouldContinue = false
            println("-----------------------------------------\n THANKS FOR CHOOSING US! \n-----------------------------------------")
        }
    }

}