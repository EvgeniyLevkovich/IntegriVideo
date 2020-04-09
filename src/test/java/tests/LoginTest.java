package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.Retry;
import java.util.UUID;

public class LoginTest extends BaseTest{

    @Test(retryAnalyzer = Retry.class, enabled = false)
    public void registration() {
        registration
            .openPage()
            .setRegistrationData(UUID.randomUUID().toString() + "@mailinator.com", System.getProperty("password"))
            .checkNotificationMessage();
    }

    @Test(retryAnalyzer = Retry.class, description = "Login")
    @Description("Login by using valid data")
    public void validLogin() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        loginSteps.login(user);
    }

    @Test(retryAnalyzer = Retry.class)
    public void invalidPassword() {
        User user = new User("integri@mailinator.com", "qwerty1234512345");
        login
            .openPage()
            .login(user)
            .notificatonCheck("Error: Password is incorrect");
    }

    @Test(retryAnalyzer = Retry.class)
    public void invalidLogin() {
        User user = new User("integriqwerty@mailinator.com", "qwerty12345");
        login
            .openPage()
            .login(user)
            .notificatonCheck("Error: User is not found");
    }

    @Test(retryAnalyzer = Retry.class)
    public void logout() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login
            .openPage()
            .login(user)
            .isLoginValid()
            .logout();
    }
}
