fun main() {
    do {
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

        print("Devam etmek istiyor musunuz? (Evet(1) / Hayır(0)): ")
        val continueInput: String? = readlnOrNull()

        if(continueInput != null) {
            if (continueInput == "0") {
                println("Program sonlandırılıyor...")
                break // Döngüden çık
            }else if(continueInput != "0" || continueInput != "1") {
                println("Lütfen doğru bir değer giriniz !!!")
                continue
            }
        }


    } while (true)
}