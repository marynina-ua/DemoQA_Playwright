package tests.WidgetsTests;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class MenuTest extends TestBase {

    @Test
    public void checkSubSubMenu(){
        page.navigate("https://demoqa.com/menu");
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Main Item 2")).hover();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("SUB SUB LIST »")).hover();
        assertThat( page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sub Sub Item 1")) ).isVisible();
    }
}
