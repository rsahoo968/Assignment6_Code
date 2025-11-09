package playwrightLLM;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.*;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookstoreLLMTest {

    private static Playwright playwright;
    private static Browser browser;
    private BrowserContext context;
    private Page page;

    @BeforeAll
    static void beforeAll() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
        );
    }

    @AfterAll
    static void afterAll() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    @BeforeEach
    void setUp() {
        context = browser.newContext(
                new Browser.NewContextOptions()
                        .setRecordVideoDir(Paths.get("playwright-videos"))
                        .setRecordVideoSize(1280, 720)
        );
        page = context.newPage();
    }

    @AfterEach
    void tearDown() {
        if (context != null) context.close();
    }

    @Test
    void earbuds_search_filter_addToCart_showsOneItem() {
        // 1. Navigate to the DePaul bookstore
        page.navigate("https://depaul.bncollege.com/");

        // 2. Fill in the main search bar (use its unique ID to avoid strict-mode violation)
        page.locator("#bned_site_search").fill("earbuds");
        page.locator("#bned_site_search").press("Enter");

        // 3. Wait for results to appear (generic example; adjust selector as needed)
        page.waitForSelector("text=Earbuds");

        // 4. Click the first product link containing “Earbuds”
        page.locator("text=Earbuds").first().click();

        // 5. Add the item to the cart (button text may differ slightly on the site)
        page.getByRole(AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Add to Cart")).click();

        // 6. Open the cart page
        page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions().setName("Cart")).click();

        // 7. Verify that the cart shows exactly one item
        Locator itemCount = page.locator("text=1 Item").first();
        assertTrue(itemCount.isVisible(), "Expected cart to show 1 item");
    }
}
