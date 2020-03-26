package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {
    private static final By PROJECT_BUTON = By.xpath("//a[contains(text(), 'Projects')]");
    private static final By ADD_PROFECT_BUTTON = By.cssSelector(".status");
    private static final By PROJECT_NAME_FIELD = By.cssSelector("[placeholder='New project']");
    private static final By DESCRIPTION_NAME_FIELD = By.cssSelector("[placeholder='Type here...']");


    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public ProjectPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PROJECT_BUTON));
        return this;
    }

    public ProjectPage openPage() {
        driver.findElement(PROJECT_BUTON).click();
        isPageOpened();
        return this;
    }
    public ProjectPage addNewProject(String projectName, String description) {
        driver.findElement(ADD_PROFECT_BUTTON).click();
        driver.findElement(PROJECT_NAME_FIELD).sendKeys(projectName);
        driver.findElement(DESCRIPTION_NAME_FIELD).sendKeys(description);


        return this;
    }
}
