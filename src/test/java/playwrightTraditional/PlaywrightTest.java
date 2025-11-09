package playwrightTraditional;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class PlaywrightTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://depaul.bncollege.com/");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("earbuds");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("Enter");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("brand")).click();
            page.locator(".facet__list.js-facet-list.js-facet-top-values > li:nth-child(3) > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg").first().click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Price")).click();
            page.locator("#facet-price > .facet__values > .facet__list > li:nth-child(2) > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless")).click();
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless"))).isVisible();
            assertThat(page.getByText("668972707").nth(1)).isVisible();
            assertThat(page.getByText("$164.98")).isVisible();
            assertThat(page.getByText("Adaptive noise cancelling")).isVisible();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items"))).isVisible();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).click();
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Your Shopping Cart(1 Item)"))).isVisible();
            assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless"))).isVisible();
            assertThat(page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Quantity, edit and press"))).isVisible();
            assertThat(page.getByText("$").first()).isVisible();
            page.getByText("FAST In-Store PickupDePaul").click();
            assertThat(page.getByText("Subtotal $")).isVisible();
            assertThat(page.locator(".js-cart-totals > div:nth-child(2)")).isVisible();
            assertThat(page.getByText("Taxes TBD")).isVisible();
            assertThat(page.getByText("Estimated Total $")).isVisible();
            //page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply Promo Code")).click();
            //assertThat(page.getByText("The coupon code entered is")).isVisible();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed To Checkout")).first().click();
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Create Account"))).isVisible();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed As Guest")).click();
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contact Information"))).isVisible();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).fill("Rohan");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).fill("Sahoo");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).fill("rsahoo@depaul.edu");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).fill("6307858662");
            assertThat(page.getByText("Order Subtotal $").nth(1)).isVisible();
            assertThat(page.locator(".bned-order-summary-container.bned-step-summary-inner-container > .bned-order-summary-order-totals > .subtotals > div:nth-child(2)")).isVisible();
            assertThat(page.getByText("Tax TBD").nth(1)).isVisible();
            assertThat(page.getByText("Total $167.98 167.98 $").nth(1)).isVisible();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Contact Information"))).isVisible();
            assertThat(page.getByText("Rohan Sahoo")).isVisible();
            assertThat(page.getByText("rsahoo@depaul.edu")).isVisible();
            assertThat(page.getByText("16307858662")).isVisible();
            assertThat(page.getByText("Pickup Location DePaul")).isVisible();
            assertThat(page.getByText("Pickup Person I'll pick them")).isVisible();
            assertThat(page.getByText("Order Subtotal $").nth(1)).isVisible();
            assertThat(page.locator(".bned-order-summary-container.bned-step-summary-inner-container > .bned-order-summary-order-totals > .subtotals > div:nth-child(2)")).isVisible();
            assertThat(page.getByText("Tax TBD").nth(1)).isVisible();
            assertThat(page.getByText("Total $167.98 167.98 $").nth(1)).isVisible();
            assertThat(page.locator("div:nth-child(4) > .bned-order-summary-entries-wp > .bned-order-summary-entry > .bned-order-summary-entry-details-wp")).isVisible();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            assertThat(page.getByText("Order Subtotal $").nth(1)).isVisible();
            assertThat(page.locator(".bned-order-summary-container.bned-step-summary-inner-container > .bned-order-summary-order-totals > .subtotals > div:nth-child(2)")).isVisible();
            assertThat(page.getByText("Tax $").nth(1)).isVisible();
            assertThat(page.getByText("Total $185.20 185.2 $").nth(1)).isVisible();
            assertThat(page.getByText("PICKUP DePaul University Loop Campus & SAIC JBL Quantum True Wireless Noise").nth(1)).isVisible();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Back to cart")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove product JBL Quantum")).click();
            assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Your cart is empty"))).isVisible();
        }
    }
}
