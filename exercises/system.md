# Test your REST API using SoapUI

Now that the Doodle backend has unit tests, we want to test the REST API as a whole to verify that it meets the specification. This phase of system testing will be done using SoapUI

SoapUI is a testing tool for micro-services, the main functionalities are, first, the ability to mock a micro-service like Mockito but at the network level, and second to regroup REST API request in order to test multiple requests on one end-point of the API or create scenarios of chained request on the API.

In this exercise, you will test multiple scenarios corresponding to the lifecycle of a poll.
We suggest you the followings :

 1. First scenario (The simple one)
    - Create a poll with the following specifications
        - No food preference
        - One time slot
    - Create an user that will vote for the only available slot
    - Close the poll

 2. Second scenario (The hungry one)
    - Create a poll with the following specifications
        - With food preference
        - One time slot
    - Create an user that will vote for the only available slot and add food preference
    - Close the poll

 3. Third scenario (The social one)
    - Create a poll with the following specifications
        - No food preference
        - Multiple time slot
    - Create an user for each time slot
    - Make the users comment the poll
    - Close the poll

 4. Fourth scenario (The realistic one)
    - Create a poll with the following specifications
        - With food preference
        - Multiple time slot
    - Create multiple users that will vote for multiple slot (but different from other users)
        - Some of the users must have food preference
    - Make some users comment the poll
    - Close the poll

 Of course you're free to test other scenarios.

 Tips : [Here](https://www.soapui.org/getting-started/rest-testing/) is a tutorial to build REST API tests using SoapUI


 Explain the scenarios you have tested and the results (unexpected errors, security breach, ...) in a dedicated section of the **[report](../report.md)**