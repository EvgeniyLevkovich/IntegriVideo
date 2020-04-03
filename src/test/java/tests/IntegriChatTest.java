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
        chat = new IntegriChatPage(driver)
            .openPage()
            .typeMessage(message)
            .sendMessageByClick()
            .checkMessage(message, 1);
    }
    @Test
    public void sendMessageByEnter() {
        String message = "Why are you running?";
        chat = new IntegriChatPage(driver)
            .openPage()
            .typeMessage(message)
            .sendMessageByEnter()
            .checkMessage(message, 1);
    }
    @Test
    public void sendLongMessage() {
        chat = new IntegriChatPage(driver)
            .openPage()
            .generatelongMessage(1000);
        chat.typeMessage(chat.getgeneratelongMessage())
            .sendMessageByClick()
            .checkMessage(chat.getgeneratelongMessage(), 1);
    }
    @Test
    public void sendMessageWithLink() {
        String message = "https://www.google.com/";
        chat = new IntegriChatPage(driver)
            .openPage()
            .typeMessage(message)
            .sendMessageByClick()
            .checkMessage(message, 1);
    }
    @Test
    public void sendMessageWithHTMLCode() {
        String message = "<html><body><p>test</p></body></html>";
        chat = new IntegriChatPage(driver)
            .openPage()
            .typeMessage(message)
            .sendMessageByClick()
            .checkMessage(message, 1);
    }
    @Test
    public void sendManyMessages() {
        String message = "Why are you running?";
        chat = new IntegriChatPage(driver)
            .openPage()
            .sendManyMessages(10, message)
            .checkForTrialVersion();
    }
    @Test
    public void editMessage() {
        String message = "Why are you running?";
        String editedMessage = "WHY ARE YOU RUNNING???";
        chat = new IntegriChatPage(driver)
            .openPage()
            .typeMessage(message)
            .sendMessageByEnter()
            .editMessage(editedMessage)
            .checkMessage(editedMessage, 1);
    }
    @Test
    public void editMessageEmpty() {
        String message = "Why are you running?";
        String editedMessage = "";
        chat = new IntegriChatPage(driver)
            .openPage()
            .typeMessage(message)
            .sendMessageByEnter()
            .editMessage(editedMessage)
            .checkForEmptyEditedMessage();
    }
    @Test
    public void  inviteLink() throws IOException, UnsupportedFlavorException {
        chat = new IntegriChatPage(driver)
            .openPage()
            .getInviteLink()
            .checkInviteLink();
    }
    @Test
    public void buttonWithCode() throws IOException, UnsupportedFlavorException {
        chat = new IntegriChatPage(driver)
            .openPage()
            .getCode()
            .checkCode();
    }
}
