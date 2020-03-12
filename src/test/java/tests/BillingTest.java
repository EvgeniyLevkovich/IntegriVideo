package tests;

import org.testng.annotations.Test;
import pages.BillingPage;
import pages.LoginPage;

public class BillingTest extends BaseTest {

    LoginPage login;
    BillingPage billing;

    @Test
    public void addCart() {
        login = new LoginPage(driver)
                .openPage()
                .login("integri@mailinator.com", "qwerty12345")
                .isLoginValid();
        billing = new BillingPage(driver)
                .openBillingPage()
                .addNewCard("4242 4242 4242 4242", "10", "2021", "JACK DANIELS");
    }
    @Test
    public void makeCardDefault() {
        login = new LoginPage(driver)
                .openPage()
                .login("integri@mailinator.com", "qwerty12345")
                .isLoginValid();
        billing = new BillingPage(driver)
                .openBillingPage()
                .makeDefault(1);
    }
    @Test
    public void removeCard() {
        login = new LoginPage(driver)
                .openPage()
                .login("integri@mailinator.com", "qwerty12345")
                .isLoginValid();
        billing = new BillingPage(driver)
                .openBillingPage()
                .removeCard(1);
    }
}
