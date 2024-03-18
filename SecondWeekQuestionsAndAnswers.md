### Basic Types & Null Safety

1. What is the difference between `val` and `var`?
    val (value) values are read-only values and cannot be reassigned after the initial assignment. However, if its value is dependent on other variables, it will change when those variables change. var (variable), on the other hand, are variables whose values can be changed.

2. How can we make a `var` variable behave like a `val` without using the `val` keyword? Why would we want to do this? Provide an example scenario.
3. Explain the concepts of "Immutable" and "Read-Only". Why should `val` variables actually be described as "Read-Only" rather than "Immutable"?
4. Explain the concept of "Type Inference". In which situations is specifying the type absolutely necessary?
5. Does Kotlin's requirement for all variables to be classes mean that they are not "primitive types"? What happens behind the scenes?
6. Explain the concept of "Type Safety".
7. What should we do to make a variable nullable?
8. Explain the concept of "Null Safety".
9. If a null value is assigned to a variable and the type is not specified, how does Kotlin interpret this variable?
10. What are the differences in memory management between an nullable primitive variable and one that cannot hold null values?
11. What is the difference in memory management between a nullable variable having a value and being null? Can we say that a variable with a null value does not occupy memory?
12. Which operators do we use when working with nullable variables? What are the differences in usage of these operators? When is it more meaningful to use which one?