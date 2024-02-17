fun main() {

    var result: Double
    var userChoice: String

    do {
        println("Hello !!!")

        print("Lütfen bir sayı girin: ")
        val number1 = readlnOrNull()

        print("Lütfen matematiksel işlemin karakterini giriniz('+' ,'-', '*', '/', '%'): ")
        val operator = readlnOrNull()

        print("Lütfen ikinci sayiyi giriniz: ")
        val number2 = readlnOrNull()

        if(!number1.isNullOrBlank() && !number2.isNullOrBlank() && !operator.isNullOrBlank()) {
            result = operations(number1.toDouble(), number2.toDouble(), operator)
            if(result != -1.0) {
                println("Result -> $result")
            }
        }else {
            println("Hatalı giriş yaptınız !!!")
        }

        userChoice = getUserChoice()
        if (userChoice == "0") {
            break
        }

    } while (true)
}


fun operations(number1: Double, number2: Double, operation: String): Double {

    var result = 0.0

    result = when(operation) {
        "+" -> {
            number1 + number2
        }
        "-" -> {
            number1 - number2
        }
        "/" -> {
            number1 / number2
        }
        "*" -> {
            number1 * number2
        }
        "%" -> {
            number1 % number2
        }
        else -> {
            println("Hatalı giriş yaptınız !!!")
            -1.0
        }
    }

    return result
}

fun getUserChoice(): String {
    println("Devam etmek istiyor musunuz? İstemiyorsanız lütfen 0'a basınız ?")
    return readlnOrNull().toString()
}