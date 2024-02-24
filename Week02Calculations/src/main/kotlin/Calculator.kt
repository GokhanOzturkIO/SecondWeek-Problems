class Calculator {

    private var number1: Double = 0.0
    private var number2: Double = 0.0
    private var mathOperator: String = ""

    fun runCalculator() {
        greetUser()
        getFirstNumber()
        getMathOperator()
        getSecondNumber()
        makeCalculation()
    }

    private fun greetUser() {
        println("Welcome to Calculator")
    }

    private fun getFirstNumber() {
        println("Enter first number: ")
        try {
            number1 = readln().toDouble()
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getMathOperator() {
        println("Enter mathematical operator: ")
        try {
            mathOperator = readln()
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getSecondNumber() {
        println("Enter second number: ")
        try {
            number2 = readln().toDouble()
        } catch (e: Exception) {
            throw e
        }

    }

    private fun makeCalculation() {
        when(mathOperator) {
            "+" -> showResult(addTwoNumbers(number1, number2))
            "-" -> showResult(subtractTwoNumbers(number1, number2))
            "*" -> showResult(multiplyTwoNumbers(number1, number2))
            "/" -> showResult(divideTwoNumbers(number1, number2))
            else -> {
                println("No result, use a valid operator next time")
            }
        }
    }

    private fun showResult(result: Double) {
        println("Result: $result")
    }

    private fun addTwoNumbers(n1: Double, n2: Double): Double {
        try {
            return n1 + n2
        } catch (e: Exception) {
            throw e
        }
    }

    private fun subtractTwoNumbers(n1: Double, n2: Double): Double {
        try {
            return n1 - n2
        } catch (e: Exception) {
            throw e
        }
    }

    private fun multiplyTwoNumbers(n1: Double, n2: Double): Double {
        try {
            return n1 * n2
        } catch (e: Exception) {
            throw e
        }
    }

    private fun divideTwoNumbers(n1: Double, n2: Double): Double {
        try {
            return n1 / n2
        } catch (e: Exception) {
            throw e
        }
    }
}