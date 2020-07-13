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
    @Description("Login using valid credentials")
    public void validLogin() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        loginSteps.login(user);
    }

    @Test(retryAnalyzer = Retry.class, description = "Incorrect password")
    @Description("Login using invalid password")
    public void invalidPassword() {
        User user = new User("integri@mailinator.com", "qwerty1234512345");
        loginSteps.invalidPasswordLogin(user, "Error: Password is incorrect");
    }

    @Test(retryAnalyzer = Retry.class, description = "Incorrect username")
    @Description("Login using invalid username")
    public void invalidLogin() {
        User user = new User("integriqwerty@mailinator.com", "qwerty12345");
        loginSteps.invalidUserLogin(user, "Error: User is not found");
    }

    @Test(retryAnalyzer = Retry.class, description = "Logout")
    @Description("Logout test")
    public void logout() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        loginSteps.logout(user);
    }
}
