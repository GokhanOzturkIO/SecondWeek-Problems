fun main() {

    println("----Selamlarr Hoşgeldiniz :)----")

    var continueOrNot = true

    while (continueOrNot) {
        val (number1, number2) = takeTwoNumbers()
        val operation = getOperation()
        val result = calculateResult(number1, number2, operation)
        println("Sonuç:$result")

        println("Devam etmek istiyor musunuz ? (Evet için 'e',Hayır için 'h' basabilirsiniz.")
        val userInput = readLine()?.lowercase()

        if (userInput == "e") {
            println("Devam ediliyor.")
        } else if (userInput == "h") {
            println("İşlem sonlanıyor.")
            continueOrNot = false

        } else {
            println("Geçersiz işlem lütfen 'e' veya 'h' harflerinden birisini giriniz!")
        }


    }


}

fun takeTwoNumbers(): Pair<Double, Double> {
    var number1: Double? = null
    var number2: Double? = null

    while (number1 == null) {
        println("Lütfen 1. sayıyı giriniz:")
        number1 = readLine()?.toDoubleOrNull()
        if (number1 == null) {
            println("Geçersiz giriş. Lütfen bir sayı girin.")
        }
    }

    while (number2 == null) {
        println("Lütfen 2. sayıyı giriniz:")
        number2 = readLine()?.toDoubleOrNull()
        if (number2 == null) {
            println("Geçersiz giriş. Lütfen bir sayı girin.")
        }
    }

    return Pair(number1, number2)
}


fun getOperation(): Char {
    while (true) {
        print("Yapmak istediğiniz işlemi seçin (+, -, *, /): ")
        val input = readlnOrNull()
        if (input != null && input.length == 1 && input[0] in "+,-,*,/,%") {
            return input[0]
        } else {
            println("Geçersiz işlem! Lütfen geçerli bir işlem seçin.")
        }
    }
}


fun calculateResult(num1: Double, num2: Double, operation: Char): Double {
    return when (operation) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> num1 / num2
        '%' -> num1 % num2
        else -> throw IllegalArgumentException("Geçersiz işlem yaptınız: $operation")
    }

}




