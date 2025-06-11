# Testing Login Page
**Login Page Tested:** https://the-internet.herokuapp.com/login
## Manual Testing
### Methods
**1. Decision table**  

   | Rule         | Rule-1  | Rule-2 | Rule-3 | Rule-4 |
   | :----------- | ------- | ------ | ------ | ------ |
   | Username     | True    | True   | False  | False  |
   | Password     | True    | False  | True   | False  |
   | Login status | Success | Fail   | Fail   | Fail   |

**2. Equivalence partitioning:**
- Username or password contain only normal characters
- Username or password contain special characters
- Username or password are empty
- Username or password contain character may cause SQL injection

**3. Boundary value analysis:**  
- Empty string
- String includes 1 character
- String includes 255 characters
- String includes 256 characters

### Test cases
| Field                 | Details                                                                                                                    |
| :-------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| Test case id          | TC-01                                                                                                                      |
| Test case description | Test login with valid username and password                                                                                |
| Preconditions         | 1. User account exist <br>2. The web is working                                                                            |
| Test Data             | Username: tomsmith<br>Password: SuperSecretPassword!                                                                       |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User logs in and the page redirect to dashboard                                                                            |
| Actual results        | User logged in and reached the dashboard                                                                                   |
| Status                | Pass                                                                                                                       |

| Field                 | Details                                                                                                                    |
| :-------------------- |----------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-02                                                                                                                      |
| Test case description | Test login with valid username and invalid password                                                                        |
| Preconditions         | The web is working                                                                                                         |
| Test Data             | Username: tomsmith<br>Password: wrongpassword                                                                              |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message                                                                                 |
| Actual results        | User cannot login and the web shows error message                                                                                 |
| Status                | Pass                                                                                                                       |

| Field                 | Details                                                                                                                    |
| :-------------------- |----------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-03                                                                                                                      |
| Test case description | Test login with invalid username and valid password                                                                        |
| Preconditions         | The web is working                                                                                                         |
| Test Data             | 1. Username: wrongusername<br>2. Password: SuperSecretPassword!                                                            |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows an error message                                                                       |
| Actual results        | User cannot login, the web shows an error message                                                                          |
| Status                | Pass                                                                                                                       |

| Field                 | Details                                                                                                                    |
| :-------------------- |----------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-04                                                                                                                      |
| Test case description | Test login with invalid username and password                                                                              |
| Preconditions         | The web is working                                                                                                         |
| Test Data             | Username: wrongusername<br>Password: wrongpassword                                                                         |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message                                             |
| Actual results        | User cannot login and the web shows error message                                             |
| Status                | Pass                                                                                                                       |

| Field                 | Details                                                                                                                    |
| :-------------------- |----------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-05                                                                                                                      |
| Test case description | Test login with invalid username includes special character                                                                |
| Preconditions         | The web is working                                                                                                         |
| Test Data             | Username: tomsmithϟ<br>Password: SuperSecretPassword!                                                                      |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message                                                                          |
| Actual results        | User cannot login and the web shows error message                                                                          |
| Status                | Pass                                                                                                                       |

| Field                 | Details                                                                                                                    |
| :-------------------- |----------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-06                                                                                                                      |
| Test case description | Test login with invalid password includes special character                                                                |
| Preconditions         | The web is working                                                                                                         |
| Test Data             | Username: tomsmith<br>Password: SuperSecretPassword!ϟ                                                                      |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message                                            |
| Actual results        | User cannot login and the web shows error message                                            |
| Status                | Pass                                                                                                                       |

| Field                 | Details                                                                                                                   |
| :-------------------- |---------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-07                                                                                                                     |
| Test case description | Test login with empty username                                                                                            |
| Preconditions         | The web is working                                                                                                        |
| Test Data             | Password: SuperSecretPassword!                                                                                            |
| Test steps            | 1. Open the login page on browser<br>2. Enter the password into appropriate fields<br>3. Click "Login" button             |
| Expect results        | User cannot login and the web shows error message                                                                         |
| Actual results        | User cannot login and the web shows error message                                                                         |
| Status                | Pass                                                                                                                      |

| Field                 | Details                                                                                                       |
| :-------------------- |---------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-08                                                                                                         |
| Test case description | Test login with empty password                                                                                |
| Preconditions         | The web is working                                                                                            |
| Test Data             | Username: tomsmith                                                                                            |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message                                                             |
| Actual results        | User cannot login and the web shows error message                                                             |
| Status                | Pass                                                                                                          |

| Field                 | Details                                                                               |
| :-------------------- |---------------------------------------------------------------------------------------|
| Test case id          | TC-09                                                                                 |
| Test case description | Test login with SQL injection username                                                |
| Preconditions         | The web is working                                                                    |
| Test Data             | Username: ' or 1=1 --                                                                 |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message       |
| Actual results        | User cannot login and the web shows error message       |
| Status                | Pass                                                                                  |

| Field                 | Details                                                                               |
| :-------------------- |---------------------------------------------------------------------------------------|
| Test case id          | TC-10                                                                                 |
| Test case description | Test login with SQL injection password                                                |
| Preconditions         | The web is working                                                                    |
| Test Data             | Password: ' or 1=1 --                                                                 |
| Test steps            | 1. Open the login page on browser<br>2. Enter the password<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message       |
| Actual results        | User cannot login and the web shows error message       |
| Status                | Pass                                                                                  |

