import org.testng.annotations.Test;
import pages.UploadPage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.testng.Assert.assertTrue;

public class UploadTest extends BaseTest {

    @Test
    public void uploadFile() throws IOException {
        Path filePath  = Files.createTempFile("testFile",".txt");
        File file = filePath.toFile();
        String path = file.getAbsolutePath();
        UploadPage uploadPage = new UploadPage();
        uploadPage.typePath(path);
        uploadPage.submit();

        assertTrue(uploadPage.getUploadedFiles().contains(file.getName()),  "File was not uploaded!");
    }
}

