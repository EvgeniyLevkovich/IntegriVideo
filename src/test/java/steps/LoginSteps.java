package steps;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Login using valid username and password")
    public void login(User user) {
        loginPage
                .openPage()
                .login(user)
                .isLoginValid();
    }
    @Step("Login using incorrect password")
    public void invalidPasswordLogin(User user, String notification) {
        loginPage
                .openPage()
                .login(user)
                .notificatonCheck(notification);
    }

    @Step("Login using incorrect username")
    public void invalidUserLogin(User user, String notification) {
        loginPage
                .openPage()
                .login(user)
                .notificatonCheck(notification);
    }
    @Step("Logout")
    public void logout (User user) {
        login(user);
        loginPage.logout();
    }
}
