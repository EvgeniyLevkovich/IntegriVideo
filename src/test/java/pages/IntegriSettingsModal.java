package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class IntegriSettingsModal extends BasePage {
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final By MESSAGE_TEXT_AREA = By.cssSelector("[placeholder='Start typing here']");
    private static final By SETTING_BUTTON = By.cssSelector(".iv-icon-cog");
    private static final By USERNAME_FIELD = By.name("userName");
    private static final By SAVE_SETTINGS = By.cssSelector(".integri-user-settings-save");
    private static final By SESSION_USERNAME = By.cssSelector("div.integri-session-user-name");
    private static final By EMAIL_FIELD = By.name("userEmail");
    private static final By AVATARLINK_FIELD = By.name("userPic");


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
     public void editEmail (String email) {
        WebElement emailField = driver.findElement(EMAIL_FIELD);
        emailField.clear();
        emailField.sendKeys(email);
     }
     public void checkEmail (String email) {
         openSettingsForm();
         String newEmail = driver.findElement(EMAIL_FIELD).getAttribute("value");
         assertEquals(newEmail, email);
     }
     public void editAvatar (String avatarLink) {
        WebElement AvatarLinkField = driver.findElement(AVATARLINK_FIELD);
         AvatarLinkField.clear();
         AvatarLinkField.sendKeys(avatarLink);
     }
    public void checkAvatar (String avatarLink) {
        openSettingsForm();
        String newAvatarLink = driver.findElement(AVATARLINK_FIELD).getAttribute("value");
        assertEquals(newAvatarLink, avatarLink);
    }

}
