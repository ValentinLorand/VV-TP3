# Mock data to do unit testing

When doing unit testing, a usual problem is the dependencies between function. If a function `A()` call a function `B()`, the unit tests of `A()` might fail because of errors in `B()`. However, unit testing is about testing is about looking if `A()` works inependently of `B()` (which is tested on it's own).

In order to avoid such problems testing frameworks like mockito offer the ability to **mock** the result of function calls allowing to test for different return values of those function.

A common use of **Mocks** consist in mocking the DTO object returned by database access.
In this exercise, you will mock the access to the Doodle backend database (mock the *Repository classes' methods) to create unit tests for the following methods :

 - UserResource::getAllUserFromPoll()
 - pollRepository::retrievePoll()
 - ICSResources::parseCalendartoAppointments()
 - PollResourceEx::updatePoll()
 - NewPollResourceEx::updatePoll()

Comment your test suites to explain the choice of test cases selected.

Did you find bugs ?

**The answers to those question should be answered in the [report](../report.md)**