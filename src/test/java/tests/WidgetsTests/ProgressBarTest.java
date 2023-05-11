package tests.WidgetsTests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ProgressBarTest extends TestBase {

    @Test
    public void progressBar() throws InterruptedException {
        page.navigate("https://demoqa.com/progress-bar");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();

        var progressBar = page.locator(".progress-bar");

        System.out.println(progressBar.textContent());

        Thread.sleep(3000);

        System.out.println(progressBar.textContent());
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Stop")).click(new Locator.ClickOptions().setForce(true));

        System.out.println(progressBar.textContent());

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Start")).click();

        int iterations = 0;
        while ( !progressBar.textContent().equals("100%") )
        {
            if (iterations > 30) {
                System.out.println("break");
                break;
            }
            Thread.sleep(1000);
            iterations = iterations + 1;
        }
        assertThat(progressBar).hasText("100%");

        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Reset")).click();
        assertThat(progressBar).hasText("0%");
    }
}
