fun main() {
    //Greetings
    greetings()

    //Start calculate
    startCalculate()
}

fun startCalculate() {
    //Enter the first number
    print("Please enter first number: ")
    var firstNumber = readln()

    //Control for firstNumber number or string
    if (!firstNumber.isNumeric()) {
        println("You entered an invalid value, please try again")
        startCalculate()
    }

    //Choose the operator
    print("Select the mathematical operation you want to use(+, -, /, *): ")
    var mathOperator: String = readln()

    //Enter the second number
    print("Please enter the second number: ")
    var secondNumber = readln()

    //Control for secondNumber number or string
    if (!secondNumber.isNumeric()) {
        println("You entered an invalid value, please try again")
        startCalculate()
    }

    //Type conversion for calculate
    val doubleFirstNumber = firstNumber.toDouble()
    val doubleSecondNumber = secondNumber.toDouble()

    //Calculate result
    val result = when (mathOperator) {
        "+" -> doubleFirstNumber + doubleSecondNumber
        "-" -> doubleFirstNumber - doubleSecondNumber
        "/" -> doubleFirstNumber / doubleSecondNumber
        "*" -> doubleFirstNumber * doubleSecondNumber
        else -> "Selected wrong operator"
    }
    println("Result = $result")

    //Asking for continue or break
    continueCalculate()
}

fun continueCalculate() {
    print("Do you want continue (Y/N): ")
    val selectedLetter = readln().toUpperCase()

    val answer = when (selectedLetter) {
        "Y" -> startCalculate()
        "N" -> println("Thanks for using our app")
        else -> {
            println("Your choice is not Y or N, please select again: ")
            continueCalculate()
        }
    }
}

fun greetings() {
    print("Enter your name: ")
    val name: String = readln()
    println("Hello $name")
}

fun String.isNumeric(): Boolean {
    return this.all { char -> char.isDigit() }
}

//Oluşabilecek hatalar
// 1- Kullanıcı sayı istenen kısımlara String bir ifade veya özel karakterler girebilir. -> Çözüldü
// 2- Kullanıcı isim alanına sayı girebilir.
// 3- Kullanıcı matematiksel operatör istenen kısıma farklı değerler girebilir.