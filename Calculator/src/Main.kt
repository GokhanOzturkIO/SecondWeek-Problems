fun main() {
    greeting()
    var number1: Double? = null
    var number2: Double? = null
    var operator: String? = null
    var flag: Boolean = true

    do {
        print("Enter the first number : ")
        number1 = getNumber()
        print("Enter the operator (`+`, `-`, `*`, `/` ): ")
        operator = getOperator()
        print("Enter the second number : ")
        number2 = getNumber()
        if (operator != null){
            if (number1 != null && number2 != null){
                val result = when(operator){
                    "+" -> calculate(number1, number2, ::addition)
                    "-" -> calculate(number1, number2, ::subtraction)
                    "*" -> calculate(number1, number2, ::multiplication)
                    "/" -> calculate(number1, number2, ::division)
                    else -> null
                }

                println("$number1 $operator $number2 = $result")
            } else{
                println("Invalid number!")
            }
        } else{
            println("Invalid operator!")
        }
        print("If you want to quit press `q` : ")
        if (readLine()?.equals("q") == true)
            flag = false
    } while (flag)

    println("Thank you for using the KeKod Calculator!")
}

private fun greeting(){
    println("=".repeat(30))
    println("Welcome to KeKod Calculator")
    println("=".repeat(30))
}

private fun getNumber(): Double? = readLine()?.toDoubleOrNull()

private fun getOperator(): String? {
    return when(readLine()){
        "+", "add", "addition", "plus" -> "+"
        "-", "sub", "subtract", "subtraction", "minus" -> "-"
        "*", "x", "X", "multiply", "multiplication", "times" -> "*"
        "/", "divide", "div", "division" -> "/"
        else -> null
    }
}

private fun calculate(number1: Double, number2: Double, operation: (Double, Double) -> Double): Double = operation(number1, number2)
private fun addition(number1: Double, number2: Double): Double = number1.plus(number2)
private fun subtraction(number1: Double, number2: Double): Double = number1.minus(number2)
private fun multiplication(number1: Double, number2: Double): Double = number1.times(number2)
private fun division(number1: Double, number2: Double): Double = number1.div(number2)