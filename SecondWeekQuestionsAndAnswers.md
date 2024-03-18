### Basic Types & Null Safety

1. What is the difference between `val` and `var`?
    val (value) values are read-only values and cannot be reassigned after the initial assignment. However, if its value is dependent on other variables, it will change when those variables change. var (variable), on the other hand, are variables whose values can be changed.

2. How can we make a `var` variable behave like a `val` without using the `val` keyword? Why would we want to do this? Provide an example scenario.
    To make a `var` variable behave like a `val` variable, meaning it cannot be reassigned, we make its setter function private. Since variables defined within a class in Kotlin correspond to properties in Java and are by default encapsulated with private access, we can intervene in the setter function to prevent it from being changed. For example:
    
    ```kotlin
    class Cat() {
        var name: String = "Stray cat"

        var pawAmount: Int = 4
            private set

        fun setPawAmount(amount: Int) { // We can ensure safer modification of the variable through a function.
            if(amount <4) {
                // give error
                println("Not enought paws, sorry!")
            } else {
                // accept
                pawAmount = amount
            }
        }
    }

    fun main() {
        val cat = Cat()

        cat.pawAmount = 3 // It won't let us change its value.
        
        cat.setPawAmount(5) // We can allow it to change by the function.
    }
    ```
 
3. Explain the concepts of "Immutable" and "Read-Only". Why should `val` variables actually be described as "Read-Only" rather than "Immutable"?
    Immutable values are values that remain unchanged in any way after they are created. Read-only values, on the other hand, are values that can be assigned (set) only once and can change if their values are dependent on another value. val values are read-only values because they are assigned only once, but they can change if their values are dependent on another value. For example:

    ```kotlin
    fun main() {
        val police = Police()
        police.dispatchPolice()
    }

    class Police() {
        var officerName: String = "Officer Jack"
        var officerRank: Int = 4
        val officerBadge: String
            get() {
                return "Badge: $officerName, Rank: $officerRank"
            }

        fun dispatchPolice() {
            println(officerBadge)
            officerName = "Officer Malfoy"
            officerRank = 5
            println(officerBadge)
            officerName = "Officer Harry"
            officerRank = 3
            println(officerBadge)
        }
    }
    ```

4. Explain the concept of "Type Inference". In which situations is specifying the type absolutely necessary?
    Type inference is the automatic determination of the data type of variables. For example, when we write `var name = "Ferec"`, the IDE automatically assigns the type of the `name` variable as String. If we define our variable within a class, it is mandatory to assign a value to it. However, if we define a variable locally within a function, we must explicitly specify its type.

    ```
    fun runForward() {
        var velocity: Int // Burada başlangıç değeri vermemiz gerekmiyor.
    }

    class Runner() {
        val name: String? = null // Burada başlangıç değeri vermemiz şarttır.
    }
    ```

5. Does Kotlin's requirement for all variables to be classes mean that they are not "primitive types"? What happens behind the scenes?
    In Kotlin, all variables are held as classes. However, these classes are converted to their primitive forms through special optimizations during bytecode conversion. Data held as Int class in Kotlin is represented as the primitive int type in Java. This applies to all variables except String, which is held as a class both in Kotlin and Java.

6. Explain the concept of "Type Safety".
7. What should we do to make a variable nullable?
8. Explain the concept of "Null Safety".
9. If a null value is assigned to a variable and the type is not specified, how does Kotlin interpret this variable?
10. What are the differences in memory management between an nullable primitive variable and one that cannot hold null values?
11. What is the difference in memory management between a nullable variable having a value and being null? Can we say that a variable with a null value does not occupy memory?
12. Which operators do we use when working with nullable variables? What are the differences in usage of these operators? When is it more meaningful to use which one?