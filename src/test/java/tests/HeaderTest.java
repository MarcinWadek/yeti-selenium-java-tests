package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Header;

public class HeaderTest extends BaseTest {


    Header header;

    @BeforeEach
    void setHeader() {
        header = new Header(driver);
        header.handleCookies();
    }

    @Test
    void navigatingThroughPages() {
        header.browsingThroughPages();
        header.verifyURL("https://yeti.org.pl/");
    }
}
