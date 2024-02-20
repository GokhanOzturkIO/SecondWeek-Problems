package com.oedu.secondweek

//Medium Yazım : https://medium.com/@ciftci.oguz/kotli%CC%87nde-reference-type-tam-sayilarin-bellek-opti%CC%87mi%CC%87zasyonu-76a140ecaee6
var getNumber1: Double? = null
var getNumber2: Double? = null
var getAction: String? = null
var answer: String? = null

fun main() {
    println("***************************************************")
    println("Hello")
    println("***************************************************")
    do {
        getUserFirstInput()
        getAction = getActionInput()
        getUserSecondInput()

        val result = when (getAction) {
            "+" -> "${getNumber1?.plus(getNumber2!!)}"
            "-" -> {
                if (getNumber1!! > getNumber2!!) {
                    "${getNumber1?.minus(getNumber2!!)}"
                } else if (getNumber2!! > getNumber1!!) {
                    "${getNumber2?.minus(getNumber1!!)}"
                } else {
                    "0"
                }
            }

            "*","x" -> "${getNumber2?.let { getNumber1?.times(it) }}"
            "/" -> {
                if (getNumber1 == 0.0 || getNumber2 == 0.0) {
                    "Tanımsız"
                } else {
                    "${getNumber1?.div(getNumber2!!)}"
                }
            }

            else -> "A problem has occurred"
        }
      val c= if (result.toDouble()%1==0.0){
          String.format("%.0f",result.toDouble())
        }else{
          String.format("%.3f",result.toDouble())
        }
        println("Result : $c")
        println("Would you like to continue? \n Yes \n No")
        do {
            answer = readlnOrNull().toString()
        } while (answerCheck(answer) == 2)

    } while (answerCheck(answer)==1)
    println("Have a Nice Day")

}

fun answerCheck(answer: String?): Int {
    when (answer) {
        "Y", "Yes", "yes", "y" -> return 1
        "N", "No", "no", "n" -> return 0
        else -> println("Incorrect login, try again: ")
    }
    return 2
}

fun getUserFirstInput() {

    do {
        print("Enter the first number: ")
        val s1 = readlnOrNull()
        getNumber1 = numberFirstControl(s1)

    } while (getNumber1 == null)

}

fun getUserSecondInput() {

    do {
        print("Enter the Second number: ")
        val s2 = readlnOrNull()
        getNumber2 = numberSecondControl(s2)

    } while (getNumber2 == null)

}


fun getActionInput(): String? {
    var action:String?=null
    do {
        println("Please select the action you want to take (+, *, -, /)")
         action = readlnOrNull()
    }while (actionControl(action)==null)
   return action
}


fun numberFirstControl(number: String?): Double? {
    when {
        number.isNullOrBlank() -> {
            println("You have entered a blank entry, please try again")
        }

        number.isDouble() -> {
            val cleanedNumber = number.replace(',', '.')
            return cleanedNumber.toDoubleOrNull()
        }

        else -> {
            println("The value entered is not a number.")
        }
    }
    return null
}

fun numberSecondControl(number: String?): Double? {
    when {
        number.isNullOrBlank() -> {
            println("You have entered a blank entry, please try again.")
        }

        number.isDouble() -> {
            val cleanedNumber = number.replace(',', '.')
            return cleanedNumber.toDoubleOrNull()
        }

        else -> {
            println("The value entered is not a number.")
        }
    }
    return null
}


fun actionControl(action: String?): String? {

    when (action) {
        "+" -> return "+"
        "-" -> return "-"
        "*", "x" -> return "*"
        "/" -> return "/"
        else -> {
            println("Invalid process selection")
        }
    }
    return null
}


fun String.isDouble(): Boolean {
    return this.toDoubleOrNull() != null
}




