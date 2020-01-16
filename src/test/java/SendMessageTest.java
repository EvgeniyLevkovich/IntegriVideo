import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SendMessageTest extends WebdriverStart {
    String inputMessageAreaXpath = "//textarea[@placeholder = 'Start typing here']";
    String recivedMessageXPath = "//div[@class ='integri-chat-message-text']";
    String sendMessageButtonXPath = "//button[@class ='integri-chat-send-message integri-chat-action-button']";

    public void sendindMessage(String message) {
        WebElement input = driver.findElement(By.xpath(inputMessageAreaXpath));
        input.sendKeys(message);
        input.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(recivedMessageXPath)));
        String recivedMessage = driver.findElement(By.xpath(recivedMessageXPath)).getText();
        assertEquals(recivedMessage, message);
    }
    @Test
    public void sendMessageByClick() {
        String message = "Why are you running?";
        WebElement input = driver.findElement(By.xpath(inputMessageAreaXpath));
        input.sendKeys(message);
        WebElement sendMessageButton = driver.findElement(By.xpath(sendMessageButtonXPath));
        sendMessageButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(recivedMessageXPath)));
        String recivedMessage = driver.findElement(By.xpath(recivedMessageXPath)).getText();
        assertEquals(recivedMessage, message);
    }
    @Test
    public void sendMessageByEnter() {
        String message = "Why are you running?";
        sendindMessage(message);
    }
    @Test
    public void sendLongMessage() {
        String message = "Etiam sit amet lectus ac tortor fringilla maximus eget vitae orci. Vestibulum nisl sapien, semper id malesuada ac, euismod ac quam. Nunc facilisis nunc tortor, sit amet convallis velit pharetra in. Praesent a massa a justo pharetra vulputate. Morbi ultricies iaculis hendrerit. Nulla sit amet tempor turpis. Vestibulum posuere vitae sapien in venenatis. Morbi non risus neque Suspendisse potenti. In interdum pretium nulla, ut molestie felis sodales nec. Pellentesque in pulvinar nulla, quis consequat nisi. Suspendisse sed risus non quam laoreet fringilla. Cras sit amet dictum lectus, a accumsan ex. Aliquam quis risus at mauris tincidunt efficitur vitae eget tellus. Sed vitae tempor ipsum. Quisque viverra nulla purus, pretium blandit ex sollicitudin non. Nam blandit nibh arcu, quis euismod leo malesuada ut. Fusce ultricies venenatis nibh at scelerisque. Aliquam elementum mi eu dolor rutrum finibus. Donec nec dolor sed massa malesuada bibendum. Pellentesque nisl sapien, tempor eu tellus ut, tristique suscipit magna. Donec non sollicitudin leo. Fusce vitae viverra magna. Praesent sagittis sit amet neque non facilisis.";
        sendindMessage(message);
    }
    @Test
    public void sendMessgeWithLink() {
        String message = "https://www.google.com/";
        sendindMessage(message);
    }
    @Test
    public void sendMessgeWithHTMLCode() {
        String message = "<html><body><p>test</p></body></html>";
        sendindMessage(message);
    }
    @Test
    public void sendManyMessages() {
        String message = "Why are you running?";
        for (int i = 1; i < 11; i++) {
            WebElement input = driver.findElement(By.xpath(inputMessageAreaXpath));
            input.sendKeys(message);
            input.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class ='integri-chat-message-container integri-chat-message-own']"), i));
        }
        WebElement input = driver.findElement(By.xpath(inputMessageAreaXpath));
        input.sendKeys(message);
        input.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'integri-demo-version']")));
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class= 'integri-demo-version']")).isDisplayed());
    }
}