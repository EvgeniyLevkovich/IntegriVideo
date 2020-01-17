package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class IntegriSettingsModal extends BasePage {
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final By MESSAGE_TEXT_AREA = By.xpath("//textarea[@placeholder = 'Start typing here']");
    private static final By SETTING_BUTTON = By.xpath("//span[@class ='iv-icon iv-icon-cog']");
    private static final By USERNAME_FIELD = By.xpath("//input[@name ='userName']");
    private static final By SAVE_SETTINGS = By.xpath("//button[@class='integri-user-settings-save integri-button-blue']");
    private static final By SESSION_USERNAME = By.xpath("//div[@class = 'integri-session-user-name']");


    public IntegriSettingsModal(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_TEXT_AREA));
    }
     public void openSettingsForm() {
         WebElement settingButton = driver.findElement(SETTING_BUTTON);
         settingButton.click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
     }
     public void editUsername (String name) {
         WebElement nameField = driver.findElement(USERNAME_FIELD);
         nameField.clear();
         nameField.sendKeys(name);
     }
     public void saveSettings () {
         driver.findElement(SAVE_SETTINGS).click();
         wait.until(ExpectedConditions.invisibilityOfElementLocated(USERNAME_FIELD));
     }
     public void checkNickname (String name) {
         String userName = driver.findElement(SESSION_USERNAME).getText();
         assertEquals(userName, name);
     }

}
