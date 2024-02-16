fun main() {
    println("Hello !!!")

    print("Lütfen bir sayı girin: ")
    val number1 = readlnOrNull()

    print("Lütfen matematiksel işlemin karakterini giriniz: ")
    val operator = readlnOrNull()

    print("Lütfen ikinci sayiyi giriniz: ")
    val number2 = readlnOrNull()

    var result: Double = 0.0

    when(operator) {
        "+" -> {
            if (number1 != null && number2 != null) {
                result = number1.toDouble() + number2.toDouble()
                println("Sonuç = $result")
            }else {
                println("Lütfen sayilari eksiksiz giriniz !!!")
            }
        }
        "-" -> {
            if (number1 != null && number2 != null) {
                result = number1.toDouble() - number2.toDouble()
                println("Sonuç = $result")
            }else {
                println("Lütfen sayilari eksiksiz giriniz !!!")
            }
        }
        "/" -> {
            if (number1 != null && number2 != null) {
                result = number1.toDouble() / number2.toDouble()
                println("Sonuç = $result")
            }else {
                println("Lütfen sayilari eksiksiz giriniz !!!")
            }
        }
        "*" -> {
            if (number1 != null && number2 != null) {
                result = number1.toDouble() * number2.toDouble()
                println("Sonuç = $result")
            }else {
                println("Lütfen sayilari eksiksiz giriniz !!!")
            }
        }
        "%" -> {
            if (number1 != null && number2 != null) {
                result = number1.toDouble() % number2.toDouble()
                println("Sonuç = $result")
            }else {
                println("Lütfen sayilari eksiksiz giriniz !!!")
            }
        }
        else -> {
            println("Hatalı operatör girdiniz !!!")
        }
    }
}