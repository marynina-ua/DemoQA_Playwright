package tests.InteractionsTests;

import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class DroppableTest extends TestBase {

    @Test
    public void droppable() {
        page.navigate("https://demoqa.com/droppable");

        page.locator("#draggable").dragTo(page.locator("#droppableExample-tabpane-simple #droppable"));
        assertThat( page.locator("#droppableExample-tabpane-simple #droppable") ).containsText("Dropped!");
    }
}
