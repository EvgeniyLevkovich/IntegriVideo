package tests;

import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import java.util.UUID;

public class LoginTest extends BaseTest{
    RegistrationPage registration;
    LoginPage login;

    @Test
    public void registration() {
        registration = new RegistrationPage(driver)
            .openRegistrationPage()
            .setRegistrationData(UUID.randomUUID().toString() + "@mailinator.com", "12345678")
            .checkNotificationMessage();
    }
    @Test
    public void validLogin() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login = new LoginPage(driver)
            .openPage()
            .login(user)
            .isLoginValid();
    }
    @Test
    public void invalidPassword() {
        User user = new User("integri@mailinator.com", "qwerty1234512345");
        login = new LoginPage(driver)
            .openPage()
            .login(user)
            .isPasswordInvalid();
    }
    @Test
    public void userIsNotFound() {
        User user = new User("integriqwerty@mailinator.com", "qwerty12345");
        login = new LoginPage(driver)
            .openPage()
            .login(user)
            .isUserNotFound();
    }
    @Test
    public void logout() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login = new LoginPage(driver)
            .openPage()
            .login(user)
            .isLoginValid()
            .logout();
    }
}
