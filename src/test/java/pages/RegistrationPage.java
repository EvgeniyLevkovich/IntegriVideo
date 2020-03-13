package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertTrue;

public class RegistrationPage extends BasePage {
    private static final String URL = "https://dev.integrivideo.com/signup";
    private static final By EMAIL_FIELD = By.name("email");
    private static final By PASWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public RegistrationPage isPageOpened() {
        return this;
    }
    @Override
    public RegistrationPage openPage() {
        return this;
    }
    public RegistrationPage openRegistrationPage() {
        driver.get(URL);
        return this;
    }
    public RegistrationPage  setRegistrationData (String email, String password) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }
    public RegistrationPage checkNotificationMessage() {
        WebElement notifiction = driver.findElement(By.xpath("//*[text()='Message with instructions was sent']"));
        assertTrue(notifiction.isDisplayed());
        return this;
    }
}
