package tests.WidgetsTests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SliderTest extends TestBase {

    public static final String URL_SLIDER = "https://demoqa.com/slider";

    @Test
    public void moveSliderWithKeyboard(){
        page.navigate(URL_SLIDER);

        Locator slider = page.locator("#sliderContainer > div.col-9 > span > input");

        slider.focus();

        while ( Integer.valueOf( slider.getAttribute("value")) < 40 )
        {
            slider.press("ArrowRight");
        }

        assertThat( page.locator("#sliderContainer > div.col-9 > span > input") ).hasValue("40");
    }

    @Test
    public void moveSliderWithMouse(){
        page.navigate(URL_SLIDER);

        Locator slider = page.locator("#sliderContainer > div.col-9 > span > input");

        BoundingBox box = slider.boundingBox();

        page.mouse().click(box.x + box.width / 100 * 40, box.y + box.height / 2);

        assertThat( page.locator("#sliderContainer > div.col-9 > span > input") ).hasValue("40");
    }
}
