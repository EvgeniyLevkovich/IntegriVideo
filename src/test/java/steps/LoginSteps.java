package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    LoginPage login;

    public LoginSteps(WebDriver driver) {
        login = new LoginPage(driver);
    }

    @Step("Login by user {email}")
    public void login(User user) {
        login
                .openPage()
                .login(user)
                .isLoginValid();
    }
}
