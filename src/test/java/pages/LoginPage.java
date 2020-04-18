package pages;

import io.qameta.allure.Step;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.AllureUtils;

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
    WebElement logoutButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }
    @Step("Opening page")
    public LoginPage openPage() {
        driver.get(URL);
        isPageOpened();
        AllureUtils.takeScreenshot(driver);
        return this;
    }
    @Step("Login")
    public LoginPage login(User user) {
        emailField.sendKeys(user.getEmail());
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
        return this;
    }

    public LoginPage isLoginValid() {
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://dev.integrivideo.com/app/projects", currentUrl, "Login isn't successful");
        return this;
    }
    public LoginPage notificatonCheck(String notificaton) {
        assertTrue(driver.findElement(By.xpath("//*[text()='" + notificaton + "']")).isDisplayed(), "Notification isn't displayed");
        return this;
    }
    public LoginPage logout() {
        driver.get(URL);
        logoutButton.click();
        assertEquals(driver.getCurrentUrl(), "https://dev.integrivideo.com/", "Logout isn't successful");
        return this;
    }
}

