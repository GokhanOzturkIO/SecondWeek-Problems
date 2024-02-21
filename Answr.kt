
var numberIsInt = false
var numberIsDouble = false
var intNumber : Int? = null
var doubleNumber : Double? = null
var theOperation : String? = null
var firstNumber : Number? = null
var secondNumber: Number? = null
var stop: Boolean = true

fun main(){
    while (stop){
        getUserInput()
    }
    calculateT()
    println(firstNumber)
    println(secondNumber)
    println(theOperation)

}
fun welcomeWords(){
    println(" Welcome sir.Let's have fun!")
}
fun getUserInput(): Triple<Number?, String?,Number?> {

    fun getNumber(): Number?{
        val number = readlnOrNull()
        intNumber = number?.toIntOrNull()
        doubleNumber = number?.toDoubleOrNull()
        if (intNumber != null){
            return intNumber
        }else if (doubleNumber != null){
            return doubleNumber
        }
        return null
    }
    fun getOperation(): String?{
        val userOperation = readlnOrNull()
        if (userOperation == "+" || userOperation == "-"|| userOperation == "*" || userOperation == "/"){
            return userOperation
        }
        return null
    }

    println("Enter your first number:")
    firstNumber = getNumber()

    println("Enter your operation for to calculate from given ones (+ ,- ,*, /)")
    theOperation = getOperation()

    println("Enter your second number:")
    secondNumber = getNumber()
    if (secondNumber != null){
        stop = false
    }
    return Triple(firstNumber,theOperation,secondNumber)
}
fun calculateT(){
    if (firstNumber != null && secondNumber != null && theOperation != null) {
        var result: Number? = null
        when (theOperation) {
            "+" -> result = firstNumber!!.toDouble() + secondNumber!!.toDouble()
            // Add more cases for other operations
        }
        println("Your result: $result")
    }
//    val fNum: Number? = getUserInput().first
//    val operation = getUserInput().second
//    val sNum: Number? = getUserInput().third
//    var result: Number? = null
//    println(fNum)
//    println(sNum)
//    println(operation)
//
//
//    if (fNum != null && sNum != null && operation != null) {
//        when (operation) {
//            "+" -> result = fNum.toDouble() + sNum.toDouble()
//            // Add more cases for other operations
//        }
//    }
//    println("Your result: $result")
}
