fun main() {
    println("Hello, Welcome")
    startUserInteraction()
}

fun startUserInteraction() {
    println("please enter the first number")
    val firstNumber = readln()

    if (!firstNumber.isNumeric()) {
        println("something wrong i can feel it.")
        startUserInteraction()
    }

    println("Specify the mathematical operation you want to perform (+, -, *, /):")
    val operation = readln()

    println("please enter the second number")
    val secondNumber = readln()

    if (!secondNumber.isNumeric()) {
        println("something wrong i can feel it.")
        startUserInteraction()
    }
    val firstNumberInDouble = firstNumber.toDouble()
    val secondNumberInDouble = secondNumber.toDouble()

    val calculateResult = when (operation) {
        "+" -> firstNumberInDouble + secondNumberInDouble
        "-" -> firstNumberInDouble - secondNumberInDouble
        "*" -> firstNumberInDouble * secondNumberInDouble
        "/" -> firstNumberInDouble / secondNumberInDouble
        else -> "You entered the wrong operator."
    }

    println(calculateResult)
    askForRetry()
}

fun askForRetry() {
    println("continue or ok? (Y/N)")
    when (val answer = readln().uppercase()) {
        "Y" -> {
            startUserInteraction()
        }

        "N" -> {
            println("Goodbye")
        }

        else -> {
            println("$answer input is invalid, check your answer")
            askForRetry()
        }
    }
}

fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}