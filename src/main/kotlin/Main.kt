package org.example

import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val scanner = Scanner(System.`in`)
    var ilkAcilis = true

    do {
        if (ilkAcilis) {
            welcome()
            ilkAcilis = false
        }
    getData(scanner)
    println("Devam etmek istiyor musun ? (E/H - e / h) :")
    val devamEt = scanner.next().uppercase()
    }while (devamEt == "E")

    println("hoççakalın gidiom ben")
}

fun welcome() {
    println("Hojigeldiniz!")
}

fun getData(scanner: Scanner) {

    val number1 = getNumber(scanner, "Birinci sayiyi giriniz : ")
    val operator = getOperator(scanner)
    val number2 = getNumber(scanner,"İkinci sayiyi giriniz : ")

    val result = operatorResult(number1 ,operator, number2)
    println("Sonuc :  $result")
}

fun getNumber(scanner: Scanner ,ask : String) : Double {
    var number : Double? = null
    while(number == null) {
        print(ask)
        try {
            number = scanner.nextDouble()
        }catch (e : java.util.InputMismatchException) {
            print("Hatali karakter. Lütfen yalnızca sayi giriniz ")
            scanner.next()
        }
    }

    return number
}

fun getOperator(scanner: Scanner) : String {
    val allowedOperators = setOf("+", "-", "*", "/")

    while (true) {
        print("Yapmak istediğiniz matematiksel işlemi seçiniz (+, -, *, /): ")
        val input = scanner.next()

        if (allowedOperators.contains(input)) {
            return input
        } else {
            println("Hatalı giriş! Lütfen belirtilen matematiksel işlemlerden birini seçiniz.")
        }
    }
}

fun operatorResult(number1: Double, operator: String,number2: Double ) :Double {
    return when (operator) {
            "+" -> number1 + number2
            "-" -> number1 - number2
            "*" -> number1 * number2
            "/" -> number1 / number2
        else -> {
            println("Gecersiz işlem , düzeltin")
            throw IllegalArgumentException("Geçersiz işlem")
        }

    }
}