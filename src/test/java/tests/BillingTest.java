package tests;

import models.User;
import org.testng.annotations.Test;
import pages.BillingPage;
import pages.LoginPage;

public class BillingTest extends BaseTest {

    LoginPage login;
    BillingPage billing;

    @Test
    public void addCart() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login = new LoginPage(driver)
                .openPage()
                .login(user)
                .isLoginValid();
        billing = new BillingPage(driver)
                .openPage()
                .addNewCard("4242 4242 4242 4242", "10", "2021", "JACK DANIELS");
    }
    @Test
    public void makeCardDefault() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login = new LoginPage(driver)
                .openPage()
                .login(user)
                .isLoginValid();
        billing = new BillingPage(driver)
                .openPage()
                .makeDefault(3);
    }
    @Test
    public void removeCard() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login = new LoginPage(driver)
                .openPage()
                .login(user)
                .isLoginValid();
        billing = new BillingPage(driver)
                .openPage()
                .removeCard(1);
    }
}
