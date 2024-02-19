fun main() {

    println("Hoş geldiniz")
    calculate()
}

fun calculate() {
    print("birinci sayıyı girin: ")
    val firstNumber: String? = readlnOrNull()


    print("yapmak istediğiniz matematiksel işlemin karakterini girin: ")
    val operator = readlnOrNull()

    print("ikinci sayıyı girin: ")
    val secondNumber:String? = readlnOrNull()

    firstNumber?.toDoubleOrNull()?.let { n1 ->
        secondNumber?.toDoubleOrNull()?.let { n2 ->
            val result = when (operator) {
                "+" -> (n1 + n2)
                "-" -> (n1 - n2)
                "*" -> (n1 * n2)
                "/" -> (n1 / n2)
                "%" -> (n1 % n2)
                else -> "Hatalı Operatör!"
            }

            println("Sonuç: $result")
        }
    }

    print("Devam etmek ister misiniz? (E/H): ")
    val answer = readlnOrNull()

    if (answer?.uppercase() == "E") calculate()
}
