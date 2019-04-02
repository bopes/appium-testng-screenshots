package com.browserstack;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.net.URL;
import java.util.Map;


public class BrowserStackTestNGTest {
    public AndroidDriver<AndroidElement> driver;
    public String language;

    @BeforeMethod(alwaysRun=true)
    @org.testng.annotations.Parameters(value={"config", "environment"})
    public void setUp(String config_file, String environment) throws Exception {


        // Define Common Desired Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("browserstack.user","<BrowserStack_username>");
        capabilities.setCapability("browserstack.key", "<BrowserStack_accesskey>");

        capabilities.setCapability("build","Localization");

        capabilities.setCapability("device","Google Pixel");
        capabilities.setCapability("app","<uploaded_app_url>");


        // Get environment-specific capabilities from config JSON
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
        JSONObject envs = (JSONObject) config.get("environments");

        Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
        for (Map.Entry<String, String> pair : envCapabilities.entrySet()) {
            capabilities.setCapability(pair.getKey(), pair.getValue());
        }


        // Store the language for future use when saving screenshots
        language = envCapabilities.get("language");


        // Launch driver
        driver = new AndroidDriver(new URL("http://hub-cloud.browserstack.com/wd/hub"), capabilities);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
