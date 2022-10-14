import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideGithubTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @DisplayName("Checking for JUnit5 sample code on the SoftAssertions page on Github")
    @Test
    void junitSampleCodeOnGithubSearchTest() {
        open("https://github.com");
        $("input[type='text']").setValue("selenide").pressEnter();
        $$(".repo-list li").first().$("a").click();
        $("[id=wiki-tab]").click();
        $("input[placeholder='Find a page…']").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();
        $("[id=wiki-wrapper]").shouldHave(text("Using JUnit4"));

    }

}
