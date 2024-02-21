var intNumber : Int? = null
var doubleNumber : Double? = null
var theOperation : String? = null
var firstNumber : Number? = null
var secondNumber: Number? = null
var stop: Boolean = true

fun main(){
    while (stop){
        getUserInput()
        calculateT()
        stopOrRun()
    }


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
            "-" -> result = firstNumber!!.toDouble() - secondNumber!!.toDouble()
            "*" -> result = firstNumber!!.toDouble() * secondNumber!!.toDouble()
            "/" -> result = firstNumber!!.toDouble() / secondNumber!!.toDouble()

            // Add more cases for other operations
        }
        println("Your result: $result")
    }
}
fun errorMessage(){
    var errMsg:String = "it seems like you did something wrong"
}
fun stopOrRun(){
    println("Do you want to continue Y or N:")
    val yesOrNo = readln()
    when(yesOrNo){
        "Y" -> stop=true
        "y" -> stop=true
        "N" -> stop=false
        "n" -> stop=false


    }
    if (stop == false){
        println(" Okay byeeee")
    }
}