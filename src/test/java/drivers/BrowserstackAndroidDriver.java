package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackAndroidDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("platformName", "android");
        caps.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:app", "bs://sample.app");
//        Для новой версии вики
//        caps.setCapability("appium:app", "bs://206d07292e9b4056d5d41f099ebbc79aa9360185");

        HashMap<String, Object> bstackOptions = new HashMap<>();

        bstackOptions.put("userName", System.getProperty("user_name"));
        bstackOptions.put("accessKey", System.getProperty("access_key"));
        bstackOptions.put("appiumVersion", "2.12.1");
        bstackOptions.put("projectName", "First Java Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_test");

        caps.setCapability("bstack:options", bstackOptions);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new AndroidDriver(
                    new URL(System.getProperty("browserstack_url")), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}