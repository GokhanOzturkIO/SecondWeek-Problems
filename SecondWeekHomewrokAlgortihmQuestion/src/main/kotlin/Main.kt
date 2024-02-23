
fun main(args: Array<String>) {
    println("Greetings!")
    var yesOrNo = true
    while (yesOrNo) {
        val number1 = gettingFirstNumber()
        val operator = gettingOperator()
        val number2 = gettingSecondNumber()
        val result = calculating(number1, operator, number2)
        println("Result: $result")
        yesOrNo = willYouContinue()
    }
}
fun gettingFirstNumber(): Double {  //to get first number
    println("Enter the first number")
    return readLine()?.toDoubleOrNull() ?: gettingFirstNumber()
}

fun gettingOperator(): String { //to get operator
    println("Enter the operator you want to perform  (+ - * /)")
    val operator = readln()
    if (!isValidOperator(operator)) {
        println("Invalid operator, try again")
        gettingOperator()
    }
    return operator
}

fun gettingSecondNumber(): Double { //to get second number
    println("Enter the second number")
    return readLine()?.toDoubleOrNull() ?: gettingSecondNumber()
}

fun isValidOperator(operator: String): Boolean { // to check whether is a valid operator or not
    return operator.length == 1 && (operator.contains("+") || operator.contains("-") || operator.contains("*") || operator.contains(
        "/"
    ))
}

fun calculating(number1: Double, operator: String, number2: Double): Double {  //to calculate the result
    return when (operator) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> if (number2 != 0.0) number1 / number2 else {
            println("Division by zero error.")
            0.0
        }

        else -> {
            println("Invalid operator: $operator")
            0.0
        }
    }
}

fun willYouContinue(): Boolean {  //to check whether it will continue or not
    var yesOrNo = true;
    var validInput = false
    while (!validInput) {
        println("Do you want to continue? (Y/N)")
        when (readln().uppercase()) {
            "N" -> {
                yesOrNo = false
                validInput = true
                println("Okay, goodbye!")
            }
            "Y" -> {
                yesOrNo = true
                validInput = true
            }
            else -> {
                println("Invalid input. Please enter 'Y' or 'N'.")
            }
        }
    }
    return yesOrNo
}
