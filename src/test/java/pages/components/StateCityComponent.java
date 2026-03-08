package pages.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateCityComponent {
    public void setStateCity(String state, String city) {
        $("#state").$(byText(state)).shouldBe(Condition.visible).click();
        $("#city").click();
        $("#city").$(byText(city)).shouldBe(Condition.visible).click();
    }

}
