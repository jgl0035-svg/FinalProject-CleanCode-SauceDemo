import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void loginCorrecto() throws InterruptedException {
        LoginPage login = new LoginPage(driver);

        Thread.sleep(1500);
        login.login("standard_user", "secret_sauce");

        Thread.sleep(2000);
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    void loginIncorrecto() throws InterruptedException {
        LoginPage login = new LoginPage(driver);

        Thread.sleep(1500);
        login.ingresarUsuario("standard_user");

        Thread.sleep(1500);
        login.ingresarPassword("mal_pass");

        Thread.sleep(1500);
        login.clickLogin();

        Thread.sleep(2000);
        WebElement errorMsg = driver.findElement(By.cssSelector("[data-test='error']"));

        assertTrue(errorMsg.isDisplayed());
    }
}

