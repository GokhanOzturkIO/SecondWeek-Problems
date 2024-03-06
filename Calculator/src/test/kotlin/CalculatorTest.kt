import org.example.Calculator
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class CalculatorTest {
    private lateinit var calculator: Calculator

    @BeforeTest
    fun setUp() {
        calculator = Calculator()
    }

    @Test
    fun testMakeOperation_Addition() {
        val makeOperation =
            calculator.javaClass.getDeclaredMethod("makeOperation", Int::class.java, Int::class.java, Char::class.java)
        makeOperation.isAccessible = true
        assertEquals(4, makeOperation.invoke(calculator, 2, 2, '+'))
    }

    @Test
    fun testMakeOperation_Subtraction() {
        val makeOperation =
            calculator.javaClass.getDeclaredMethod("makeOperation", Int::class.java, Int::class.java, Char::class.java)
        makeOperation.isAccessible = true
        assertEquals(3, makeOperation.invoke(calculator, 5, 2, '-'))
    }

    @Test
    fun testMakeOperation_Multiplication() {
        val makeOperation =
            calculator.javaClass.getDeclaredMethod("makeOperation", Int::class.java, Int::class.java, Char::class.java)
        makeOperation.isAccessible = true
        assertEquals(10, makeOperation.invoke(calculator, 5, 2, '*'))
    }

    @Test
    fun testMakeOperation_Division() {
        val makeOperation =
            calculator.javaClass.getDeclaredMethod("makeOperation", Int::class.java, Int::class.java, Char::class.java)
        makeOperation.isAccessible = true
        assertEquals(2, makeOperation.invoke(calculator, 10, 5, '/'))
    }

    @Test
    fun testMakeOperation_DivisionByZero() {
        val makeOperation =
            calculator.javaClass.getDeclaredMethod("makeOperation", Int::class.java, Int::class.java, Char::class.java)
        makeOperation.isAccessible = true
        assertEquals("Error: Division by zero", makeOperation.invoke(calculator, 10, 0, '/'))
    }

    @Test
    fun testMakeOperation_InvalidOperator() {
        val makeOperation =
            calculator.javaClass.getDeclaredMethod("makeOperation", Int::class.java, Int::class.java, Char::class.java)
        makeOperation.isAccessible = true
        assertEquals("Error: Unexpected result", makeOperation.invoke(calculator, 10, 5, '%'))
    }

    @Test
    fun testContinueToRun_Yes() {
        val continueToRun = calculator.javaClass.getDeclaredMethod("continueToRun")
        continueToRun.isAccessible = true
        val input = ByteArrayInputStream("y".toByteArray())
        System.setIn(input)

        val returnedByFunction = continueToRun.invoke(calculator) as Boolean

        assertTrue(returnedByFunction)
    }

    @Test
    fun testContinueToRun_No() {
        val continueToRun = calculator.javaClass.getDeclaredMethod("continueToRun")
        continueToRun.isAccessible = true
        val input = ByteArrayInputStream("n".toByteArray())
        System.setIn(input)

        val returnedByFunction = continueToRun.invoke(calculator) as Boolean

        assertFalse(returnedByFunction)
    }

    @Test
    fun testContinueToRun_InvalidResponse() {
        val continueToRun = calculator.javaClass.getDeclaredMethod("continueToRun")
        continueToRun.isAccessible = true
        val input = ByteArrayInputStream("invalid\nn\n".toByteArray())
        System.setIn(input)

        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        val returnedByFunction = continueToRun.invoke(calculator) as Boolean
        assertFalse(returnedByFunction)

        // Check output
        val expectedOutput = "Error: Please Enter a valid response."
        val actualOutput = output.toString()
        assertTrue(actualOutput.contains(expectedOutput))
    }

    @Test
    fun testGetOperator_ValidInput() {
        val getOperator = calculator.javaClass.getDeclaredMethod("getOperator")
        getOperator.isAccessible = true
        val input = ByteArrayInputStream("+\n".toByteArray())
        System.setIn(input)

        val returnedByFunction = getOperator.invoke(calculator) as Char

        assertEquals('+', returnedByFunction)
    }

    @Test
    fun testGetOperator_InvalidInput() {
        val getOperator = calculator.javaClass.getDeclaredMethod("getOperator")
        getOperator.isAccessible = true
        val input = ByteArrayInputStream("invalid\n+\n".toByteArray())
        System.setIn(input)

        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        val returnedByFunction = getOperator.invoke(calculator) as Char
        assertEquals('+', returnedByFunction)

        // Check output
        val expectedOutput = "Error: Please choose a valid operator."
        val actualOutput = output.toString()
        assertTrue(actualOutput.contains(expectedOutput))
    }

    @Test
    fun testGetNumber_ValidNumber() {
        val getNumber = calculator.javaClass.getDeclaredMethod("getNumber", String::class.java)
        getNumber.isAccessible = true
        val input = ByteArrayInputStream("42\n".toByteArray())
        System.setIn(input)

        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        val returnedByFunction = getNumber.invoke(calculator, "Enter a number: ") as Int
        assertEquals(42, returnedByFunction)

        // Check output
        val expectedOutput = "Enter a number: "
        val actualOutput = output.toString()
        assertTrue(actualOutput.contains(expectedOutput))
    }

    @Test
    fun testGetNumber_InvalidNumber() {
        val getNumber = calculator.javaClass.getDeclaredMethod("getNumber", String::class.java)
        getNumber.isAccessible = true
        val input = ByteArrayInputStream("invalid\n42\n".toByteArray())
        System.setIn(input)

        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        val returnedByFunction = getNumber.invoke(calculator, "Enter a number: ") as Int
        assertEquals(42, returnedByFunction)

        // Check output
        val expectedOutput = "Error: Please enter a valid number."
        val actualOutput = output.toString()
        assertTrue(actualOutput.contains(expectedOutput))
    }
}
