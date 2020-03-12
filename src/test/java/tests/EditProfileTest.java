package tests;

import org.testng.annotations.Test;
import pages.IntegriSettingsModal;

public class EditProfileTest extends BaseTest {

    IntegriSettingsModal chat;

    @Test
    public void editName() {
        String name = "Jack";
        chat = new IntegriSettingsModal(driver)
            .openPage()
            .openSettingsForm()
            .editUsername(name)
            .saveSettings()
            .checkNickname(name);
    }
    @Test
    public void editEmail() {
        String email = "Jack@gmail.com";
        chat = new IntegriSettingsModal(driver)
            .openPage()
            .openSettingsForm()
            .editEmail(email)
            .saveSettings()
            .checkEmail(email);
    }
    @Test
    public void editAvatar() {
        String avatarLink = "https://www.meme-arsenal.com/memes/f12da8809c395f26ef6454287ff4c844.jpg";
        chat = new IntegriSettingsModal(driver)
            .openPage()
            .openSettingsForm()
            .editAvatar(avatarLink)
            .saveSettings()
            .checkAvatar(avatarLink);
    }
}
