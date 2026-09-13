package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() {

        step("Ввод поискового запроса", () -> {
            $(id("org.wikipedia.alpha:id/search_container")).getWrappedElement().click();
            $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        });

        step("Проверка результата поиска", () -> {
        $$(className("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
        });
    }
}
