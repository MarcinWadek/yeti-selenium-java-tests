package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;

import static org.assertj.core.api.Assertions.assertThat;

public class HeaderTest extends BaseTest {


    Header header;

    @BeforeEach
    void setHeader() {
        header = new Header(driver);
    }

    @Test
    void navigatingThroughPages() {
        header.browsingThroughPages();
        header.verifyURL("https://yeti.org.pl/o-nas/");
    }
}
