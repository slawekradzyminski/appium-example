package com.awesome.testing.appium.app.ios;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;

public class AddPage extends FluentPage {

    @iOSXCUITFindBy(accessibility = "Save")
    private FluentWebElement saveButton;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeTextField")
    private FluentWebElement noteNameSelector;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther[4]/XCUIElementTypeTextView")
    private FluentWebElement noteDescriptionSelector;

    /**
     * There is quite a few issues regarding input clearing in iOS.
     * See details https://github.com/appium/appium/issues/13288.
     */
    public HomePage addName(String noteName, String noteDescription) {
        await().until(noteNameSelector).displayed();

        noteNameSelector.fill().with(noteName);
        noteDescriptionSelector.fill().with(noteDescription);
        saveButton.click();
        return newInstance(HomePage.class);
    }

}
