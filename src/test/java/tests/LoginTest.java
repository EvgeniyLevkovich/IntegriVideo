package tests;

import org.testng.annotations.Test;
import pages.RegistrationPage;

import java.util.UUID;

public class LoginTest extends BaseTest{
    RegistrationPage login;

    @Test
    public void registrationTest() {
        login = new RegistrationPage(driver);
        login.openRegistrationPage();
        login.setRegistrationData(UUID.randomUUID().toString() + "@mailinator.com", "12345678");
        login.checkNotificationMessage();
    }
    @Test
    public void loginTest() {

    }

}
