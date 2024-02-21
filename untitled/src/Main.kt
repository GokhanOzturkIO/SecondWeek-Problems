import java.util.*

fun main() {

    var continueCalc: Boolean
    var firstNumber: Double?
    var operator: String?
    var secondNumber: Double?
    var result: Double?

    println("\nHello! This is a math calculation function.")
    do {
        firstNumber = getNumberInput("Enter your first number: ")
        operator = readOperator("Enter your desired math calculation operator (+, -, *, /): ")
        secondNumber = getNumberInput("Enter your second number: ")


        result = calculateResult(firstNumber, operator, secondNumber)
        println("Result: $result")

        println("\nDo you want to try again? (Y/N)")
        continueCalc = readYesOrNo("Enter Y to continue, N to exit: ")

    } while (continueCalc)
}

fun getNumberInput(prompt: String): Double {
    while (true) {
        print(prompt)
        val input = readlnOrNull()
        try {
            return input?.toDouble() ?: throw NumberFormatException("Invalid input")
        } catch (e: NumberFormatException) {
            println("Invalid input, please enter a valid number.")
        }
    }
}

fun readOperator(prompt: String): String {
    while (true) {
        print(prompt)
        val input = readlnOrNull()
        if (input in listOf("+", "-", "*", "/")) {
            return input.toString()
        } else {
            println("Invalid operator, please enter one of the following: +, -, *, /")
        }
    }
}

fun calculateResult(firstNumber: Double, operator: String, secondNumber: Double): Double {
    return when (operator) {
        "*" -> firstNumber * secondNumber
        "/" -> firstNumber / secondNumber
        "+" -> firstNumber + secondNumber
        "-" -> firstNumber - secondNumber
        else -> throw IllegalArgumentException("Invalid operator")
    }
}

fun readYesOrNo(prompt: String): Boolean {
    while (true) {
        print(prompt)
        val input = readlnOrNull()?.trim()?.uppercase(Locale.getDefault())
        when (input) {
            "Y", "YES" -> {
                return true
            }

            "N", "NO" -> {
                return false
            }

            else -> {
                println("Invalid input, please enter Y or N.")
            }
        }
    }

}