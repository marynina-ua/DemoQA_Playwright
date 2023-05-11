package tests.ElementsTest;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ButtonsTest extends TestBase {

    public static final String URL_BUTTONS = "https://demoqa.com/buttons";

    @Test
    public void clickOnDoubleClickButton(){
        page.navigate(URL_BUTTONS);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Double Click Me")).dblclick();
        assertThat(page.locator("#doubleClickMessage")).containsText("double click");
    }

    @Test
    public void clickOnRightClickButton(){
        page.navigate(URL_BUTTONS);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Right Click Me")).click( new Locator.ClickOptions()
                .setButton(MouseButton.RIGHT));
        assertThat(page.locator("#rightClickMessage")).containsText("right click");
    }
}
