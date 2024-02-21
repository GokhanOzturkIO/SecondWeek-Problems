
fun main() {
    println("Welcome :)")
    while (true) {
        println("Enter First Number:")
        val firstNumber: Float? = readln().toFloatOrNull()
        if (firstNumber == null) {
            println("You entered the wrong value")
            continue
        }
        println("Enter Second Number:")
        val secondNumber = readln().toFloatOrNull()
        if (secondNumber == null) {
            println("You entered the wrong value")
            continue
        }
        println("Enter The Operator:")
        val operator = readln()
        val calculator = Calculator(firstNumber, secondNumber, operator)
        if (secondNumber.toInt() == 0) {
            println("You Can't Do That :/")
        } else {
            calculator.calculate()
            println("Do you want to continue [Y,N]")
            val input = readln()
            if (input == "Y" || input == "y") {
                continue
            } else if (input == "N" || input == "n") {
                break
            } else println("You entered the wrong value")
        }
    }
}

class Calculator(
    private val firstNumber: Float,
    private val secondNumber: Float,
    private val operator: String?
) {
    fun calculate(): Any {
        return when (operator) {
            "+" -> println("Result: ${sum()}")
            "-" -> println("Result: ${minus()}")
            "*" -> println("Result: ${multiply()}")
            "/" -> println("Result: ${divide()}")
            else -> {
                println("You entered the wrong value")
            }
        }
    }

    private fun sum(): Float {
        return firstNumber + secondNumber
    }

    fun minus(): Float {
        return firstNumber - secondNumber
    }

    private fun multiply(): Float {
        return firstNumber * secondNumber
    }

    private fun divide(): Any {
        return firstNumber / secondNumber
    }
}