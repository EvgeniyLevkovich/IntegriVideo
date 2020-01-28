package tests;

import org.testng.annotations.Test;
import pages.IntegriSettingsModal;

public class EditProfileTest extends BaseTest {
    IntegriSettingsModal chat;

    @Test
    public  void editName() {
        String name = "Jack";
        chat = new IntegriSettingsModal(driver);
        chat.openPage();
        chat.openSettingsForm();
        chat.editUsername(name);
        chat.saveSettings();
        chat.checkNickname(name);
    }
}
