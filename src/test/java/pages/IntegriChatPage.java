package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class IntegriChatPage extends  BasePage {
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final By MESSAGE_TEXT_AREA = By.cssSelector("[placeholder='Start typing here']");
    private static final By SEND_BUTTON = By.cssSelector("[title='Send message']");
    private static final By RECEIVED_MESSAGE = By.cssSelector(".integri-chat-message-text");
    private static final By TRIAL_VERSION = By.cssSelector(".integri-demo-version");
    private static final By EDIT_MESSAGE_BUTTON = By.cssSelector(".integri-chat-edit-message");
    private static final By EDIT_MESSAGE_TEXT_AREA = By.cssSelector(".integri-chat-message textarea");
    private static final By ERROR_EMPTY_EDITED_MESSAGE = By.cssSelector(".integri-notify-error");
    private static final By INVITE_Button = By.id("invite-users-to-chat");
    private static final By CODE = By.cssSelector(".component-code");


    public IntegriChatPage(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
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
            wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(".integri-chat-message-container"), i + 1));
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
    public void getInviteLink() {
        driver.findElement(INVITE_Button).click();
    }
    public void checkInviteLink() throws IOException, UnsupportedFlavorException {
        String currentURL = driver.getCurrentUrl();
        String invitationURL = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Assert.assertEquals(currentURL, invitationURL);
    }
    public void getCode() {
        driver.findElement(CODE).click();
    }
    public void checkCode() throws IOException, UnsupportedFlavorException {
        String code = driver.findElement(CODE).getText();
        String editedCode = code.replaceAll("\n", "");
        String copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Assert.assertEquals(copiedText, editedCode);
    }
    public String generatelongMessage(int lenght) {
        String message = "";
        for (int i = 0; i < lenght; i++) {
            int symbol = (int) (Math.random() * 10);
            String str = Integer.toString(symbol);
            message = message + str;
        }
        return message;
    }
}
