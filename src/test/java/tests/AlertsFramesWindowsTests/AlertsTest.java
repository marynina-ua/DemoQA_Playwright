package tests.AlertsFramesWindowsTests;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AlertsTest extends TestBase {

    public static final String URL_ALERTS = "https://demoqa.com/alerts";

    @Test
    void alertTestOk()  {
        page.navigate(URL_ALERTS);

        page.onDialog(dialog -> dialog.accept());

        page.locator("#confirmButton").click();

        assertThat(page.locator("#confirmResult")).containsText("You selected Ok");

    }

    @Test
    void alertTestDismiss()  {
        page.navigate(URL_ALERTS);

        page.onDialog(dialog -> dialog.dismiss());

        page.locator("#confirmButton").click();

        assertThat(page.locator("#confirmResult")).containsText("You selected Cancel");
    }

    @Test
    void promptTest()  {
        page.navigate(URL_ALERTS);

        page.onDialog(dialog -> dialog.accept("test"));

        page.locator("#promtButton").click();

        assertThat(page.locator("#promptResult")).containsText("You entered test");
    }
}
