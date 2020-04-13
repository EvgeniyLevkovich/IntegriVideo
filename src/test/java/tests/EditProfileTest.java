package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class EditProfileTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void editName() {
        String name = "Jack";
        chatSettings
            .openPage()
            .openSettingsForm()
            .editUsername(name)
            .saveSettings()
            .checkNickname(name);
    }

    @Test(retryAnalyzer = Retry.class)
    public void editEmail() {
        String email = "Jack@gmail.com";
        chatSettings
            .openPage()
            .openSettingsForm()
            .editEmail(email)
            .saveSettings()
            .checkEmail(email);
    }

    @Test(retryAnalyzer = Retry.class)
    public void editAvatar() {
        String avatarLink = "https://www.meme-arsenal.com/memes/f12da8809c395f26ef6454287ff4c844.jpg";
        chatSettings
            .openPage()
            .openSettingsForm()
            .editAvatar(avatarLink)
            .saveSettings()
            .checkAvatar(avatarLink);
    }
}
