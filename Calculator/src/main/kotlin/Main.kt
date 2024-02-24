package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {


    printWelcomeMessage()
    var bool = true

    while (bool) {


        val first = inputNumber("First")
        val operator = inputOperator()
        val second = inputNumber("Second")
        println(calculate(first,second,operator))



    }


}


private fun printWelcomeMessage() {
    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")
    println("Welcome to console calculator applicaion")
    println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")

}


private fun inputNumber(message: String): Float {
    while (true) {
        try {
            println("Enter $message number:")
            return readln().toFloat()
        } catch (e: NumberFormatException) {
            println("Please enter a valid number type.")
        }

    }
}


private fun inputOperator() :Char {
    val operatorList = charArrayOf('-', '+', '*', '/')
while(true) {
    println("+, -, *, / you can use this operators. Which one do you want to use")
    val operator = readln().firstOrNull()


        if (operator==null || operator !in operatorList) {
            println("Please choose the available operator ")
        } else {
            return operator
        }

}

}

private fun calculate(first : Float,second: Float, operator : Char):Float{
   return when(operator){
       '+' -> first + second
       '-' -> first - second
       '*', 'x' -> first * second
       '/' -> {
           if (second == 0.0f) {
               println("Division by zero is undefined")
           }
           first / second
       }

       else -> throw Exception()
    }
}




