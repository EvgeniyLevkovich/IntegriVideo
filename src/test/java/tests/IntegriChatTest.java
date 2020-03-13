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
        String message = "Etiam sit amet lectus ac tortor fringilla maximus eget vitae orci. Vestibulum nisl sapien, semper id malesuada ac, euismod ac quam. Nunc facilisis nunc tortor, sit amet convallis velit pharetra in. Praesent a massa a justo pharetra vulputate. Morbi ultricies iaculis hendrerit. Nulla sit amet tempor turpis. Vestibulum posuere vitae sapien in venenatis. Morbi non risus neque Suspendisse potenti. In interdum pretium nulla, ut molestie felis sodales nec. Pellentesque in pulvinar nulla, quis consequat nisi. Suspendisse sed risus non quam laoreet fringilla. Cras sit amet dictum lectus, a accumsan ex. Aliquam quis risus at mauris tincidunt efficitur vitae eget tellus. Sed vitae tempor ipsum. Quisque viverra nulla purus, pretium blandit ex sollicitudin non. Nam blandit nibh arcu, quis euismod leo malesuada ut. Fusce ultricies venenatis nibh at scelerisque. Aliquam elementum mi eu dolor rutrum finibus. Donec nec dolor sed massa malesuada bibendum. Pellentesque nisl sapien, tempor eu tellus ut, tristique suscipit magna. Donec non sollicitudin leo. Fusce vitae viverra magna. Praesent sagittis sit amet neque non facilisis.";
        chat = new IntegriChatPage(driver);
        chat.openPage();
        //chat.generatelongMessage(1000);
        chat.typeMessage(message);
        chat.sendMessageByClick();
        chat.checkMessage(message, 1);
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
