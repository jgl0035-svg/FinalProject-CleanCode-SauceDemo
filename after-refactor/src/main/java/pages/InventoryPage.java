// Clean version: no switch, no long XPath, clear methods.

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Good: clear, single-responsibility methods
    public void addBackpackToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void addBikeLightToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    public int getCartCount() {
        // Good: no try/catch swallowing exceptions
        String count = driver.findElement(By.className("shopping_cart_badge")).getText();
        return Integer.parseInt(count);
    }
}
