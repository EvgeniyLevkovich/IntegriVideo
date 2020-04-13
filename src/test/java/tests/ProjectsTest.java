package tests;

import io.qameta.allure.Description;
import models.User;
import org.testng.annotations.Test;
import utils.Retry;

public class ProjectsTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Creation of project")
    @Description("Adding the new project and filling the fields")

    public void addProject() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login
                .openPage()
                .login(user)
                .isLoginValid();
        project
                .openPage()
                .clickAddProject()
                .addProject("Project 1", "Bla bla project", "https://www.tut.by/", "https://www.onliner.by/")
                .clickSaveProject();
    }
}
