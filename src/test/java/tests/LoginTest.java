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
            .openPage()
            .setRegistrationData(UUID.randomUUID().toString() + "@mailinator.com", System.getProperty("password"))
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
            .notificatonCheck("Error: Password is incorrect");
    }
    @Test
    public void invalidLogin() {
        User user = new User("integriqwerty@mailinator.com", "qwerty12345");
        login = new LoginPage(driver)
            .openPage()
            .login(user)
            .notificatonCheck("Error: User is not found");
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
