# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answers 

1. This assertion fails because the float which represent 0.4 is not perfectly accurate, it's a guestimate. In consequence the product will not give exactly 1.2. The type of check have to conseder an interval. Example : `assertTrue(3 * .4 < 1.21 && 3 * .4 > 1.99)`

2. assertEquals call the `equals()` method available for the objets targetted. If the program is well developed, this methods will compare the objects depending their values.
assertSame will check the references of the objects. assertSame will return true just if the same object is represented by the both variables.

3. `fail` can be used to chec that a part of the code is not executed but it is also usefull to check if an exception has been thrown.
Example : `try{ ...; fail("Exception not thrown") }catch(Exception e) {assertTrue(...)}`

4. This new assertion method `assertThrows` can be usefull to chain the asserts check. An assert can be thrown and catch then another can be thrown ... With JUNIT5 it's possible to test several exceptions in the same method. It was impossible to do that with the annotation