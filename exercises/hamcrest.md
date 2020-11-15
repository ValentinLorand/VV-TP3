# Make your test clean and maintainable using Hamcrest

When verifying properties on complex data-structure, your unit tests' assertions can become messy.
For example, the following code verify that the Poll structure of our Doodle application is a valid open poll that contains at least 2 time slots, has not the food preference functionality.

``` java
    Poll thePoll = getPoll();

    assertNotNull("The poll was null", thePoll);
    assertFalse("The poll has meal", thePoll.isHas_meal());
    assertFalse("The poll is closed", thePoll.isClos());
    assertNull("The poll has already a selected choice", thePoll.getSelectedChoice());
    assertNotNull("The list of Meal Preference is Null", thePoll.pollMealPreferences());
    assertTrue("Meal Preferences are not empty", thePoll.pollMealPreferences().isEmpty());
    assertTrue("There is less than two options in the poll", thePoll.getPollChoices().size() >= 2);
```

Hamcrest is a Framework that provide an internal Domain-Specific Language to express the testing assertions.
This framework provide, among other things, facilities to develop readable, flexible and maintainable tests.
For instance, the previous test could be writen as follows using Hamcrest :

``` java
    Poll thePoll = getPoll();

    assertThat(thePoll, allOf(
        is(notNullValue()), 
        is(notContainingMeal()), 
        is(open()), 
        hasMultipleChoice() 
        ));
```

Hamcrest is based on the use and composition of **Matchers**. 
Matchers are specific objects that aim at verifying one property of an object.
The use of Matchers also help while reading test results by providing meaningful description of the failure.
The following code is a concrete example of how to implement a matcher that verify if a Double is NaN.

```java
public class IsNotANumber extends TypeSafeMatcher {

  @Override 
  public boolean matchesSafely(Double number) { 
    return number.isNaN(); 
  }

  public void describeTo(Description description) { 
    description.appendText("not a number"); 
  }

  public static Matcher notANumber() { 
    return new IsNotANumber(); 
  }
} 
```

In this exercise, you will create matchers for the classes User and Poll to perform the following verifications :

 - `Poll` Matchers 
   - Is the poll a valid opened poll ?
   - Is the poll a valid poll that do not contains a meal ?
   - Is the poll empty (do not contains any choice) ?
   - Is the poll usefull (contains at least 2 choices) ?
- `User` Matchers 
   - Does the user name is ... (use a parameter for your matcher)?
   - Does the user voted for a specific choice (again use a parameter) ?
   - Does the user voted for **more** or **less** than a given number of choices ?
     - For this one the goal is to have a different Matcher initialisation (see [Is Matcher](https://github.com/hamcrest/JavaHamcrest/blob/master/hamcrest/src/main/java/org/hamcrest/core/Is.java))

Copy the test of the following methods and modify them to use the matchers :

 - ExportResource::retrieveUsers()
 - UserResource::getAllUserFromPoll()
 - PollResourceEx::updatePoll()
 - NewPollResourceEx::updatePoll()

**The answers to those question should be answered in the [report](../report.md)**