| Field                 | Details                                                                                                                    |
| :-------------------- |----------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-11                                                                                                                      |
| Test case description | Test login with username include 1 character                                                                               |
| Preconditions         | The web is working                                                                                                         |
| Test Data             | Username: a<br>Password: SuperSecretPassword!                                                                              |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message                                                                          |
| Actual results        | User cannot login and the web shows error message                                                                          |
| Status                | Pass                                                                                                                       |

| Field                 | Details                                                                               |
| :-------------------- |---------------------------------------------------------------------------------------|
| Test case id          | TC-12                                                                                 |
| Test case description | Test login with password include 1 character                                          |
| Preconditions         | The web is working                                                                    |
| Test Data             | Username: tomsmith<br>Password: a                                                     |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message                                     |
| Actual results        | User cannot login and the web shows error message                                     |
| Status                | Pass                                                                                  |

| Field                 | Details                                                                               |
| :-------------------- |---------------------------------------------------------------------------------------|
| Test case id          | TC-13                                                                                 |
| Test case description | Test login with username include 255 characters                                       |
| Preconditions         | The web is working                                                                    |
| Test Data             | Username: fD4w1ZqObTPe6K9xMJnL7GvRm0HACyY5EIBtzp3XNUrVWQkagslFhBdcoiuvn2xqYjtmPbDKRhGLTwXeAfVZn7U0yIMgWq1CBokp3dLUvhsrZ9NqTAymcEJF4xBRlOH52SvdgKawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnsXAm2dfw6rM3CZU<br>Password: SuperSecretPassword!                                                     |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button |
| Expect results        | User cannot login and the web shows error message                                     |
| Actual results        | User cannot login and the web shows error message                                     |
| Status                | Pass                                                                                  |

| Field                 | Details                                                                                                                                                                                                                                    |
| :-------------------- |--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-14                                                                                                                                                                                                                                      |
| Test case description | Test login with password include 255 characters                                                                                                                                                                                            |
| Preconditions         | The web is working                                                                                                                                                                                                                         |
| Test Data             | Username: tomsmith<br>Password: fD4w1ZqObTPe6K9xMJnL7GvRm0HACyY5EIBtzp3XNUrVWQkagslFhBdcoiuvn2xqYjtmPbDKRhGLTwXeAfVZn7U0yIMgWq1CBokp3dLUvhsrZ9NqTAymcEJF4xBRlOH52SvdgKawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnsXAm2dfw6rM3CZU |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button                                                                                                                 |
| Expect results        | User cannot login and the web shows error message                                                                                                                                                                                          |
| Actual results        | User cannot login and the web shows error message                                                                                                                                                                                          |
| Status                | Pass                                                                                                                                                                                                                                       |

| Field                 | Details                                                                                                                                                                                                                                                                                                      |
| :-------------------- |--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-15                                                                                                                                                                                                                                                                                                        |
| Test case description | Test login with username include 256 characters                                                                                                                                                                                                                                                              |
| Preconditions         | The web is working                                                                                                                                                                                                                                                                                           |
| Test Data             | Username: afD4w1ZqObTPe6K9xMJnL7GvRm0HACyY5EIBtzp3XNUrVWQkagslFhBdcoiuvn2xqYjtmPbDKRhGLTwXeAfVZn7U0yIMgWq1CBokp3dLUvhsrZ9NqTAymcEJF4xBRlOH52SvdgKawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnsXAm2dfw6rM3CZU<br>Password: SuperSecretPassword! |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button                                                                                                                                                                                   |
| Expect results        | User cannot login and the web shows error message                                                                                                                                                                                                                                                            |
| Actual results        | User cannot login and the web shows error message                                                                                                                                                                                                                                                            |
| Status                | Pass                                                                                                                                                                                                                                                                                                         |


| Field                 | Details                                                                                                                                                                                                                                                                                          |
| :-------------------- |--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Test case id          | TC-16                                                                                                                                                                                                                                                                                            |
| Test case description | Test login with password include 256 characters                                                                                                                                                                                                                                                  |
| Preconditions         | The web is working                                                                                                                                                                                                                                                                               |
| Test Data             | Username: tomsmith<br>Password: afD4w1ZqObTPe6K9xMJnL7GvRm0HACyY5EIBtzp3XNUrVWQkagslFhBdcoiuvn2xqYjtmPbDKRhGLTwXeAfVZn7U0yIMgWq1CBokp3dLUvhsrZ9NqTAymcEJF4xBRlOH52SvdgKawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnawtxzQYV7Moj1KnUb3eHplrCDNGfA5XqZMu0gTLc9iPWRvJKyhOBnsXAm2dfw6rM3CZU |
| Test steps            | 1. Open the login page on browser<br>2. Enter the username and password into appropriate fields<br>3. Click "Login" button                                                                                                                                                                       |
| Expect results        | User cannot login and the web shows error message                                                                                                                                                                                                                                                |
| Actual results        | User cannot login and the web shows error message                                                                                                                                                                                                                                                |
| Status                | Pass                                                                                                                                                                                                                                                                                             |

## Automated testing
The test cases will be implemented to run automatically based on test cases above.