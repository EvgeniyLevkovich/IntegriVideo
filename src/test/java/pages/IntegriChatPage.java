package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class IntegriChatPage extends  BasePage {
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final By MESSAGE_TEXT_AREA = By.xpath("//textarea[@placeholder = 'Start typing here']");
    private static final By SEND_BUTTON = By.xpath("//button[@class ='integri-chat-send-message integri-chat-action-button']");
    private static final By RECEIVED_MESSAGE = By.xpath("//div[@class='integri-chat-message-text']");
    private static final By TRIAL_VERSION = By.xpath("//div[@class= 'integri-demo-version']");
    private static final By EDIT_MESSAGE_BUTTON = By.xpath("//span[@class = 'iv-icon iv-icon-pencil integri-chat-edit-message']");
    private static final By EDIT_MESSAGE_TEXT_AREA = By.xpath("//div[@class = 'integri-chat-message ']/textarea");
    private static final By ERROR_EMPTY_EDITED_MESSAGE = By.xpath("//div[@class = 'integri-notify integri-notify-error']");


    public IntegriChatPage(WebDriver driver) {
        super(driver);
    }
    public void openChatPage() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_TEXT_AREA));
    }
    public void typeMessage(String message) {
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
    }
    public void sendMessageByClick() {
        driver.findElement(SEND_BUTTON).click();
    }
    public void checkMessage(String message, int messageNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(RECEIVED_MESSAGE));
        String text = driver.findElements(RECEIVED_MESSAGE).get(messageNumber - 1).getText();
        assertEquals(message, text);
    }
    public void sendMessageByEnter() {
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(Keys.ENTER);
    }
    public void sendManyMessages(int count, String message) {
        for (int i = 0; i < count; i++) {
            driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
            driver.findElement(SEND_BUTTON).click();
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class ='integri-chat-message-container integri-chat-message-own']"), i + 1));
        }
        driver.findElement(MESSAGE_TEXT_AREA).sendKeys(message);
        driver.findElement(SEND_BUTTON).click();
    }
    public void checkForTrialVersion() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TRIAL_VERSION));
        Assert.assertTrue(driver.findElement(TRIAL_VERSION).isDisplayed());
    }
    public void editMessage(String editedMessage) {
        driver.findElement(EDIT_MESSAGE_BUTTON).click();
        WebElement editMessage = driver.findElement(EDIT_MESSAGE_TEXT_AREA);
        editMessage.clear();
        editMessage.sendKeys(editedMessage,Keys.ENTER);
    }
    public void checkForEmptyEditedMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_EMPTY_EDITED_MESSAGE));
        String errorMessage = driver.findElement(ERROR_EMPTY_EDITED_MESSAGE).getText();
        assertEquals(errorMessage, "Message cannot be empty!");
    }

}
