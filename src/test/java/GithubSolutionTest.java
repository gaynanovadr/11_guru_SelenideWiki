import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class GithubSolutionTest {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @DisplayName("Checking that Enterprise Page is opened after hover on Solution on Github")
    @Test
    void openEnterprisePageOnGithubTest() {
        open("https://github.com");
        $(byText("Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $(".application-main").shouldHave(text("Build like the best"));
    }

    @DisplayName("Checking that Drag&Drop works")
    @Test
    void dragAndDropTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        $("#column-a").dragAndDropTo($("#column-b"));
        //actions().moveToElement($("#column-a")).clickAndHold().scrollByAmount(200,1).release().perform(); // moveByOffset(120,700).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @DisplayName("Checking that Drag&Drop with Selenide Actions works") //does not work
    @Test
    void dragAndDropWithActionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        actions().moveToElement($("#column-a")).clickAndHold().scrollByAmount(200, 1).release().perform(); //does not work
        // moveByOffset(700,120).release().perform();                                                                            //does not work
        //moveToElement($("#column-b")).release().perform();                                                                     //does not work
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
