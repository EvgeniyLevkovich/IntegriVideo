package tests;

import models.User;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;

public class ProjectsTest extends BaseTest {
    LoginPage login;
    ProjectPage project;

    @Test
    public void addProject() {
        User user = new User("integri@mailinator.com", "qwerty12345");
        login = new LoginPage(driver)
                .openPage()
                .login(user)
                .isLoginValid();
        project = new ProjectPage(driver)
                .openProjectPage()
                .addNewProject();



    }

}
