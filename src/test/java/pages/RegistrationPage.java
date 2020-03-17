package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertTrue;

public class RegistrationPage extends BasePage {
    private static final String URL = "https://dev.integrivideo.com/signup";
    private static final By EMAIL_FIELD = By.name("email");
    private static final By PASWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");
    private static final By NOTIFICATION_MESSAGE = By.xpath("//*[text()='Message with instructions was sent']");

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public RegistrationPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON ));
        return this;
    }
    public RegistrationPage openPage() {
        driver.get(URL);
        isPageOpened();
        return this;
    }
    public RegistrationPage  setRegistrationData (String email, String password) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
    public RegistrationPage checkNotificationMessage() {
        WebElement notification = driver.findElement(NOTIFICATION_MESSAGE);
        assertTrue(notification.isDisplayed());
        return this;
    }
}
