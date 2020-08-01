package com.awesome.testing.appium.android;

import com.awesome.testing.appium.ExampleFluentTest;
import com.awesome.testing.appium.app.android.SwiftNoteHomePage;
import org.apache.commons.io.FileUtils;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class AndroidSwiftNotesApp extends ExampleFluentTest {

    private static final String SAMPLE_TITLE = "SampleTitle";
    private static final String SAMPLE_BODY = "SampleBody";

    @Page
    private SwiftNoteHomePage noteApp;

    @Test
    public void shouldCorrectlyAddNote() {
        noteApp
                .verifyIfIsLoaded()
                .verifyNoteCount(0)
                .clickAddNote()
                .addNote(SAMPLE_TITLE, SAMPLE_BODY)
                .verifyIfIsLoaded()
                .verifyNoteCount(1)
                .clickAddNote()
                .addNoteUsingAdb(SAMPLE_TITLE, SAMPLE_BODY, appiumDriver)
                .verifyIfIsLoaded()
                .verifyNoteCount(2);
    }

    @Test
    public void searchTest() {
        noteApp.search("FluentLenium");
    }

    @Test
    public void screenshotTest() throws IOException {
        File file  = ((TakesScreenshot)appiumDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("Screenshot.jpg"));
    }

}

