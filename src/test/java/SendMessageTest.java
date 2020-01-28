import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class SendMessageTest extends WebdriverStart {
    String inputMessageAreaXpath = "//textarea[@placeholder = 'Start typing here']";
    String receivedMessageXPath = "//div[@class ='integri-chat-message-text']";
    String sendMessageButtonXPath = "//button[@class ='integri-chat-send-message integri-chat-action-button']";
    String settingsButtonXPath = "//span[@class ='iv-icon iv-icon-cog']";
    String settingsFormXpath = "//input[@name ='userName']";
    String saveButtonXpath = "//button[@class='integri-user-settings-save integri-button-blue']";
    String uploadButtonXpath = "//span[@class='integri-chat-manual-upload integri-pointer']";

    public void sendMessage(String message) {
        WebElement input = driver.findElement(By.xpath(inputMessageAreaXpath));
        input.sendKeys(message);
        input.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(receivedMessageXPath)));
    }
    public void checkMessage(String message) {
        String recivedMessage = driver.findElement(By.xpath(receivedMessageXPath)).getText();
        assertEquals(recivedMessage, message);
    }
    @Test
    public void sendMessageByClick() {
        String message = "Why are you running?";
        WebElement input = driver.findElement(By.xpath(inputMessageAreaXpath));
        input.sendKeys(message);
        WebElement sendMessageButton = driver.findElement(By.xpath(sendMessageButtonXPath));
        sendMessageButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(receivedMessageXPath)));
        String recivedMessage = driver.findElement(By.xpath(receivedMessageXPath)).getText();
        assertEquals(recivedMessage, message);
    }
    @Test
    public void sendMessageByEnter() {
        String message = "Why are you running?";
        sendMessage(message);
        checkMessage(message);
    }
    @Test
    public void sendLongMessage() {
        String message = "Etiam sit amet lectus ac tortor fringilla maximus eget vitae orci. Vestibulum nisl sapien, semper id malesuada ac, euismod ac quam. Nunc facilisis nunc tortor, sit amet convallis velit pharetra in. Praesent a massa a justo pharetra vulputate. Morbi ultricies iaculis hendrerit. Nulla sit amet tempor turpis. Vestibulum posuere vitae sapien in venenatis. Morbi non risus neque Suspendisse potenti. In interdum pretium nulla, ut molestie felis sodales nec. Pellentesque in pulvinar nulla, quis consequat nisi. Suspendisse sed risus non quam laoreet fringilla. Cras sit amet dictum lectus, a accumsan ex. Aliquam quis risus at mauris tincidunt efficitur vitae eget tellus. Sed vitae tempor ipsum. Quisque viverra nulla purus, pretium blandit ex sollicitudin non. Nam blandit nibh arcu, quis euismod leo malesuada ut. Fusce ultricies venenatis nibh at scelerisque. Aliquam elementum mi eu dolor rutrum finibus. Donec nec dolor sed massa malesuada bibendum. Pellentesque nisl sapien, tempor eu tellus ut, tristique suscipit magna. Donec non sollicitudin leo. Fusce vitae viverra magna. Praesent sagittis sit amet neque non facilisis.";
        sendMessage(message);
        checkMessage(message);
    }
    @Test
    public void sendMessgeWithLink() {
        String message = "https://www.google.com/";
        sendMessage(message);
        checkMessage(message);
    }
    @Test
    public void sendMessgeWithHTMLCode() {
        String message = "<html><body><p>test</p></body></html>";
        sendMessage(message);
        checkMessage(message);
    }
    @Test
    public void sendManyMessages() {
        String message = "Why are you running?";
        for (int i = 0; i < 10; i++) {
            sendMessage(message);
            checkMessage(message);
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class ='integri-chat-message-container integri-chat-message-own']"), i + 1));
        }
        sendMessage(message);
        checkMessage(message);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'integri-demo-version']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class= 'integri-demo-version']")).isDisplayed());
    }
    @Test
    public void redactMessage() {
        String message = "Why are you running?";
        String editedMessage = "WHY ARE YOU RUNNING???";
        sendMessage(message);
        driver.findElement(By.xpath("//span[@class = 'iv-icon iv-icon-pencil integri-chat-edit-message']")).click();
        WebElement editMessage = driver.findElement(By.xpath("//div[@class = 'integri-chat-message ']/textarea"));
        editMessage.clear();
        editMessage.sendKeys(editedMessage, Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(receivedMessageXPath)));
        String recivedMessage = driver.findElement(By.xpath(receivedMessageXPath)).getText();
        assertEquals(recivedMessage, editedMessage);
    }
    @Test
    public void redactMessageEmpty() {
        String message = "Why are you running?";
        sendMessage(message);
        driver.findElement(By.xpath("//span[@class = 'iv-icon iv-icon-pencil integri-chat-edit-message']")).click();
        WebElement editMessage = driver.findElement(By.xpath("//div[@class = 'integri-chat-message ']/textarea"));
        editMessage.clear();
        editMessage.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'integri-notify integri-notify-error']")));
        String errorMessage = driver.findElement(By.xpath("//div[@class = 'integri-notify integri-notify-error']")).getText();
        assertEquals(errorMessage, "Message cannot be empty!");
    }
    @Test
    public void deleteMessage() {
        String message = "Why are you running?";
        sendMessage(message);
        driver.findElement(By.xpath("//span[@class = 'iv-icon iv-icon-trash2 integri-chat-remove-message']")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        wait.until(ExpectedConditions.textToBe(By.xpath(receivedMessageXPath), "removed..."));
    }
    @Test
    public void editName() {
        String name = "Jack";
        WebElement settingButton = driver.findElement(By.xpath(settingsButtonXPath));
        settingButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(settingsFormXpath)));
        WebElement nameField = driver.findElement(By.xpath("//input[@name ='userName']"));
        nameField.clear();
        nameField.sendKeys(name);
        driver.findElement(By.xpath(saveButtonXpath)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(settingsFormXpath)));
        String userName = driver.findElement(By.xpath("//div[@class = 'integri-session-user-name']")).getText();
        assertEquals(userName, name);
    }
    @Test
    public void editEmail() {
        String email = "Jack@gmail.com";
        WebElement settingButton = driver.findElement(By.xpath(settingsButtonXPath));
        settingButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(settingsFormXpath)));
        WebElement emailField = driver.findElement(By.xpath("//input[@name ='userEmail']"));
        emailField.sendKeys(email);
        driver.findElement(By.xpath(saveButtonXpath)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(settingsFormXpath)));
        settingButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(settingsFormXpath)));
        Assert.assertEquals(emailField.getAttribute("value"), email);
    }
    @Test
    public void editPhoto() {
        String photo = "https://www.meme-arsenal.com/memes/f12da8809c395f26ef6454287ff4c844.jpg";
        WebElement settingButton = driver.findElement(By.xpath(settingsButtonXPath));
        settingButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(settingsFormXpath)));
        WebElement avatarField = driver.findElement(By.xpath("//input[@name ='userPic']"));
        avatarField.sendKeys(photo);
        driver.findElement(By.xpath(saveButtonXpath)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(settingsFormXpath)));
        settingButton.click();
        Assert.assertEquals(avatarField.getAttribute("value"), photo);
    }
    @Test
    public void inviteLink() throws IOException, UnsupportedFlavorException {
        WebElement inviteButton = driver.findElement(By.id("invite-users-to-chat"));
        String currentURL = driver.getCurrentUrl();
        inviteButton.click();
        String invitationURL = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Assert.assertEquals(currentURL, invitationURL);
    }
    @Test
    public void buttonWithCode() throws IOException, UnsupportedFlavorException {
        WebElement codeOnPage = driver.findElement(By.xpath("//code"));
        String code = codeOnPage.getText();
        String editedCode = code.replaceAll("\n", "");
        codeOnPage.click();
        String copiedText = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        Assert.assertEquals(copiedText, editedCode);
    }
    @Test
    public void uploadImage() {
        String image1 = "src/test/resources/1.jpg";
        WebElement uploadButton = driver.findElement(By.xpath(uploadButtonXpath));
        uploadButton.click();
        driver.findElement(By.xpath("//span[@class = 'integri-file-upload-manual-init']")).click();
        File file = new File(image1);
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//button[@class='integri-file-upload-start integri-float-right integri-button-blue']")).click();
    }
    @Test
    public void uploadImages() {
        String image1 = "src/test/resources/1.jpg";
        String image2 = "src/test/resources/2.jpg";
        WebElement uploadButton = driver.findElement(By.xpath(uploadButtonXpath));
        uploadButton.click();
        driver.findElement(By.xpath("//span[@class = 'integri-file-upload-manual-init']")).click();
        File file1 = new File(image1);
        File file2 = new File(image2);
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(file1.getAbsolutePath());
        driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(file2.getAbsolutePath());
        driver.findElement(By.xpath("//button[@class='integri-file-upload-start integri-float-right integri-button-blue']")).click();
    }
}