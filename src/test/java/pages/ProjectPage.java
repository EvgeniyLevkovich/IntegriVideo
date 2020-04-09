package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectPage extends BasePage {
    private static final By PROJECT_BUTON = By.xpath("//a[contains(text(), 'Projects')]");
    private static final By ADD_PROJECT_BUTTON = By.cssSelector(".status");
    private static final By PROJECT_NAME_FIELD = By.cssSelector("[placeholder='New project']");
    private static final By DESCRIPTION_NAME_FIELD = By.cssSelector("[placeholder='Type here...']");
    private static final By DOMAINS_FIELD = By.name("domains[]");
    private static final By CREATE_BUTTON = By.xpath("//button[text()='Create']");


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
    public ProjectPage clickAddProject() {
        driver.findElement(ADD_PROJECT_BUTTON).click();
        return this;
    }
    public ProjectPage addProject(String projectName, String description, String... domains) {
        driver.findElement(PROJECT_NAME_FIELD).sendKeys(projectName);
        driver.findElement(DESCRIPTION_NAME_FIELD).sendKeys(description);
        for (int i = 0; i < domains.length; i++) {
            driver.findElements(DOMAINS_FIELD).get(i).sendKeys(domains[i]);
        }
        return this;
    }
    public ProjectPage clickSaveProject() {
        driver.findElement(CREATE_BUTTON).click();
        return this;
    }

}
