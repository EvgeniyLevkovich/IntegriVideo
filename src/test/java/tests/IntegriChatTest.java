package tests;

import org.testng.annotations.Test;
import utils.Retry;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class IntegriChatTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public  void sendMessageByClick() {
        String message = "Why are you running?";
        chat
            .openPage()
            .typeMessage(message)
            .sendMessageByClick()
            .checkMessage(message, 1);
    }

    @Test(retryAnalyzer = Retry.class)
    public void sendMessageByEnter() {
        String message = "Why are you running?";
        chat
            .openPage()
            .typeMessage(message)
            .sendMessageByEnter()
            .checkMessage(message, 1);
    }

    @Test(retryAnalyzer = Retry.class)
    public void sendLongMessage() {
        chat
            .openPage()
            .generatelongMessage(1000);
        chat.typeMessage(chat.getgeneratelongMessage())
            .sendMessageByClick()
            .checkMessage(chat.getgeneratelongMessage(), 1);
    }

    @Test(retryAnalyzer = Retry.class)
    public void sendMessageWithLink() {
        String message = "https://www.google.com/";
        chat
            .openPage()
            .typeMessage(message)
            .sendMessageByClick()
            .checkMessage(message, 1);
    }

    @Test(retryAnalyzer = Retry.class, enabled = false)
    public void sendMessageWithHTMLCode() {
        String message = "<html><body><p>test</p></body></html>";
        chat
            .openPage()
            .typeMessage(message)
            .sendMessageByClick()
            .checkMessage(message, 1);
    }

    @Test(retryAnalyzer = Retry.class)
    public void sendManyMessages() {
        String message = "Why are you running?";
        chat
            .openPage()
            .sendManyMessages(10, message)
            .checkForTrialVersion();
    }

    @Test(retryAnalyzer = Retry.class)
    public void editMessage() {
        String message = "Why are you running?";
        String editedMessage = "WHY ARE YOU RUNNING???";
        chat
            .openPage()
            .typeMessage(message)
            .sendMessageByEnter()
            .editMessage(editedMessage)
            .checkMessage(editedMessage, 1);
    }

    @Test(retryAnalyzer = Retry.class)
    public void editMessageEmpty() {
        String message = "Why are you running?";
        String editedMessage = "";
        chat
            .openPage()
            .typeMessage(message)
            .sendMessageByEnter()
            .editMessage(editedMessage)
            .checkForEmptyEditedMessage();
    }

    @Test(retryAnalyzer = Retry.class)
    public void  inviteLink() throws IOException, UnsupportedFlavorException {
        chat
            .openPage()
            .getInviteLink()
            .checkInviteLink();
    }

    @Test(retryAnalyzer = Retry.class)
    public void buttonWithCode() throws IOException, UnsupportedFlavorException {
        chat
            .openPage()
            .getCode()
            .checkCode();
    }
}
