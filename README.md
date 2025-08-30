# API Test Automation with Java, RestAssured & Cucumber

This project demonstrates API testing using **Cucumber BDD framework**, **RestAssured**, and **Java** to test the reqres.in REST API endpoints.

## 📌 Prerequisites

Before running the tests, ensure you have the following installed:

- **Java 11** or higher
- **Maven 3.6+**
- **Git** (for cloning the repository)
- **Internet connection** (tests call <https://reqres.in/> API)

### Verify Java Installation
```bash
java -version
# Should show Java 11 or higher
```

### Verify Maven Installation
```bash
mvn -version
# Should show Maven 3.6 or higher
```

## � Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/guramiivanidze/GherkinApiTest.git
cd GherkinApiTest
```

### 2. Navigate to Project Directory
```bash
cd gherkin-api-test
```

### 3. Install Dependencies
```bash
mvn clean install
```

## �📂 Project Structure

```
gherkin-api-test/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/
│   │           └── App.java
│   └── test/
│       ├── java/
│       │   └── com/example/
│       │       ├── runners/
│       │       │   └── TestRunner.java          # Cucumber test runner
│       │       ├── steps/
│       │       │   └── UserSteps.java           # Step definitions
│       │       └── utils/
│       └── resources/
│           └── features/
│               └── user.feature                 # Gherkin feature file
├── target/                                      # Generated reports and artifacts
├── pom.xml                                      # Maven configuration
└── README.md
```

## 🧪 Test Scenarios

The test suite covers the following API operations:

1. **Create User** - POST `/api/users`
2. **Get Users List** - GET `/api/users?page=2`
3. **Update User** - PUT `/api/users/{id}`
4. **Delete User** - DELETE `/api/users/{id}`

## 🏃‍♂️ Running Tests

### Run All Tests
```bash
mvn clean test
```

### Run Tests with Detailed Output
```bash
mvn clean test -Dcucumber.options="--plugin pretty"
```

### Run Tests and Generate Reports
```bash
mvn clean test
# HTML reports will be generated in: target/cucumber-reports.html
```

## 📊 Test Reports

After running tests, you can find reports in:

- **Cucumber HTML Report**: `target/cucumber-reports.html`
- **Surefire Reports**: `target/surefire-reports/`
- **Console Output**: Real-time test execution details

### View HTML Report
```bash
open target/cucumber-reports.html
# On macOS

# On Linux
xdg-open target/cucumber-reports.html

# On Windows
start target/cucumber-reports.html
```

## 🔧 Configuration

### API Configuration
- **Base URL**: `https://reqres.in/api`
- **API Key**: `reqres-free-v1` (already configured)
- **Content Type**: `application/json`

### Maven Dependencies
- **Cucumber Java**: 7.18.0
- **Cucumber JUnit**: 7.18.0
- **RestAssured**: 5.4.0
- **JUnit**: 4.13.2
- **JSON**: 20240303

## 🛠️ Development

### Adding New Test Scenarios

1. **Add Feature**: Create or modify `.feature` files in `src/test/resources/features/`
2. **Implement Steps**: Add step definitions in `src/test/java/com/example/steps/`
3. **Run Tests**: Execute `mvn clean test` to verify

### Example Feature File
```gherkin
Feature: User API Testing
  
  Scenario: Create a new user
    Given I set POST endpoint for user
    When I send POST request with name "John" and job "QA"
    Then I receive valid status code 201
    And Response should contain name "John" and job "QA"
```

### Example Step Definition
```java
@When("I send POST request with name {string} and job {string}")
public void i_send_post_request(String name, String job) {
    response = given()
            .header("Content-Type", "application/json")
            .header("x-api-key", apiKey)
            .body("{\"name\":\"" + name + "\", \"job\":\"" + job + "\"}")
            .when()
            .post(endpoint);
}
```

## � Troubleshooting

### Common Issues

1. **Java Version Error**
   ```bash
   # Check Java version
   java -version
   # Install Java 11 if needed
   ```

2. **Maven Build Fails**
   ```bash
   # Clear Maven cache
   mvn clean
   # Reinstall dependencies
   mvn install
   ```

3. **Network Issues**
   ```bash
   # Test API connectivity
   curl https://reqres.in/api/users?page=2
   ```

4. **Test Failures**
   - Check internet connection
   - Verify API endpoints are accessible
   - Review test reports in `target/surefire-reports/`

### Debug Mode
```bash
# Run with debug information
mvn clean test -X
```

## 📝 Sample Test Output

```
Scenario: Create a new user
  Given I set POST endpoint for user                     ✓
  When I send POST request with name "John" and job "QA" ✓
  Then I receive valid status code 201                   ✓
  And Response should contain name "John" and job "QA"   ✓

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
BUILD SUCCESS
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Add your tests
4. Run the test suite
5. Submit a pull request

## 📄 License

This project is for educational and testing purposes.

---

**Happy Testing!** 🚀
