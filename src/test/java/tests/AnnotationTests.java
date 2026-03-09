package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AnnotationTests {

    @BeforeAll
    public static void setup() {
        Configuration.timeout = 70000;
        // Явно указываем, что браузер должен использовать UTF-8
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        // Эта настройка помогает браузеру понять, что страница в UTF-8
        capabilities.setCapability("acceptInsecureCerts", true); // пример
        Configuration.browserCapabilities = capabilities;

        // Устанавливаем кодировку для чтения ответов, если используете прокси Selenide
        // (обычно это помогает при тестировании API через Selenide)
        System.setProperty("file.encoding", "UTF-8");
        // Для старых версий Java может потребоваться
        java.nio.charset.Charset.defaultCharset().name();
    }

    @BeforeEach
    void setUPEach(){
        open("https://www.sports.ru/");
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }

    @Test
    @Tag("Sports")
    @DisplayName("Тестирование аннотаций, поиск 'ЦСКА'")
    void searchCska(){

        $(".navigation-search-btn").click();
        $(".navigation-search-popup__input").setValue("ЦСКА");
        $$(".navigation-search-results__list").shouldBe(sizeGreaterThan(0));
    }

    @ValueSource(strings = {
            "Спартак", "Динамо"
    })
    @ParameterizedTest(name = "Тестирование аннотаций, поиск {0}")
    @Tag("Sports")
    void searchTeamUsingValueSource(String searchQuery){

        $(".navigation-search-btn").click();
        $(".navigation-search-popup__input").setValue(searchQuery);
        $$(".navigation-search-results__list").shouldBe(sizeGreaterThan(0));
    }

    /*@ValueSource(strings = {
            "Зенит"
    })
    @ParameterizedTest(name = "Тестирование аннотаций, поиск {0}")
    @Tag("Sports")
    void searchTeamUsingValueSourceZenit(String searchQuery){

        $(".navigation-search-btn").click();
        $(".navigation-search-popup__input").setValue(searchQuery);
        $(".navigation-search-results__item").shouldHave(text("/football/club/zenit/"));
    }*/

}
