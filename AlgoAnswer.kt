import java.util.BitSet

var userOperationIsPlus: Boolean = false
var userOperationIsMinus : Boolean = false
var userOperaitonIsMultiply : Boolean = false
var userOperationIsDivision : Boolean = false
var userOperationChecked : Boolean = false
var numberIsInt: Boolean = false
var numberIsFloat: Boolean = false
var userOperation : String? = null
var userNumberFirst :Int? = null
var userNumberSecond :Int? = null
var calculatedValue : Int? = null
var userNumberIsChecked : Boolean = false

fun main(){

    welcomeWord()
    getUserInputs()
    getUserOperation()
    println(userNumberIsChecked and userOperationChecked)
    calculate()
  println("result: $calculatedValue")
//    if (userNumberIsChecked && userOperationChecked){
//        calculate()
//        println("result: $calculatedValue")
//    }else{
//        getUserInputs()
//    }
}
fun welcomeWord(){
    println("Welcome to calculator")
}
fun getUserInputs(){
    println("Enter the a number:")
    val userNumber = readLine()
    val userNumberInt = userNumber?.toIntOrNull()
    val userNumberFloat = userNumber?.toFloatOrNull()
    getUserOperation()
    userNumberIsChecked = checkNumberValue(userNumberInt, userNumberFloat,numberIsInt,numberIsFloat)

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
    if(userOperationIsPlus || userOperationIsMinus || userOperationIsDivision|| userOperaitonIsMultiply) userOperationChecked == true }
fun calculate(){
  calculatedValue =  when(userOperation){
        "+" -> userNumberFirst!! + userNumberSecond!!
        "-" -> userNumberFirst!! - userNumberSecond!!
        "*" -> userNumberFirst!! * userNumberSecond!!
        "/" -> userNumberFirst!! / userNumberSecond!!
        else -> null
     }
}