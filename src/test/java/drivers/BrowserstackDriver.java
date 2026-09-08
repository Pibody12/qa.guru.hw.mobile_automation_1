package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        caps.setCapability("platformName", "android");
        caps.setCapability("appium:deviceName", "Samsung Galaxy S22 Ultra");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:app", "bs://sample.app");

        HashMap<String, Object> bstackOptions = new HashMap<>();

        bstackOptions.put("userName", "bsuser_wRTViP");
        bstackOptions.put("accessKey", "zHJ52YppsoNf9U4pYaTz");
//        bstackOptions.put("appiumVersion", "2.0.1");
        bstackOptions.put("projectName", "First Java Project");
        bstackOptions.put("buildName", "browserstack-build-1");
        bstackOptions.put("sessionName", "first_test");

        caps.setCapability("bstack:options", bstackOptions);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}