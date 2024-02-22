import org.example.calculate
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


class MainKtTest {


    @Test
    fun `test calculate function with valid input`() {
        // Arrange
        val number1 = 10.0
        val number2 = 5.0
        val operator = "+"

        // Act
        val result = calculate(number1, number2, operator)

        // Assert
        Assertions.assertEquals("15.0", result)
    }

    @Test
    fun `test calculate function with invalid input`() {
        // Arrange
        val number1 = 10.0
        val number2 = 0.0 // Division by zero error
        val operator = "/"

        // Act
        val result = calculate(number1, number2, operator)

        // Assert
        Assertions.assertEquals("The second number for division must not be zero", result)
    }

    @Test
    fun `emty number1`() {
        // Arrange
        val number1 = null
        val number2 = 5.0
        val operator = "/"

        // Act
        val result = calculate(number1, number2, operator)

        // Assert
        Assertions.assertEquals("One, both or operator of the numbers is empty", result)
    }
    @Test
    fun `emty number2`() {
        // Arrange
        val number1 = 0.0
        val number2 = null
        val operator = "/"

        // Act
        val result = calculate(number1, number2, operator)

        // Assert
        Assertions.assertEquals("One, both or operator of the numbers is empty", result)
    }

    @Test
    fun `empty operator`() {
        // Arrange
        val number1 = 0.0
        val number2 = 5.0
        val operator = null

        // Act
        val result = calculate(number1, number2, operator)

        // Assert
        Assertions.assertEquals("One, both or operator of the numbers is empty", result)
    }


}