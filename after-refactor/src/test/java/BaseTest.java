// BaseTest.java
// This class centralizes WebDriver setup and teardown.
// It removes duplicated code from all test classes.

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        // Good: single place to configure WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        // Good: single place to quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
