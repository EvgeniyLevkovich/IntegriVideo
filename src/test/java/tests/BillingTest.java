package tests;

import models.User;
import org.testng.annotations.Test;
import utils.Retry;

public class BillingTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void addCart() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login
                .openPage()
                .login(user)
                .isLoginValid();
        billing
                .openPage()
                .addNewCard("4242 4242 4242 4242", "10", "2021", "JACK DANIELS");
    }

    @Test(retryAnalyzer = Retry.class)
    public void makeCardDefault() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login
                .openPage()
                .login(user)
                .isLoginValid();
        billing
                .openPage()
                .makeDefault(1);
    }

    @Test(retryAnalyzer = Retry.class)
    public void removeCard() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login
                .openPage()
                .login(user)
                .isLoginValid();
        billing
                .openPage()
                .removeCard(1);
    }
}
