fun main() {
    val greetingMessage = "\nHello darling. Now we gonna do some basic arithmetics and u gonna love it.\nYou gonna give me 2 numbers and specify which operator you wanna use.\nNow...\n"

    do {
        print(greetingMessage)
        try {
            print("Gimme the first number: ")
            val num1 = readLine()?.toDouble() ?: throw IllegalArgumentException("Enter a valid number...")

            print("Now, the operand you wanna use (+, -, *, /): ")
            val operation = readLine()

            print("and the second number?: ")
            val num2 = readLine()?.toDouble() ?: throw IllegalArgumentException("Enter a valid number...")

            val result = when (operation) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 == 0.0) throw ArithmeticException("You cant divide a number by zero???") else num1 / num2
                else -> throw IllegalArgumentException("Great operand you gave me back there bro...")
            }

            println("Result: $result")
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }

        print("Wanna try again (Type 'Y' for 'yes', 'N' for 'Nope':")
        val answer = readLine()
    } while (answer?.toLowerCase() == "y")
    print("\n:DD\n")
}
