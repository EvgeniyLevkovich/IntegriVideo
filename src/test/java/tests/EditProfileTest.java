package tests;

import org.testng.annotations.Test;
import pages.IntegriSettingsModal;

public class EditProfileTest extends BaseTest {
    IntegriSettingsModal chat;

    @Test
    public void editName() {
        String name = "Jack";
        chat = new IntegriSettingsModal(driver);
        chat.openPage();
        chat.openSettingsForm();
        chat.editUsername(name);
        chat.saveSettings();
        chat.checkNickname(name);
    }
    @Test
    public void editEmail() {
        String email = "Jack@gmail.com";
        chat = new IntegriSettingsModal(driver);
        chat.openPage();
        chat.openSettingsForm();
        chat.editEmail(email);
        chat.saveSettings();
        chat.checkEmail(email);
    }
    @Test
    public void editAvatar() {
        String avatarLink = "https://www.meme-arsenal.com/memes/f12da8809c395f26ef6454287ff4c844.jpg";
        chat = new IntegriSettingsModal(driver);
        chat.openPage();
        chat.openSettingsForm();
        chat.editAvatar(avatarLink);
        chat.saveSettings();
        chat.checkAvatar(avatarLink);

    }

}
