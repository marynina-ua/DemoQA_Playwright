package tests.ElementsTest;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import java.net.URI;
import java.net.URISyntaxException;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class BrokenLinksImagesTest extends TestBase {

    public static final String URL_BROKEN_LINKS = "https://demoqa.com/broken";

    @Test
    public void checkLinks()
    {
        page.navigate(URL_BROKEN_LINKS);
        for (Locator row : page.getByRole(AriaRole.LINK).all()) {
            System.out.println(row.textContent());
            APIResponse response = page.request().get(row.getAttribute("href"));
            assertThat(response).isOK();
        }
    }

    @Test
    public void checkBrokenImages() throws URISyntaxException {
        page.navigate(URL_BROKEN_LINKS);
        for ( Locator image : page.getByRole(AriaRole.IMG).all() ) {
            String src = image.getAttribute("src");
            // http(s) + :// + host  + src
            URI uri = new URI( page.url() );
            // uri.getScheme() -- https
            // uri.getHost() -- demoqa.com
            if ( !src.startsWith("http") ) src = uri.getScheme() + "://" + uri.getHost() + src;
            System.out.println(src);
            APIResponse response = page.request().get(src);

            assertThat(response).isOK();

            assertTrue(response.headers().get("content-type").contains("image"));
            assertFalse( image.evaluate("node => node.naturalWidth").equals(0) ,
                    "Failed: image naturalWidth == 0" );
        }
    }
}
