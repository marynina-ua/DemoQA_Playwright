package tests.ElementsTest;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class RadioButtonTest extends TestBase {

    public static final String URL_RADIO_BUTTON = "https://demoqa.com/radio-button";

    @Test
    public void selectRadioButtons() {
        page.navigate(URL_RADIO_BUTTON);
        //page.getByLabel("Yes").check();

        page.locator("#yesRadio").check( new Locator.CheckOptions().setForce(true) );
        assertThat(page.locator(".col-12.mt-4.col-md-6 .mt-3")).containsText("Yes");

    }
}
