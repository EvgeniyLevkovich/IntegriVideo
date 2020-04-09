package tests;

import org.testng.annotations.Test;
import utils.Retry;

public class UploadTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void uploadImage() {
        String image1 = "src/test/resources/1.txt";
        chatUpload
                .openPage()
            .openUploadWindow()
            .uploadFile(image1)
            .verifyFile("1.txt");
    }
    @Test(retryAnalyzer = Retry.class)
    public void uploadImages() {
        String image1 = "src/test/resources/1.txt";
        String image2 = "src/test/resources/2.txt";
        chatUpload
            .openPage()
            .openUploadWindow()
            .uploadFiles(image1, image2);
    }
}
