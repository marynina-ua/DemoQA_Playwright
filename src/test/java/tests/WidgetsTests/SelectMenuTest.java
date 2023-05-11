package tests.WidgetsTests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SelectMenuTest extends TestBase {

    public static final String URL_SELECT_MENU = "https://demoqa.com/select-menu";

    @Test
    public void fillInTwoSelectFieldsByFill() {
        page.navigate(URL_SELECT_MENU);
        page.locator("//*[@id='withOptGroup']/div").click();
        page.locator("#react-select-2-input").fill("Group 1, option 1");
        page.keyboard().press("Enter");
        assertThat(page.locator(".css-1hwfws3 .css-1uccc91-singleValue")).containsText("Group 1, option 1");
    }

    @Test
    public void fillInTwoSelectFieldsByClick() {
        page.navigate(URL_SELECT_MENU);
        page.locator("//*[@id='withOptGroup']/div").click();
        page.getByText("Group 2, option 1", new Page.GetByTextOptions().setExact(true)).click();
        page.keyboard().press("Enter");
        assertThat(page.locator(".css-1hwfws3 .css-1uccc91-singleValue")).containsText("Group 2, option 1");
    }

    @Test
    public void oldStyleSelectMenu() {
        page.navigate(URL_SELECT_MENU);

        page.locator("#oldSelectMenu").selectOption("1");
        assertThat( page.locator("#oldSelectMenu") ).hasValue("1");

        page.locator("#oldSelectMenu").selectOption(new SelectOption().setLabel("Green"));
        assertThat( page.locator("#oldSelectMenu") ).hasValue("2");
    }

    @Test
    public void standardMultiSelect() {
        page.navigate(URL_SELECT_MENU);

        page.locator("#cars").selectOption(new String[] {"volvo", "saab"});
//        assertThat( page.locator("#cars") ).hasValue("volvo");
        assertThat( page.locator("#cars") ).hasValues( new String[]{"volvo", "saab"} );
    }
}
