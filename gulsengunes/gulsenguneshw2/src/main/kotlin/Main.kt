package org.example

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    process()
}

fun process() {
    println("Welcome")
    println("Please enter a number..")
    var firstnumber: Int? = readln().toIntOrNull()
    println("Please enter the action you want to make +,-,/,*,% gb.")
    var sembol: String? = readln()
    println("Please enter the second number..")
    var secondnumber: Int? = readln().toIntOrNull()


    if (firstnumber != null && secondnumber != null) {
        when (sembol) {
            "+" -> println("Result of transaction:${firstnumber + secondnumber}")
            "-" -> println("Result of transaction:${firstnumber - secondnumber}")
            "/" -> if (firstnumber != 0 && secondnumber != 0) {
                println("Result of transaction:${firstnumber / secondnumber}")
            } else {
                println("Error of knowing zero")
            }

            "*" -> println("Result of transaction:${firstnumber * secondnumber}")
            "%" -> println("Result of transaction:${firstnumber % secondnumber}")
            else -> println("You entered an invalid transaction,please use  +,-,/,*,% emoticons..")
        }
    } else {
        println("Please make sure you enter a number..")
    }
    println("Do you want continue to make a new transaction? Enter Y or N")

    val tocontinue: String = readln()

    if (tocontinue != null) {
        when (tocontinue) {
            "y" -> process()
            "n" -> println("Bye-Bye!")
            else -> println("Make sure you enter valid letters.Enter Y or N")
        }

    }
}


