This project automates test cases for the [Automation Exercise](https://automationexercise.com/) website using Selenium, TestNG, and Maven. It includes data-driven testing, suite execution, parallel testing, and generates detailed Allure reports via both Command Line and TestNG runner.

---

## Project Structure

```

Web\_Automation\_Selenium\_TestNG/
│
├── pages/                     # Page Object Model classes
│   ├── BasePage.java
│   ├── HomePage.java
│   └── LoginPage.java
│
├── testcases/                # Test case classes
│   ├── TestHomePage.java
│   └── TestLoginPage.java
│
├── utilities/                # Utility files
│   ├── DataSet.java          # Data-driven input for login tests
│   └── DriverSetup.java      # WebDriver initialization
│
├── testng.xml                # TestNG suite file for running tests
├── pom.xml                   # Maven configuration file
└── README.md

````

---

## Technologies Used

- **Java**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Allure Reporting**

---

## Features

- **Page Object Model** design pattern
- **Data-Driven Testing** for login with multiple inputs
- **Suite File (`testng.xml`)** to manage and organize test execution
- **Parallel Test Execution** using TestNG
- **Allure Reports** generated through both:
    - Command Line (`mvn test`)
    - TestNG runner integration

---

## How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/AdritaAlam/Web_Automation_Selenium_TestNG.git
````

### 2. Run Tests via Maven

```bash
mvn test
```

To run on other than default browser
```bash
mvn test -Dbrowser="browsername"
```

This will execute the tests based on the configuration provided in `testng.xml`.

---

## Allure Report Generation

### Option 1: Using Command Line

1. Run tests:

   ```bash
   mvn test
   ```

2. Generate the Allure report:

   ```bash
   allure generate .\allure-results\ --clean
   ```

3. Open Allure report
   ```bash
   allure open .\allure-report
   ```
   
## To Run suite file
 ```bash
   mvn test -Dsuitefile="suitefilename"
   ```

---

## Parallel Test Execution

Parallel execution is handled in the `testng.xml` file using the following config:

```xml
<test verbose="2" preserve-order="true" parallel="true"   ......></test>
```

This runs multiple tests in parallel to reduce execution time.

---

## Example Test Scenario

* **Home Page** – Validate UI elements and navigation
* **Login Page** – Perform login tests using valid/invalid credentials from a data provider

---


