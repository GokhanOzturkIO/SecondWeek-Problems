fun main() {

    try {
        println("Hello Welcome ")

        do {
            println("Enter the first number:")
            val number1 = readlnOrNull()?.toIntOrNull() ?: throw NumberFormatException("An invalid number was entered")

            println("Enter mathematical operations(+,-,*,/)")
            val mOperations =
                readlnOrNull() ?: throw IllegalArgumentException("No transaction selection has been made.")

            println("Enter the second number:")
            val number2 = readlnOrNull()?.toIntOrNull() ?: throw NumberFormatException("An invalid number was entered")

            val result = when (mOperations) {
                "+" -> number1 + number2
                "-" -> number1 - number2
                "*" -> number1 * number2
                "/" -> {
                    if (number2 == 0) {
                        throw ArithmeticException("Cannot be divided by zero ")
                    }
                    number1 / number2
                }

                else -> throw IllegalArgumentException("Invalid transaction selection was made.")
            }
            println("Result : $result")

            println("Do you want to continue the process? (Yes: 'Y', No: 'N') ")
            val continuation = readlnOrNull()

            if (continuation != "Y") {
                println("Checking out. Goodbye")
                break
            }

        } while (true)

    } catch (e: Exception) {
        println("Something went wrong: ${e.message}")
    }
}