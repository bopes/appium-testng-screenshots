package com.browserstack;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;

import java.io.File;

public class Homepage extends BrowserStackTestNGTest {

    @Test
    public void test() throws Exception {

        Thread.sleep(2500);

        // Save screenshot of app's homescreen
        File srcFile = driver.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("target/surefire-reports/screenshots/homepage-" + language +".png");
        FileUtils.copyFile(srcFile,targetFile);

    }
}
