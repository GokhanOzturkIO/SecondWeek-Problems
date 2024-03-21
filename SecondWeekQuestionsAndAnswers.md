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

    "Type safety" in Kotlin is a feature that minimizes errors associated with types in code. This is provided by Kotlin's type system, ensuring that we use data types correctly and safely. Kotlin ensures type safety in various ways, including null safety, type inference, type checks, and smart casts, allowing us to write code with minimal errors.

7. What should we do to make a variable nullable?

    In Kotlin we have to append `?` to the type in declaration in or order to make it a nullable type. For example:

    ```kotlin
        var age: Int? = calculateAge(1990)
    ```
    In the above code, `age` variable can take null values (nullable).

8. Explain the concept of "Null Safety".

    The concept of null safety in Kotlin aims to prevent NullPointerException errors while writing code. This way, we avoid subjecting values that should not be null to operations that could potentially throw errors if the value is null, thus simplifying our debugging processes. In Kotlin, we can achieve null safety using the let scope function and the elvis operator alongside the if/else structure in Java. We use the ? and !! operators to determine whether a value is null. However, when using the !! operator, we must be extremely cautious because it indicates to the IDE that the value is not null.

9. If a null value is assigned to a variable and the type is not specified, how does Kotlin interpret this variable?

    If we assign a null value to a variable without specifying its type in Kotlin, Kotlin infers the type of that variable as Nothing?. Nothing indicates that a function will never return normally. Nothing? signifies that it can only hold a null value and doesn't represent any other value.

10. What are the differences in memory management between an nullable primitive variable and one that cannot hold null values?

    Primitive types are stored in a memory structure called the stack, whereas object types are stored in the heap for their values and in the stack for their addresses. Compared to the stack, the heap operates relatively slower. Making a value nullable converts it to an object type, resulting in relatively slower performance and more memory consumption compared to a primitive type.

11. What is the difference in memory management between a nullable variable having a value and being null? Can we say that a variable with a null value does not occupy memory?

    If a nullable variable has a value, it means that the value is stored in the heap and its address is stored in the stack. If it holds a null value, its address is still kept in the stack, but the value in the heap is cleared. In this case, it still occupies memory in the stack.

12. Which operators do we use when working with nullable variables? What are the differences in usage of these operators? When is it more meaningful to use which one?

    When working with nullable values in Kotlin, we primarily have three operators: `?.` (safe call operator), `?:` (Elvis operator), and `!!` (non-null assert operator).

    * We use the `?.` operator to check if the value is null. If the value is not null, the operation is performed. This allows us to safely handle null values and prevent potential errors.
    * We use the `?:` operator to provide a default value or execute an alternative operation if the value is null. It's a concise form of an if/else statement.
    * The `!!` operator asserts that a nullable variable is not null. However, if the variable is null, it will throw a NullPointerException. Therefore, it should be used with caution.

### Numbers

1. How many different types of "number" subclasses are there inheriting from the "Number" class? Why are their value ranges important?

    There are 6 subclasses inheriting from the Number class: `Byte`, `Short`, `Int`, `Long`, `Double`, and `Float`. These data types are important to us because they have specific value ranges they can hold. They occupy different amounts of memory in accordance with their value ranges. To achieve maximum performance in our projects, we should work with data types that match the value ranges. For example, we should use the Long data type to represent larger numbers or the Byte or Short data types to represent smaller numbers. Additionally, we should be careful not to exceed the value ranges of the data types we use in our calculations to avoid unexpected behavior.

2. If a variable is declared without a type and a value is assigned to it, how does Kotlin perform type inference?

    The Kotlin compiler infers the appropriate data type based on the assigned value. For example, if the assigned value is a number, the compiler determines the variable's type by looking at its value range. Specifically for numbers, if we don't specify explicitly, Kotlin assumes them to be of type Int for smaller numbers. When a number exceeds the Int range, Kotlin will infer the type as Long.

3. When creating a Float variable, why are both `F` and `f` allowed, while there's no lowercase l when creating a Long variable?

    In some fonts, the numeral "1" and the lowercase letter "l" (ell) look very similar, causing confusion. Therefore, the lowercase "l" is often avoided in situations where clarity is crucial to prevent confusion with the numeral "1".

