import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.InventoryPage;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void anadirUnProductoAlCarrito() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Thread.sleep(1000);

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addProduct("Sauce Labs Backpack");
        Thread.sleep(1000);

        assertEquals(1, inventory.getCartCount());
    }

    @Test
    void anadirDosProductosAlCarrito() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Thread.sleep(1000);

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addProduct("Sauce Labs Backpack");
        inventory.addProduct("Sauce Labs Bike Light");
        Thread.sleep(1000);

        assertEquals(2, inventory.getCartCount());
    }

    @Test
    void botonCambiaTrasAnadirProducto() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        Thread.sleep(1000);

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addProduct("Sauce Labs Backpack");
        Thread.sleep(1000);

        WebElement button = driver.findElement(
                By.xpath("//div[text()='Sauce Labs Backpack']/following::button[1]")
        );

        assertEquals("Remove", button.getText());
    }
}
