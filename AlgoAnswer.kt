fun main(){
val userInput : String = readLine()!!
println("$userInput")
}
fun welcomeWord(){
    println("Welcome to calculator")
}

fun getUserInputs(){
    println("Enter the a number:")
    val userNumber = readLine()
    val userNumberInt = userNumber?.toIntOrNull()
    val userNumberFloat = userNumber?.toFloatOrNull()
    var numberIsInt: Boolean = false
    var numberIsFloat: Boolean = false
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