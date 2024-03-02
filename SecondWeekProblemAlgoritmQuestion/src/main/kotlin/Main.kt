package org.example

import java.util.*

fun main() {
    userQuery()
}

fun userQuery() {

        while (true) {
            println("Merhaba, hoş geldiniz!")
            try {
                val scanner = Scanner(System.`in`)
                println("Lütfen ilk sayıyı giriniz:")
                val num1 = scanner.nextDouble()
                println("Lütfen yapmak istediğiniz işlemi giriniz (+, -, *, /):")
                val operation = scanner.next()[0]
                println("Lütfen ikinci sayıyı giriniz:")
                val num2 = scanner.nextDouble()
                val result = when (operation) {
                    '+' -> num1 + num2
                    '-' -> num1 - num2
                    '*' -> num1 * num2
                    '/' -> {
                        if (num2 != 0.0) num1 / num2
                        else throw ArithmeticException("Bir sayıyı sıfıra bölemezsiniz!")
                    }
                    else -> throw IllegalArgumentException("Geçersiz işlem!")
                }
                println("Sonuç: $result")
                println("Devam etmek istiyor musunuz? (E/H)")
                val continueChoice = scanner.next()[0]
                if (continueChoice == 'H' || continueChoice == 'h') break
            } catch (e: InputMismatchException) {
                println("Geçersiz giriş! Lütfen bir sayı girin.")
            } catch (e: Exception) {
                println("Bir hata oluştu: ${e.message}")
            }
        }
    }
