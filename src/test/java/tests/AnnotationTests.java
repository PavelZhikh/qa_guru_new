package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
//import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AnnotationTests {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 20000;
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
    void searchWithoutParameterizedParameters(){

        $(".navigation-search-btn").click();
        $(".navigation-search-popup__input").setValue("ЦСКА");
        $$(".navigation-search-results__list").shouldBe(sizeGreaterThan(0));
    }

    @ValueSource(strings = {
            "Спартак", "Динамо"
    })
    @ParameterizedTest(name = "Тестирование @ValueSource, поиск {0}")
    @Tag("Sports")
    void searchUsingValueSource(String searchQuery){

        $(".navigation-search-btn").click();
        $(".navigation-search-popup__input").setValue(searchQuery);
        $$(".navigation-search-results__list").shouldBe(sizeGreaterThan(0));
    }

    @CsvSource(value = {
            "Зенит, Футбол",
            "Локомотив, Хоккей"
    })
    @ParameterizedTest(name = "Тестирование @CsvSource, поиск {0}, сравнение с {1}")
    @Tag("Sports")
    void searchUsingCsvSource(String searchQuery, String expectedValue){

        $(".navigation-search-btn").click();
        $(".navigation-search-popup__input").setValue(searchQuery);
        $(".navigation-search-results__anchor").shouldHave(text(expectedValue));
    }

    @CsvFileSource(resources = "/test_data/searchUsingCsvFileSource.csv")
    @ParameterizedTest(name = "Тестирование @CsvFileSource, поиск {0}, сравнение с {1}")
    @Tag("Sports")
    void searchUsingCsvFileSource(String searchQuery, String expectedValue){

        $(".navigation-search-btn").click();
        $(".navigation-search-popup__input").setValue(searchQuery);
        $(".navigation-search-results__anchor").shouldHave(text(expectedValue));
    }

    static Stream<Arguments> sportsSiteShouldDisplayCorrectButtons() {
        return Stream.of(
                Arguments.of(
                        List.of("Моя лента", "Ставки", "Футбол", "Фигурка", "Хоккей", "Баскет",
                                "Теннис", "Бокс", "Авто", "Здоровье", "Медиафутбол", "Прожектор")
                )
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Тестирование @MethodSource, проверка кнопок")
    @Tag("Sports")
    void sportsSiteShouldDisplayCorrectButtons(List<String> expectedButtons){
        $$(".navigation-navbar__list li").filter(visible)
                .shouldHave(texts(expectedButtons));
    }
}



