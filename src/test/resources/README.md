# Test Resources

This directory contains configuration files and test data for the RestAssured API tests.

## Directory Structure

```
src/test/resources/
├── config/
│   └── test.properties          # Test environment configuration
├── test-data/
│   ├── login-request.json       # Sample login request payload
│   ├── login-response.json      # Sample login response
│   └── products-response.json   # Sample products API response
├── testng.xml                   # TestNG test suite configuration
├── logback.xml                  # Logging configuration
└── README.md                    # This file
```

## Configuration Files

### test.properties
Contains environment-specific configuration:
- API base URLs
- Test credentials
- Timeout settings
- Logging configuration

**Usage:**
```java
Properties props = new Properties();
props.load(new FileInputStream("src/test/resources/config/test.properties"));
String baseUrl = props.getProperty("api.base.url");
```

### testng.xml
TestNG suite configuration file that defines:
- Test groups
- Test classes to execute
- Execution order
- Parallel execution settings

**Run tests with testng.xml:**
```bash
mvn test
# or
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

## Test Data Files

JSON files in `test-data/` folder can be:
- Used as request payloads
- Used for assertion validation
- Read and modified in tests

**Usage Example:**
```java
String loginPayload = new String(Files.readAllBytes(
    Paths.get("src/test/resources/test-data/login-request.json")));
```

## Logging Configuration

### logback.xml
Configures logging output:
- Console appender for real-time logs
- File appender with rolling policies
- Log levels per package

**Logs are written to:** `logs/test-execution.log`

## Adding New Resources

1. **Test Data:** Add JSON/XML files to `test-data/`
2. **Configuration:** Update `config/test.properties` for new settings
3. **Test Suites:** Modify `testng.xml` to include new test classes
