package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import static org.testng.Assert.*;

public class BillingPage extends BasePage {

    private static final By BILLING_BUTTON = By.xpath("//a[contains(text(), 'Billing')]");
    private static final By ADD_NEW_METHODS_BUTTON = By.xpath("//a[contains(text(), 'Add new')]");
    private static final By CARD_NUMBER = By.name("number");
    private static final By MONTH = By.name("expirationMonth");
    private static final By YEAR = By.name("expirationYear");
    private static final By CARDHOLDER_NAME = By.name("cardholderName");
    private static final By ADD_CARD = By.cssSelector("form button");
    private static final By CARD_QUANTITY = By.cssSelector(".cards .row");
    private static final By MAKE_DEFAULT_LINK = By.cssSelector(".cards .row .col-md-3");
    private static final By DEFAULT_METHOD_CHANGED_NOTIFICATION = (By.xpath("//*[text()='Default payment method successfully changed']"));
    private static final By REMOVE_CARD_LINK = By.xpath("//a[text() = 'Remove']");
    private static final By REMOVE_CARD_NOTIFICATION = (By.xpath("//*[text()='Payment method successfully removed']"));


    public BillingPage(WebDriver driver) {
        super(driver);
    }
    public BillingPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_NEW_METHODS_BUTTON));
        return this;
    }
    public BillingPage openPage() {
        driver.findElement(BILLING_BUTTON).click();
        isPageOpened();
        return this;
    }
    public BillingPage addNewCard(String CardNumber, String month, String year, String CardholderName) {
        List<WebElement> cardsBeforeAdding = driver.findElements(CARD_QUANTITY);
        driver.findElement(ADD_NEW_METHODS_BUTTON).click();
        driver.findElement(CARD_NUMBER).sendKeys(CardNumber);
        driver.findElement(MONTH).sendKeys(month);
        driver.findElement(YEAR).sendKeys(year);
        driver.findElement(CARDHOLDER_NAME).sendKeys(CardholderName);
        wait.until(ExpectedConditions.elementToBeClickable(ADD_CARD)).click();
        List<WebElement> cardsAfterAdding = driver.findElements(CARD_QUANTITY);
        assertEquals(cardsBeforeAdding.size(), cardsAfterAdding.size() - 1, "The new card isn't added" );
        return this;
    }
    public BillingPage makeDefault(int cardNumber) {
        List<WebElement> makeDefaultLink = driver.findElements(MAKE_DEFAULT_LINK);
        assertTrue(makeDefaultLink.size() >= cardNumber, "The card isn't exists");
        assertNotEquals(makeDefaultLink.get(cardNumber - 1).getText(), "Default", "The card is already selected as default");
        makeDefaultLink.get(cardNumber - 1).click();
        assertTrue(driver.findElement(DEFAULT_METHOD_CHANGED_NOTIFICATION).isDisplayed());
        return this;
    }
    public BillingPage removeCard(int cardNumber) {
        List<WebElement> removeCardLink = driver.findElements(REMOVE_CARD_LINK);
        assertTrue(removeCardLink.size() >= cardNumber, "The card isn't exists");
        removeCardLink.get(cardNumber - 1).click();
        assertTrue(driver.findElement(REMOVE_CARD_NOTIFICATION).isDisplayed(), "The card isn't removed");
        return this;
    }
}