4. Explain the concepts of Single precision and Double precision.

    Single precision numbers use a 32-bit floating-point format, while double precision numbers use a 64-bit format. Single precision numbers consume less memory but have lower precision. Double precision numbers, on the other hand, consume more memory and have higher precision.

5. What symbols are used as decimal separators when working with Double and Float variables? What should be considered when using these separators?

    When working with Double and Float variables, a dot (.) is used as the decimal separator. For example:

    ```kotlin
        val floatNumber: Float = 5.13f
        val doubleNumber: Double = 5.13
    ```

6. How many digits can Double and Float variables process in the fractional part? How do they behave for decimal information exceeding this limit? In which scenarios should Float and which scenarios should Double be used?

    Float numbers perform operations with 6-7 digits of precision in the decimal part, whereas Double numbers perform operations with 15-16 digits of precision in the decimal part. If there are decimal digits beyond this limit, they are either rounded or truncated. When we require higher precision, using the Double data type would be more appropriate. For instance, it can be used in applications involving financial or scientific calculations where precision is crucial. On the other hand, the Float data type can be used in applications where lower memory usage and faster calculations are required, such as games or signal processing.

7. How can you define Decimal, Hexadecimal, and Binary variables in Kotlin?

    ```kotlin 
        val decimalNumber = 1990
        val hexadecimalNumber = 0x7F // it corresponds to 127 as decimal counterpart.
        val binaryNumber = 0b10010 // it corresponds to 18 as decimal counterpart.
    ```

8. How are Octal variables defined in Java? Can Octal variables be defined in Kotlin?

    In Java, octal numbers are represented by prefixing the numbers with 0. However, this is not valid in Kotlin. We cannot directly define a numerical expression as octal in Kotlin. Instead, we can use the parseInt or toInt functions from the Integer class. For example:
    
    ```kotlin 
        fun main() {
            val numberToParse = 120

            octalToDecimalUsingParseInt(numberToParse.toString()) // output is 80

            octalToDecimalUsingToInt(numberToParse.toString()) // output is 80
        }

        fun octalToDecimalUsingParseInt(octal: String): Int {
            return Integer.parseInt(octal, 8)
        }

        fun octalToDecimalUsingToInt(octal: String): Int {
            return octal.toInt(8)
        }
    ```

9. How is Conventional Notation represented?

    In Kotlin, conventional notation for Double numbers can be expressed as "172.3" or "172.3e10", while for Float numbers it can be represented as "172.3f" or "172.3F".

10. How is the underscore (_) used in numerical variables? How does Kotlin interpret this?

    The underscore is used to enhance the readability of large numbers. It is ignored by the IDE. A number defined as `1_000_000` is interpreted as `1000000` by the IDE.

11. What do we compare with `==`? What do we compare with `===`?

    `==` operator compares two values and returns true if the values are equal. `===` operator compares two references and returns true if both objects point to the same memory location in the heap.

12. Why is the Byte value range important when comparing with the `===` operator? Why does Kotlin exhibit special behavior according to this range?

    The `===` operator creates a single allocation in memory for byte values between -128 and 127 for performance optimization purposes. For values outside this range, a new memory allocation is made each time. Consequently, when comparing values within the range of -128 to 127 using the `===` operator, even if the values are different, it returns `true` because they share the same memory location. For values outside this range, it compares both the value and the memory address.

13. What mathematical operators can be used in numerical variables?

    In Kotlin, we can use operators to perform addition, subtraction, multiplication, division, and modulus operations between numbers. Additionally, we can also use various extension functions defined in the Kotlin Primitives or FloorDivMod class. For example:

    ```kotlin
        val sumWithOperator = 5 + 2
        val sumWithFunction = 5.plus(2)

        val subtractWithOperator = 5 - 2
        val subtractWithFunction = 5.minus(2)

        val multiplyWithOperator = 5 * 2
        val multiplyWithFunction = 5.times(2)

        val divisionWithOperator = 5 / 2
        val divisionWithFunction = 5.div(2)

        val modWithOperator = 5 % 2
        val modWithFunction = 5.mod(2) // the mod function is defined in Kotlin's FloorDivMod class
    ```

