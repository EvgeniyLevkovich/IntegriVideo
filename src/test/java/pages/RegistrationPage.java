package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class RegistrationPage extends BasePage {
    private static final String URL = "https://dev.integrivideo.com/signup";
    private static final By LOGOUT_BUTTON = By.partialLinkText("logout");
    private static final By EMAIL_FIELD = By.name("email");
    private static final By PASWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");


    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public void logout() {
        driver.get(URL);
        driver.findElement(LOGOUT_BUTTON).click();
    }
    public void openRegistrationPage() {
        driver.get(URL);
    }
    public void  setRegistrationData (String email, String password) {
        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void checkNotificationMessage() {
        WebElement notifiction = driver.findElement(By.xpath("//*[text()='Message with instructions was sent']"));
        assertTrue(notifiction.isDisplayed());
    }
}
