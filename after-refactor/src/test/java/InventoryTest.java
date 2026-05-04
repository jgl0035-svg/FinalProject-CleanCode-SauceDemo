// Clean version: no sleeps, no duplicated login, clear product methods.

import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest extends BaseTest {

    @Test
    void addOneProductToCart() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();

        assertEquals(1, inventory.getCartCount());
    }

    @Test
    void addTwoProductsToCart() {
        LoginPage login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpackToCart();
        inventory.addBikeLightToCart();

        assertEquals(2, inventory.getCartCount());
    }
}
