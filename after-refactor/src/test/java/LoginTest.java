// Clean version: no Thread.sleep, no duplicated setup, uses BaseTest.

import org.junit.jupiter.api.Test;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    void correctLogin() {
        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        // Good: simple assertion
        assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test
    void incorrectLogin() {
        LoginPage login = new LoginPage(driver);

        login.enterUsername("standard_user");
        login.enterPassword("wrong_pass");
        login.clickLogin();

        // Good: using page method instead of raw DOM access
        assertTrue(login.isErrorVisible());
    }
}
