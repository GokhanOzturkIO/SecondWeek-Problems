fun main(){
    user()

    do {
        val firstNumber = try {
            getFirstNumber()
        } catch (e: NumberFormatException) {
            println("Invalid input! Please enter a valid number.")
            continue
        }

        val operation = try {
            getOperation()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            continue
        }

        val secondNumber = try {
            getSecondNumber()
        } catch (e: NumberFormatException) {
            println("Invalid input! Please enter a valid number.")
            continue
        }

        try {
            val result = operation?.let { calculate(firstNumber, it, secondNumber) }
            if (result != null) {
                printResult(result)
            }
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    } while (continueOrQuit())
}

fun user(){
    println("Welcome!")
}

fun getFirstNumber(): Double{
    print("Please enter the first number: ")
    return readLine()!!.toDouble()
}

fun calculate(firstNumber: Double, operation: Char, secondNumber: Double): Double {
    if (operation == '/' && secondNumber == 0.0) {
        throw IllegalArgumentException("Division by zero is not allowed!")
    }
    return when (operation) {
        '+' -> firstNumber + secondNumber
        '-' -> firstNumber - secondNumber
        '*' -> firstNumber * secondNumber
        '/' -> firstNumber / secondNumber
        else -> throw IllegalArgumentException("Invalid operation!")
    }
}

fun getOperation(): Char? {
    print("Select the mathematical operation you want to perform (+, -, *, /): ")
    val operation = readLine()?.trim()?.firstOrNull()
    if (operation !in listOf('+', '-', '*', '/')) {
        throw IllegalArgumentException("Invalid operation! Please select a valid operation (+, -, *, /).")
    }
    return operation
}

fun printResult(result: Double) {
    println("Result: $result")
}

fun getSecondNumber(): Double {
    print("Please enter the second number: ")
    return readLine()!!.toDouble()
}

fun continueOrQuit(): Boolean {
    print("Do you want to continue? (Yes/No): ")
    val response = readLine()!!.toLowerCase()
    return response == "yes" || response == "y"
}