
var userOperationIsPlus: Boolean = false
var userOperationIsMinus : Boolean = false
var userOperaitonIsMultiply : Boolean = false
var userOperationIsDivision : Boolean = false
var userOperationChecked : Boolean = false
var numberIsInt: Boolean = false
var numberIsFloat: Boolean = false
var userOperation : String? = null
var userNumberFirst = null
var userNumberSecond = null
var userFirtsNumberIntOrFloat = null
var userSecondNumberIntOrFloat = null
var calculatedValue = null

fun main(){
    val userInput : String = readLine()!!
    println("$userInput")

}
fun welcomeWord(){
    println("Welcome to calculator")
}

fun getUserInputs(){
    println("Enter the a number:")
    userNumber = readLine()
    val userNumberInt = userNumber?.toIntOrNull()
    val userNumberFloat = userNumber?.toFloatOrNull()

    val checkedNumber = checkNumberValue(userNumberInt, userNumberFloat,numberIsInt,numberIsFloat)
    if (checkedNumber){

    }
}
fun checkNumberValue(userNumberInt: Int?, userNumberFloat: Float?,
                     numberIsInt: Boolean, numberIsFloat: Boolean): Boolean{

    var updatedNumberIsInt = numberIsInt
    var updatedNumberIsFloat = numberIsFloat
    if (userNumberInt != null){
        updatedNumberIsInt = true
    }else if (userNumberFloat != null){
        updatedNumberIsFloat = true
    } else{
        println("You did something wrong! Try again.")
        getUserInputs()
    }
    return updatedNumberIsInt || updatedNumberIsFloat
}

fun getUserOperation(){
    println("Enter the operation: ('+','-','*','/'")
    userOperation = readLine()
    if(userOperationIsPlus || userOperationIsMinus || userOperationIsDivision|| userOperaitonIsMultiply) userOperationChecked == true

}
fun calculate(){
  calculatedValue =  when(userOperation){
        "+" -> calculatedValue = userNumberFirst + userNumberSecond
        "-" -> calculatedValue = userNumberFirst - userNumberSecond
        "*" -> calculatedValue = userNumberFirst * userNumberSecond
        "/" -> calculatedValue = userNumberFirst / userNumberSecond
     }


}