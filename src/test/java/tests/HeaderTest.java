package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @Epic("Navigation")
    @Feature("MainPage")
    @DisplayName("Page navigation through header buttons")
    void navigatingThroughPages() {
        header.browsingThroughPages();
        header.verifyURL("https://yeti.org.pl/");
    }
}
