package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProduct(String productName) {
        driver.findElement(By.xpath("//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button")).click();
    }


    public int getCartCount() {
        try {
            String count = driver.findElement(By.className("shopping_cart_badge")).getText();
            return Integer.parseInt(count);
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean comprobarTexto(String texto) {
        return driver.getPageSource().contains(texto);
    }
}

