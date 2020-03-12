package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    private static final String URL = "https://dev.integrivideo.com/login";

    @FindBy(name = "email")
    WebElement emailField;
    @FindBy(name = "password")
    WebElement passwordField;
    @FindBy(css = ".btn-primary")
    WebElement loginButton;
    @FindBy(css = ".iv-icon-exit-right")
    WebElement logioutButton;

    /*private static final By EMAIL = By.name("email");
    private static final By PASSWORD = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");
    private static final By LOGOUT_BUTTON = By.cssSelector("a.btn[href='/logout']");
     */

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }
    public LoginPage openPage() {
        driver.get(URL);
        isPageOpened();
        return this;
    }
    public LoginPage login(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
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
        logioutButton.click();
        assertEquals(driver.getCurrentUrl(), "https://dev.integrivideo.com/", "Logout isn't successful");
        return this;
    }
}
