package tests;

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
        login = new LoginPage(driver)
            .openPage()
            .login("integri@mailinator.com", "qwerty12345")
            .isLoginValid();
    }
    @Test
    public void invalidPassword() {
        login = new LoginPage(driver)
            .openPage()
            .login("integri@mailinator.com", "qwerty1234512345")
            .isPasswordInvalid();
    }
    @Test
    public void userIsNotFound() {
        login = new LoginPage(driver)
            .openPage()
            .login("integriqwerty@mailinator.com", "qwerty12345")
            .isUserNotFound();
    }
    @Test
    public void logout() {
        login = new LoginPage(driver)
            .openPage()
            .login("integri@mailinator.com", "qwerty12345")
            .isLoginValid()
            .logout();
    }
}
