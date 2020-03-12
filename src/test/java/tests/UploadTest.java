package tests;

import org.testng.annotations.Test;
import pages.FileUploadModal;

public class UploadTest extends BaseTest {

    FileUploadModal chat;

    @Test
    public void uploadImage() {
        String image1 = "src/test/resources/1.txt";
        chat = new FileUploadModal(driver)
            .openPage()
            .openUploadWindow()
            .uploadFile(image1)
            .verifyFile("1.txt");
    }
    @Test
    public void uploadImages() {
        String image1 = "src/test/resources/1.txt";
        String image2 = "src/test/resources/2.txt";
        chat = new FileUploadModal(driver)
            .openPage()
            .openUploadWindow()
            .uploadFiles(image1, image2);
    }
}
