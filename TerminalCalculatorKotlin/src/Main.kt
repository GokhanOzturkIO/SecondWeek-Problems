//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.text.DecimalFormat

fun main() {
    println("Welcome to my Calculator Terminal")
    startApp()
}

fun startApp() {
    var n1: Double?
    var n2: Double? = null
    var operation: String? = null


    do {
        println("Enter the first number:")
        n1 = readln().toDoubleOrNull()
        if (n1 == null) {
            println("Error: Please enter only a numeric value. For example '25'\n")
            continue
        }
    } while (n1 == null)

    do {
        println("Enter one of the 4 operations (addition/subtraction/multiplication/division) you want to select:")
        operation = readln()
        if (operation !in listOf("+", "-", "*", "/")) {
            println("Warning: You entered an incorrect operation. If you know 4 operations, please try again.\n")

        }
    } while (operation !in listOf("+", "-", "*", "/"))

    do {
        println("Enter the second number:")
        n2 = readln().toDoubleOrNull()
        if (n2 == null) {
            println("Error: Please enter only a numeric value. For example '25'")
            continue
        }
    } while (n2 == null)



    when (operation) {
        "+" -> add(n1, n2)
        "-" -> sub(n1, n2)
        "*" -> multi(n1, n2)
        "/" -> div(n1, n2)
        else -> println("DANGEEER")
    }
}


fun add(n1: Double?, n2: Double?) {
    var total = n1!! + n2!!
    val result = DecimalFormat("#.####").format(total)
    println("Result of Addition Process: ${result}")
}

fun sub(n1: Double?, n2: Double?) {
    val total = n1!! - n2!!
    val result = DecimalFormat("#.####").format(total)
    println("Subtraction Result: ${total}")
}

fun multi(n1: Double?, n2: Double?) {
    val total = n1!! * n2!!
    val result = DecimalFormat("#.####").format(total)
    println("Multiplication Result: ${result}")
}

fun div(n1: Double?, n2: Double?) {
    val total = n1!! / n2!!
    val result = DecimalFormat("#.####").format(total)
    println("Division Result: ${result}")
}

