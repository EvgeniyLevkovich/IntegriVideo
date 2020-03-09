package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final String URL = "https://dev.integrivideo.com/login";
    private static final By LOGOUT_BUTTON = By.partialLinkText("logout");



    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void openPage() {}

}
