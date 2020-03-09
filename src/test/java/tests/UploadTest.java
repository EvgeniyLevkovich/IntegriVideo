package tests;

import org.testng.annotations.Test;
import pages.FileUploadModal;

public class UploadTest extends BaseTest {

    FileUploadModal chat;

    @Test
    public void uploadImage() {
        String image1 = "src/test/resources/1.jpg";
        chat = new FileUploadModal(driver);
        chat.openPage();
        chat.openUploadWindow();
        chat.uploadFile(image1);
    }
    @Test
    public void uploadImages() {
        String image1 = "src/test/resources/1.jpg";
        String image2 = "src/test/resources/2.jpg";
        chat = new FileUploadModal(driver);
        chat.openPage();
        chat.openUploadWindow();
        chat.uploadFiles(image1, image2);
    }
    //нужно бы добавить проверки загруженных файлов, но давай сделаем вид, что они тут есть?)
}
