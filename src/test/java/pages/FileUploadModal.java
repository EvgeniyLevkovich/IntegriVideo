package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class FileUploadModal extends BasePage {
    private static final String URL = "https://dev.integrivideo.com/demo/chat/new";
    private static final By MESSAGE_TEXT_AREA = By.cssSelector("[placeholder='Start typing here']");
    private static final By UPLOAD_BUTTON = By.cssSelector(".integri-chat-manual-upload");
    private static final By UPLOAD_PATH = By.cssSelector("input[type='file']");
    private static final By START_UPLOAD_BUTTON = By.cssSelector(".integri-file-upload-start");




    public FileUploadModal(WebDriver driver) {
        super(driver);
    }
    public void openPage() {
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MESSAGE_TEXT_AREA));
    }
    public void openUploadWindow() {
        driver.findElement(UPLOAD_BUTTON).click();
    }
    public void uploadFile(String image1) {
        File file = new File(image1);
        driver.findElement(UPLOAD_PATH).sendKeys(file.getAbsolutePath());
        driver.findElement(START_UPLOAD_BUTTON).click();
    }
    public void uploadFiles(String image1, String image2) {
        File file1 = new File(image1);
        File file2 = new File(image2);
        driver.findElement(UPLOAD_PATH).sendKeys(file1.getAbsolutePath());
        driver.findElement(UPLOAD_PATH).sendKeys(file2.getAbsolutePath());
        driver.findElement(START_UPLOAD_BUTTON).click();
    }
}
