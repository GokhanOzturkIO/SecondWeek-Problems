package org.example

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    println("*****************HOŞ GELDİNİZ**************")

    var devamEdilsinMi = true

    while (devamEdilsinMi) {
        println("İlk sayıyı girin:")
        val sayi1 = try {
            scanner.nextInt()
        } catch (e: InputMismatchException) {
            println("Hatalı giriş! Lütfen bir sayı girin.")
            scanner.nextLine() // Bufferı temizle
            continue
        }

        println("Yapmak istediğiniz işlemi seçin (+, -, *, /):")
        val islem = scanner.next()[0]

        println("İkinci sayıyı girin:")
        val sayi2 = try {
            scanner.nextInt()
        } catch (e: InputMismatchException) {
            println("Hatalı giriş! Lütfen bir sayı girin.")
            scanner.nextLine() // Bufferı temizle
            continue
        }

        val sonuc = when (islem) {
            '+' -> sayi1 + sayi2
            '-' -> sayi1 - sayi2
            '*' -> sayi1 * sayi2
            '/' -> {
                if (sayi2 == 0) {
                    println("Hatalı işlem! Sıfıra bölme hatası.")
                    continue
                }
                sayi1 / sayi2
            }
            else -> {
                println("Hatalı işlem! Geçerli bir işlem seçin.")
                continue
            }
        }

        println("Sonuç: $sonuc")

        println("Devam etmek istiyor musunuz? (Evet için 'E' girin)")
        val devam = scanner.next()
        devamEdilsinMi = (devam == "E")
    }

    println("Uygulamadan çıkılıyor!!")
    scanner.close()
}
