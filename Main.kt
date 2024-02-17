package org.example

import java.awt.print.Printable
import java.lang.reflect.Type
import java.net.Proxy
import kotlin.math.ceil
import kotlin.reflect.typeOf
import kotlin.system.exitProcess

/*
   Kullanıcının giridiği değer çok büyük olabilir,ondalıklı olabilir,sayı olmayabilir.
   Kullanıcı yapmak istediği işelmin işaretini farklı bir şey girebilir.

    */
fun main() {

    println("Merhaba değerli kullanıcı <3")

    val firstUserInputNumber = getFirstNumber()

    val userProcessSign = getSign()

    val secondUserInputNumber = getSecondNumber()
    when (userProcessSign) {
        "x" -> mymultiply(firstUserInputNumber,secondUserInputNumber)
        "-" -> myminus(firstUserInputNumber,secondUserInputNumber)
        "/" -> mydivision(firstUserInputNumber,secondUserInputNumber)
        "+" -> myplus(firstUserInputNumber,secondUserInputNumber)
    }

}
fun getFirstNumber():String{
    println("İşlem yapmak istediğiniz işlemdeki ilk sayıyı giriniz")

    val firstUserInputNumber = readLine()!!

    if (firstUserInputNumber != null) {
        val intNumber: Int? = firstUserInputNumber.toIntOrNull()
        val longNumber: Long? = firstUserInputNumber.toLongOrNull()
        val floatNumber: Float? = firstUserInputNumber.toFloatOrNull()

        if (intNumber != null) {
            return intNumber.toString()
        } else if (longNumber != null) {
            return longNumber.toString()
        } else if (floatNumber != null) {
            return  floatNumber.toString()
        } else {
            println("Girilen değer sayısal bir türe dönüştürülemedi.")
            return getFirstNumber()
        }
    }
    else {
        println("Geçersiz giriş!")
        return getFirstNumber()
    }

}
fun getSecondNumber():String{
    println("İşlem yapmak istediğiniz ikinici sayıyı giriniz")
    val secondUserInputNumber = readLine()!!.toString()

    if (secondUserInputNumber != null) {
        val intNumber: Int? = secondUserInputNumber.toIntOrNull()
        val longNumber: Long? = secondUserInputNumber.toLongOrNull()
        val floatNumber: Float? = secondUserInputNumber.toFloatOrNull()

        if (intNumber != null) {
            return intNumber.toString()
        } else if (longNumber != null) {
            return longNumber.toString()
        } else if (floatNumber != null) {
            return  floatNumber.toString()
        } else {
            println("Girilen değer sayısal bir türe dönüştürülemedi.")
            return getSecondNumber()
        }
    }
    else {
        println("Geçersiz giriş!")
        return getSecondNumber()
    }

}

fun getSign():String{
    println("Şimdi ise yapmak istediğiniz işlemin işaretini giriniz")
    println("çarpma için ->'x' ")
    println("bölme için ->'/' ")
    println("toplama için ->'+' ")
    println("çıkarma için ->'-' ")
    val userProcessSign = readLine()!!
    when(userProcessSign){

        "x" -> return "x"
        "/" -> return "/"
        "+" -> return "+"
        "-" -> return "-"
        else -> {
            println("Hatalı işaret girdiniz gösterilenlerden bir tane giriniz")
            return getSign()
        }
    }

}

fun myplus(firstNumber:String,secondNumber:String){

    val firstInt: Int? = firstNumber.toIntOrNull()
    val secondInt: Int? = secondNumber.toIntOrNull()

    val firstLong: Long? = firstNumber.toLongOrNull()
    val secondLong: Long? = secondNumber.toLongOrNull()

    val firstFloat: Float? = firstNumber.toFloatOrNull()
    val secondFloat: Float? = secondNumber.toFloatOrNull()

    if (firstInt != null && secondInt != null) {
        println((firstInt + secondInt).toString())
    } else if (firstLong != null && secondLong != null) {
        println ((firstLong + secondLong).toString())
    } else if (firstFloat != null && secondFloat != null) {
        println ((firstFloat + secondFloat).toString())
    } else {
        println("Geçersiz giriş!")
    }
}
fun myminus(firstNumber:String,secondNumber:String){

    val firstInt: Int? = firstNumber.toIntOrNull()
    val secondInt: Int? = secondNumber.toIntOrNull()

    val firstLong: Long? = firstNumber.toLongOrNull()
    val secondLong: Long? = secondNumber.toLongOrNull()

    val firstFloat: Float? = firstNumber.toFloatOrNull()
    val secondFloat: Float? = secondNumber.toFloatOrNull()

    if (firstInt != null && secondInt != null) {
        println((firstInt - secondInt))
    } else if (firstLong != null && secondLong != null) {
        println ((firstLong - secondLong))
    } else if (firstFloat != null && secondFloat != null) {
        println ((firstFloat - secondFloat))
    } else {
        println("Geçersiz giriş!")
    }

}
fun mymultiply(firstNumber:String,secondNumber:String){

    val firstInt: Int? = firstNumber.toIntOrNull()
    val secondInt: Int? = secondNumber.toIntOrNull()

    val firstLong: Long? = firstNumber.toLongOrNull()
    val secondLong: Long? = secondNumber.toLongOrNull()

    val firstFloat: Float? = firstNumber.toFloatOrNull()
    val secondFloat: Float? = secondNumber.toFloatOrNull()

    if (firstInt != null && secondInt != null) {
        println((firstInt * secondInt))
    } else if (firstLong != null && secondLong != null) {
        println ((firstLong * secondLong))
    } else if (firstFloat != null && secondFloat != null) {
        println ((firstFloat * secondFloat))
    } else {
        println("Geçersiz giriş!")
    }}
fun mydivision(firstNumber:String,secondNumber:String){

    val firstInt: Int? = firstNumber.toIntOrNull()
    val secondInt: Int? = secondNumber.toIntOrNull()

    val firstLong: Long? = firstNumber.toLongOrNull()
    val secondLong: Long? = secondNumber.toLongOrNull()

    val firstFloat: Float? = firstNumber.toFloatOrNull()
    val secondFloat: Float? = secondNumber.toFloatOrNull()

    if (firstInt != null && secondInt != null) {
        println((firstInt / secondInt))
    } else if (firstLong != null && secondLong != null) {
        println ((firstLong / secondLong))
    } else if (firstFloat != null && secondFloat != null) {
        println ((firstFloat / secondFloat))
    } else {
        println("Geçersiz giriş!")
    }}