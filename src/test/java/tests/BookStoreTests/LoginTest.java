package tests.BookStoreTests;

import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends TestBase {

    public static final String URL_LOGINPAGE = "https://demoqa.com/login";
    public static final String USERNAME = "YevMar";
    public static final String PASSWORD = "Qwerty!123";

     @Test
     public void positiveAuthTest() {
         page.navigate(URL_LOGINPAGE);

         page.locator("input[id='userName']").click();
         page.locator("input[id='userName']").fill(USERNAME);
         page.getByPlaceholder("Password").click();
         page.getByPlaceholder("Password").fill(PASSWORD);
         page.locator("#login").click();

         assertThat(page.locator("#userName-value")).containsText(USERNAME);
     }

}
