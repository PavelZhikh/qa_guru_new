package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckRegistrationPage {
    public void checkModalHead(String value) {
        $(".modal-header").shouldHave(text(value));
    }

    public void checkFields(String key, String value) {
        $(".table-responsive").$(byText(key)).parent().shouldBe(text(value));
    }

}
