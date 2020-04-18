package tests;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.LoginSteps;
import utils.CapabilitiesGenerator;
import java.util.concurrent.TimeUnit;

@Log4j2
public  class BaseTest {

    WebDriver driver;
    LoginPage login;
    LoginSteps loginSteps;
    BillingPage billing;
    IntegriSettingsModal chatSettings;
    IntegriChatPage chat;
    RegistrationPage registration;
    ProjectPage project;
    FileUploadModal chatUpload;

    @BeforeMethod(description = "Opening Chrome Driver")
    public void setUp() {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        login = new LoginPage(driver);
        loginSteps = new LoginSteps(driver);
        billing = new BillingPage(driver);
        chatSettings = new IntegriSettingsModal(driver);
        chat = new IntegriChatPage(driver);
        registration = new RegistrationPage(driver);
        project = new ProjectPage(driver);
        chatUpload = new FileUploadModal(driver);
    }

    @AfterMethod(description = "Closing browser")
    public void closeBrowser() {
        driver.quit();
    }
}
