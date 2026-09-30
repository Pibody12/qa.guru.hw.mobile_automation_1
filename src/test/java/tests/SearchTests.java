package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.AppiumBy.androidUIAutomator;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.className;

public class SearchTests extends TestBase {


    @Test
    void successfulSearchTest() {

        step("Переход на страницу поиска", () -> {
            ((AndroidDriver) getWebDriver())
                    .pressKey(new KeyEvent(AndroidKey.BACK));
            $(id("org.wikipedia:id/nav_tab_search")).click();
            ((AndroidDriver) getWebDriver())
                    .pressKey(new KeyEvent(AndroidKey.BACK));
        });

        step("Ввод поискового запроса", () -> {
            $(id("search_text_view")).click();
            $(id("org.wikipedia:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверка результата поиска", () -> {
        $$(id("org.wikipedia:id/search_lang_button_container"))
                .shouldHave(sizeGreaterThan(0));
        });
    }

    @Test
    void successfulSecondSearchTest() {

        step("Переход на страницу поиска", () -> {
            ((AndroidDriver) getWebDriver())
                    .pressKey(new KeyEvent(AndroidKey.BACK));
            $(id("org.wikipedia:id/nav_tab_search")).click();
            ((AndroidDriver) getWebDriver())
                .pressKey(new KeyEvent(AndroidKey.BACK));
        });

        step("Ввод поискового запроса", () -> {
            $(id("search_text_view")).click();
            $(id("org.wikipedia:id/search_src_text")).sendKeys("quality assurance");
        });

        step("Открытие статьи", () -> {
            $(androidUIAutomator(
                    "new UiSelector().className(\"android.view.View\").childSelector(new UiSelector().text(\"Quality assurance\"))"
            )).click();
        });

        step("Проверка результата поиска", () -> {
            $$(className("android.webkit.WebView"))
                    .findBy(text("Quality assurance"))
                    .shouldBe(visible);
        });
    }
}