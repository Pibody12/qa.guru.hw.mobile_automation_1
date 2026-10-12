package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.appium.java_client.AppiumBy.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.error.ShouldBe.shouldBe;
import static org.openqa.selenium.By.className;

public class IosSearchTests extends TestBaseIos {

    @Test
    void successfulSearchTest() {

        step("Нажать кнопку Text", () -> {
            $(accessibilityId("Text")).click();
        });

        step("Проверка кнопку текста на экране", () -> {
            $(accessibilityId("Text Output")).shouldBe(visible)
                    .shouldHave(text("Waiting for text input."));
        });
    }
}