package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.LoginSteps;

import java.util.concurrent.TimeUnit;

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

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
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

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
