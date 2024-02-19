fun main(){
    user()

    do {
        val firstNumber = getFirstNumber()
        val operation = getOperation()
        val secondNumber = getSecondNumber()

        try {
            val result = calculate(firstNumber, operation, secondNumber)
            printResult(result)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }while (continueOrQuit())
}

fun user(){
    println("Welcome!")
}

fun getFirstNumber(): Double{
    print("Please enter the first number: ")
    return readLine()!!.toDouble()
}

fun getOperation(): Char {
    print("Select the mathematical operation you want to perform (+, -, *, /): ")
    return readLine()!!.first()
}

fun getSecondNumber(): Double {
    print("Please enter the second number: ")
    return readLine()!!.toDouble()
}

fun continueOrQuit(): Boolean {
    print("Do you want to continue? (Yes No): ")
    val response = readLine()!!.toLowerCase()
    return response == "evet"
}