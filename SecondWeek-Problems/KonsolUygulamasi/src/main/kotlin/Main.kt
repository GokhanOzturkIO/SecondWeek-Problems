package org.example


fun main() {

   println("Welcome!")

   while (true) {

      println("Please enter the first number: ")
      val number1 = readLine()?.toDoubleOrNull()

      if (number1 == null) {
         println("Invalid number!")
         continue
      } else if (number1 < 0  ) {
         println("Negative numbers cannot be entered")
         continue
      }

      print("Please choose an operator (+, -, *, /): ")
      val operatorInput = readLine()?.trim()?.singleOrNull()
      if (operatorInput !in listOf('+', '-', '*', '/')) {
         println("Ups! something is wrong, please enter the invalid operator '+' '-' '*' '/'")
         continue
      }

      val operator = operatorInput.toString()

      print("Please enter the second number: ")
      val number2 = readLine()?.toDoubleOrNull()

      if (number2 == null) {
         println("Invalid number!")
         continue
      }


      val result = when (operator) {
         "+" -> number1 + number2
         "-" -> number1 - number2
         "*" -> number1 * number2
         "/" -> {
            if (number2 == 0.0)  {
               println("It is not possible to divide by zero when dividing!")
               continue
            }
            number1 / number2
         }
          else -> {
             println("Invalid operator!")
             continue
          }

     }

      println("Result: $result")

      print("Do you want to continue? (Y/N): ")
      val answer1 = readLine()

      if (answer1 == "Y" || answer1 == "y") {
         continue
      }
      break

   }
   println("Thank you:), see you soon!")
}