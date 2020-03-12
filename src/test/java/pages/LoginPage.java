package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    private static final String URL = "https://dev.integrivideo.com/login";
    private static final By EMAIL = By.name("email");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");
    private static final By LOGOUT_BUTTON = By.cssSelector("a.btn[href='/logout']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage openPage() {
        driver.get(URL);
        return this;
    }
    public LoginPage login(String email, String password) {
        driver.findElement(EMAIL).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
    public LoginPage isLoginValid() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://dev.integrivideo.com/app/projects", currentUrl, "Logim isn't successful");
        return this;
    }
    public LoginPage isPasswordInvalid() {
        WebElement notification = driver.findElement(By.xpath("//*[text()='Error: Password is incorrect']"));
        assertTrue(notification.isDisplayed(), "Notification isn't displayed");
        return this;
    }
    public LoginPage isUserNotFound() {
        WebElement notification = driver.findElement(By.xpath("//*[text()='Error: User is not found']"));
        assertTrue(notification.isDisplayed(), "Notification isn't displayed");
        return this;
    }
    public LoginPage logout() {
        driver.get(URL);
        driver.findElement(LOGOUT_BUTTON).click();
        assertEquals(driver.getCurrentUrl(), "https://dev.integrivideo.com/", "Logout isn't successful");
        return this;
    }
}

