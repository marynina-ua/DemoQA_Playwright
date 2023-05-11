package tests.AlertsFramesWindowsTests;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class FramesTest extends TestBase {

    public static final String URL_FRAMES = "https://demoqa.com/frames";

    @Test
    public void switchToFrameById() {
        page.navigate(URL_FRAMES);

        assertThat(page.frameLocator("#frame1").locator("#sampleHeading")).containsText("sample");
    }
}
