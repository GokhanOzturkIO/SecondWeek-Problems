import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var continueCalculation = true
    println("Merhaba, hoş geldiniz!")

    while (continueCalculation) {
        try {
            println("Lütfen ilk sayıyı girin:")
            val num1 = readNumber(scanner)

            println("Lütfen yapmak istediğiniz işlemi girin (+, -, *, /):")
            val operator = readOperator(scanner)

            println("Lütfen ikinci sayıyı girin:")
            val num2 = readNumber(scanner)

            val result = calculate(num1, num2, operator)

            println("Sonuç: $result")
            println("Devam etmek istiyor musunuz? (E/H)")
            continueCalculation = shouldContinue(scanner)

        } catch (e: Exception) {
            println("Bir hata oluştu: ${e.message}")
        }
    }
}

fun readNumber(scanner: Scanner): Double {
    while (true) {
        val input = scanner.nextLine().trim()
        if (input.isEmpty()) {
            println("Boş bir giriş yapılamaz. Lütfen geçerli bir sayı girin.")
            continue
        }
        try {
            return input.toDouble()
        } catch (e: Exception) {
            println("Geçerli bir sayı girin.")
        }
    }
}

fun readOperator(scanner: Scanner): Char {
    while (true) {
        val input = scanner.nextLine().trim()
        if (input.isEmpty()) {
            println("Boş bir giriş yapılamaz. Lütfen geçerli bir işlem girin.")
            continue
        }
        val operator = input[0]
        if (operator in listOf('+', '-', '*', '/')) {
            return operator
        } else {
            println("Geçerli bir işlem girin.")
        }
    }
}

fun calculate(num1: Double, num2: Double, operator: Char): Double {
    return when (operator) {
        '+' -> num1 + num2
        '-' -> num1 - num2
        '*' -> num1 * num2
        '/' -> {
            if (num2 != 0.0) {
                num1 / num2
            } else {
                throw IllegalArgumentException("Bir sayıyı sıfıra bölemezsiniz!")
            }
        }
        else -> throw IllegalArgumentException("$operator geçerli bir işlem değil.")
    }
}

fun shouldContinue(scanner: Scanner): Boolean {
    while (true) {
        val response = scanner.next()
        if (response.lowercase() in listOf("e", "h")) {
            return response.lowercase() == "e"
        } else {
            println("Geçerli bir yanıt girin (E/H).")
        }
    }
}
