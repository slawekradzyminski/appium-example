package appium.android;

import appium.ExampleFluentTest;
import appium.app.android.SwiftNoteHomePage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

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
                .addNote(SAMPLE_TITLE, SAMPLE_BODY)
                .verifyIfIsLoaded()
                .verifyNoteCount(2);
    }

    @Test
    public void searchTest() {
        noteApp.search("FluentLenium");
    }

}

