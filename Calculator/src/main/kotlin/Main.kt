package org.example

/**
 * Exceptionlar ayrı olarak daha sonra değerlendirilip program güncellenecektir!
 */

fun main() {
    sayHello()
    val (number1, number2) = getTwoNumbers()
    val operator = getOperator()
    println(calculate(number1, number2, operator))
}

fun sayHello() {
    println("Welcome to the best calculator in the world :D")
}

fun getTwoNumbers(): Pair<Double, Double> {
    while (true) {
        try {
            print("Enter first number: ")
            val number1 = readln()
            print("Enter second number: ")
            val number2 = readln()
            if (number1.toDoubleOrNull() == null || number2.toDoubleOrNull() == null) {
                throw ArithmeticException()
            } else {
                return Pair(number1.toDouble(), number2.toDouble())
            }

        } catch (e: ArithmeticException) {
            println("Sayı karakterlerini lütfen mantıklı sınırlar içinde giriniz!")
        }
    }
}

fun getOperator(): String {
    while (true) {
        print("Choose an operator -> +, -, /, *: ")
        val operator = readln()
        if (operator == "+" || operator == "-" || operator == "/" || operator == "*") {
            return operator
        } else {
            println("Belirtilen operatörlerden birini giriniz!")
        }
    }
}

fun calculate(number1: Double, number2: Double, operator: String): String {
    return when (operator) {
        "+" -> {
            "Sonuç: ${number1 + number2}"
        }

        "-" -> {
            "Sonuç: ${number1 - number2}"
        }

        "/" -> {
            if (number2.toInt() == 0) {
                return "Geçersiz İşlem! Bir sayı sıfıra bölünemez."
            }
            "Sonuç: ${number1 / number2}"
        }

        "*" -> {
            "Sonuç: ${number1 * number2}"
        }

        else -> "Sonuç: Geçersiz!"
    }
}