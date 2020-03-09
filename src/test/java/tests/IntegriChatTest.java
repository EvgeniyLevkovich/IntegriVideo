package tests;

import org.testng.annotations.Test;
import pages.IntegriChatPage;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class IntegriChatTest extends BaseTest {

    IntegriChatPage chat;

    @Test
    public  void sendMessageByClick() {
        String message = "Why are you running?";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.typeMessage(message);
        chat.sendMessageByClick();
        chat.checkMessage(message, 1);
    }
    @Test
    public void sendMessageByEnter() {
        String message = "Why are you running?";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.typeMessage(message);
        chat.sendMessageByEnter();
        chat.checkMessage(message, 1);
    }
    @Test
    public void sendLongMessage() {
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.generatelongMessage(1000);
        chat.typeMessage(chat.getgeneratelongMessage());
        chat.sendMessageByClick();
        chat.checkMessage(chat.getgeneratelongMessage(), 1);
    }
    @Test
    public void sendMessageWithLink() {
        String message = "https://www.google.com/";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.typeMessage(message);
        chat.sendMessageByClick();
        chat.checkMessage(message, 1);
    }
    @Test
    public void sendMessageWithHTMLCode() {
        String message = "<html><body><p>test</p></body></html>";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.typeMessage(message);
        chat.sendMessageByClick();
        chat.checkMessage(message, 1);
    }
    @Test
    public void sendManyMessages() {
        String message = "Why are you running?";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.sendManyMessages(10, message);
        chat.checkForTrialVersion();
    }
    @Test
    public void editMessage() {
        String message = "Why are you running?";
        String editedMessage = "WHY ARE YOU RUNNING???";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.typeMessage(message);
        chat.sendMessageByEnter();
        chat.editMessage(editedMessage);
        chat.checkMessage(editedMessage, 1);
    }
    @Test
    public void editMessageEmpty() {
        String message = "Why are you running?";
        String editedMessage = "";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.typeMessage(message);
        chat.sendMessageByEnter();
        chat.editMessage(editedMessage);
        chat.checkForEmptyEditedMessage();
    }
    @Test
    public void  inviteLink() throws IOException, UnsupportedFlavorException {
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.getInviteLink();
        chat.checkInviteLink();
    }
    @Test
    public void buttonWithCode() throws IOException, UnsupportedFlavorException {
        chat = new IntegriChatPage(driver);
        chat.openPage();
        chat.getCode();
        chat.checkCode();
    }
}
