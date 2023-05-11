package tests.ElementsTest;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TextBoxTest extends TestBase {

    public static final String URL_TEXT_BOX = "https://demoqa.com/text-box";
    public static final String FULL_NAME = "John Doe";
    public static final String EMAIL = "john@doe.com";
    public static final String ADRESS = "10318, Germany, Berlin, Marksburgstrasse 1";

    @Test
    public void simpleFormSubmit() {
        page.navigate(URL_TEXT_BOX);

        page.getByPlaceholder("Full Name").fill(FULL_NAME);
        page.getByPlaceholder("name@example.com").fill(EMAIL);
        page.getByPlaceholder("Current Address").fill(ADRESS);
        page.locator("#permanentAddress").fill(ADRESS);
        page.getByText("Submit").click();

//        page.getByRole(AriaRole.BUTTON,
//                new Page.GetByRoleOptions().setName(Pattern.compile("Submit", Pattern.CASE_INSENSITIVE))).click();

        assertThat(page.locator("#name")).containsText(FULL_NAME);
        assertThat(page.locator("#email")).containsText(EMAIL);
        assertThat(page.locator("#output #currentAddress")).containsText(ADRESS);
        assertThat(page.locator("#output #permanentAddress")).containsText(ADRESS);
    }
}
