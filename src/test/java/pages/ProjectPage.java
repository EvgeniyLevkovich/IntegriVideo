package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {
    private static final By PROJECT_BUTON = By.xpath("//a[contains(text(), 'Projects')]");


    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public ProjectPage isPageOpened() {
        return this;
    }
    @Override
    public ProjectPage openPage() {
        driver.findElement(PROJECT_BUTON).click();
        isPageOpened();
        return this;
    }
    public ProjectPage addNewProject() {


        return this;
    }
}