14. What comparison operators can be used in numerical variables?

    ```kotlin
        == (equals) -> Returns true if two values are equal.
        != (not equal) -> Returns true if two values are not equal.
        < (less than) -> Returns true if the left-hand side value is less than the right-hand side value.
        > (greater than) -> Returns true if the left-hand side value is greater than the right-hand side value.
        >= (greater than or equal to) -> Returns true if the left-hand side value is greater than or equal to the right-hand side value.
        <= (less than or equal to) -> Returns true if the left-hand side value is less than or equal to the right-hand side value. 
        in (in range) -> Returns true if the left-hand side value is in the range specified on the right-hand side (e.g., a..b).
        !in (not in range) -> Returns false if the left-hand side value is in the range specified on the right-hand side (e.g., a..b).
    ```

15. What are Bitwise operators? What are they used for? How can you use them in Kotlin?

    Bitwise operators are operators that allow us to directly access individual bits within data. These operators are commonly used in low-level programming, data compression, data encryption, and performance optimization. Bitwise operators include:

    AND (&): Performs the AND operation on two bits. If both bits are 1, the result is 1; otherwise, the result is 0.
    OR (|): Performs the OR operation on two bits. If at least one bit is 1, the result is 1; otherwise, the result is 0.
    XOR (^): Performs the XOR (exclusive OR) operation on two bits. If the two bits are different, the result is 1; if they are the same, the result is 0.
    NOT (~): Takes the complement of a bit, i.e., 0 becomes 1 and 1 becomes 0.
    Left Shift (<<): Shifts a specified number of bits to the left. The vacant bits on the left are filled with zeros.
    Right Shift (>>): Shifts a specified number of bits to the right. The vacant bits on the right are filled based on the sign bit (signed right shift).

    ```kotlin
            val a = 5 // 0101
            val b = 3 // 0011

            val andResult = a and b // 0101 & 0011 = 0001 (1)
            val orResult = a or b // 0101 | 0011 = 0111 (7)
            val xorResult = a xor b // 0101 ^ 0011 = 0110 (6)
            val notResult = a.inv() // ~0101 -> 1010 (-6)
            val leftShiftResult = a shl 1 // 0101 << 1 = 1010 (10)
            val rightShiftResult = a shr 1 // 0101 >> 1 = 0010 (2)
        ```

16. What additional types are used when working with large numbers in Kotlin, and what are their limits?

    When working with large numbers in Kotlin, we use the `BigInteger` and `BigDecimal` classes. Additionally, Kotlin provides `MAX_VALUE` constants assigned to primitive types. Regarding `BigInteger` and `BigDecimal`, their limits can vary depending on the memory allocated by the JVM. Due to their potentially large values, they can impose a significant overhead in terms of both memory usage and processing speed. On the other hand, the `MAX_VALUE` constants assigned to primitive types can be directly accessed. For `Int`, `Double`, and `Long`, the `MAX_VALUE` constants are as follows:

    ```java
        public const val MAX_VALUE: Int = 2147483647
        public const val MAX_VALUE: Double = 1.7976931348623157E308
        public const val MAX_VALUE: Long = 9223372036854775807L
    ```

17. What is the rounding behavior when using Double and Float variables? How can this behavior be modified?

    In Kotlin, by default, floating-point numbers work with the rounding mechanism towards the nearest integer. This operation is performed in compliance with the IEEE 754 standard. For financial calculations or other scenarios requiring precise rounding, we can use the `setScale` method of `BigDecimal`. For example:

     ```kotlin
        val doubleNumber = 1.5323512

        val roundedBigDecimal = doubleNumber.toBigDecimal().round(MathContext.DECIMAL64).setScale(3, RoundingMode.HALF_UP) // Here, rounding is performed by examining the third decimal place of the floating-point number, rounding up if it is 5 or greater, otherwise rounding down.
    ```

    Additionally, Kotlin provides `roundToInt()` or `roundToLong()` functions, which we can use. We can also write custom rounding functions according to our needs.