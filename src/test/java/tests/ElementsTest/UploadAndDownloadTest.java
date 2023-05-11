package tests.ElementsTest;

import com.microsoft.playwright.Download;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UploadAndDownloadTest extends TestBase {

    @Test
    public void downloadTest() {
        page.navigate("https://demoqa.com/upload-download");
        Download download = page.waitForDownload(() -> {
            page.locator("#downloadButton").click();
        });
        System.out.println(download.path());
        System.out.println(download.url());
        System.out.println(download.failure());
        System.out.println(download.suggestedFilename());

        assertEquals( "sampleFile.jpeg", download.suggestedFilename() );
        download.saveAs(Paths.get(download.suggestedFilename()));
    }
}
