fun main() {

    println("Hoş geldiniz")

    do {

        print("Birinci sayıyı girin ")
        val firstNumber = readlnOrNull()?.toDoubleOrNull()


        print("Yapmak istediğiniz matematiksel işlemin karakterini girin ")
        val operator = readlnOrNull()


        print("İkinci sayıyı girin ")
        val secondNumber = readlnOrNull()?.toDoubleOrNull()

        if (firstNumber != null && secondNumber != null) {
            val result = when (operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                "%" -> firstNumber % secondNumber
                else -> {
                    println("Hatalı Operatör")
                    return
                }
            }

            println("Sonuç: $result")
        } else {
            println("Hatalı giriş")
        }

        print("Devam etmek istiyor musunuz? (E/H)")
        val answer = readlnOrNull()?.uppercase()

    } while (answer == "E")

    println("Program sonlandırıldı")
}
