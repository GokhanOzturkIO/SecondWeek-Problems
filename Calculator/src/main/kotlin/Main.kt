fun main() {

    println("Calculator'a Hoş geldiniz! 🥳")

    start()
}

fun start() {

    print("Lütfen ilk sayıyı girin: ")
    val firstNumber = readlnOrNull()

    print("Lütfen yapmak istediğiniz matematiksel işlemin karakterini girin: ")
    val operator = readlnOrNull()

    print("Lütfen ikinci sayıyı girin: ")
    val secondNumber = readlnOrNull()

    firstNumber?.toDoubleOrNull()?.let { n1 ->
        secondNumber?.toDoubleOrNull()?.let { n2 ->
            val result = when (operator) {
                "+" -> addition(n1, n2)
                "-" -> subtraction(n1, n2)
                "*" -> multiplication(n1, n2)
                "/" -> division(n1, n2)
                "%" -> remainder(n1, n2)
                else -> "Hatalı Operatör!"
            }

            println("Sonuç: $result")
        }
    }

    print("Devam etmek ister misiniz? (E/H): ")
    val answer = readlnOrNull()

    if (answer?.uppercase() == "E") start()
}

fun addition(firstNumber: Double, secondNumber: Double): Double = (firstNumber + secondNumber)

fun subtraction(firstNumber: Double, secondNumber: Double): Double = (firstNumber - secondNumber)

fun multiplication(firstNumber: Double, secondNumber: Double): Double = (firstNumber * secondNumber)

fun division(firstNumber: Double, secondNumber: Double): Double = (firstNumber / secondNumber)

fun remainder(firstNumber: Double, secondNumber: Double): Double = (firstNumber % secondNumber)