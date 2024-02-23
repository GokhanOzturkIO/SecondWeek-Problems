package org.example

fun main() {
   println("***** Welcome the Terminal Calculator *****")
  setUpCalculator()
}

fun setUpCalculator(){
   print("Enter first number : ")
   val firstNumber = readln().toDoubleOrNull()
   print("Enter the mathematical operation you want to perform ('+','-','*','/') : ")
   val operator = readln()
   print("Enter second number : ")
   val secondNumber = readln().toDoubleOrNull()

   if (firstNumber != null && secondNumber != null){
      when(operator){
         "+" -> println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}")
         "-" -> println("$firstNumber - $secondNumber = ${firstNumber - secondNumber}")
         "*" -> println("$firstNumber + $secondNumber = ${firstNumber * secondNumber}")
         "/" -> {
            if(secondNumber.equals(0.0)){
               println("The result of this operation is undefined.")
               setUpCalculator()
            }else{
               println("$firstNumber / $secondNumber = ${firstNumber / secondNumber}\"")
            }
         }
         else ->{
            println("Wrong operator please try again")
            setUpCalculator()
         }
      }
   }else{
      println("The values entered must be numbers.")
      setUpCalculator()
   }
   resumeControl()
}

fun resumeControl(){
   print("Do you want to continue using the terminal calculator? (Y/N) : ")
   val answer = readln()
   if (answer == "y" || answer == "Y"){
      setUpCalculator()
   }else if (answer == "n" || answer == "N"){
      println("Have a good day...")
   }else{
      println("Please write Y for yes and N for no")
      resumeControl()
   }
}