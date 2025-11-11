import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import java.util.regex.Pattern;

public class flipkkart {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.flipkart.com/");
      page.locator("div").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^Login$"))).first().click();
      page.locator("form").filter(new Locator.FilterOptions().setHasText("Enter Email/Mobile numberBy")).getByRole(AriaRole.TEXTBOX).click();
      page.locator("form").filter(new Locator.FilterOptions().setHasText("Enter Email/Mobile numberBy")).getByRole(AriaRole.TEXTBOX).fill("8982448082");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Request OTP")).click();
      page.getByRole(AriaRole.TEXTBOX).nth(1).fill("8");
      page.getByRole(AriaRole.TEXTBOX).nth(2).fill("2");
      page.getByRole(AriaRole.TEXTBOX).nth(3).fill("7");
      page.getByRole(AriaRole.TEXTBOX).nth(4).fill("5");
      page.getByRole(AriaRole.TEXTBOX).nth(5).fill("6");
      page.locator("div:nth-child(6) > .r4vIwl").fill("4");
      page.locator("._1ui5b4").click();
    }
  }
}