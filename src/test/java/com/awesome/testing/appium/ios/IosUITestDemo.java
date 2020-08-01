package com.awesome.testing.appium.ios;

import com.awesome.testing.appium.ExampleFluentTest;
import com.awesome.testing.appium.app.ios.HomePage;
import org.apache.commons.io.FileUtils;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class IosUITestDemo extends ExampleFluentTest {

    @Page
    private HomePage homePage;

    @Test
    public void shouldCorrectlySwitchView() {
        homePage.clickAboutLink().verifyIfIsLoaded();
    }

    @Test
    public void shouldCorrectlyAddNote() {
        String noteName = "Sample Note";
        String noteDescription = "SampleNoteDescription";

        homePage
                .clickAddButton()
                .addName(noteName, noteDescription)
                .clickAboutLink()
                .verifyIfIsLoaded();
    }

    @Test
    public void screenshotTest() throws IOException {
        File file  = ((TakesScreenshot)appiumDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("Screenshot.jpg"));
    }
}
