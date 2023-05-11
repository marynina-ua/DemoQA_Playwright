package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.awt.*;

public class TestBase {

    public static Playwright playwright;
    public static Browser browser;

    public BrowserContext context;
    public Page page;

    @BeforeAll
    static void launchBrowser() {

        var launchOpts = new BrowserType.LaunchOptions()
                .setHeadless(false)
                .setSlowMo(50);
        //.setArgs(List.of("--start-maximized"));

        playwright = Playwright.create();
        //browser = playwright.chromium().launch(launchOpts);
        browser = playwright.firefox().launch(launchOpts);
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) screenSize.getWidth();
        int height = (int) screenSize.getHeight();
        //System.out.println(width +"  "+ height);
        //var contectOpts = new Browser.NewContextOptions().setViewportSize(null);
        var contectOpts = new Browser.NewContextOptions().setViewportSize( width,  height);
        context = browser.newContext(contectOpts);
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

}
