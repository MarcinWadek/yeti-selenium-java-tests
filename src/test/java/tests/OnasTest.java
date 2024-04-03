package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.Onas;

import static org.assertj.core.api.Assertions.assertThat;

public class OnasTest extends BaseTest{

    Onas onas;

    @BeforeEach
    void setOnas() {
        driver.get(config.getAboutUsURL());
        onas = new Onas(driver);

    }
    @Test
    void test_Accurate_Title_In_HTML_Addres() {
        onas.assertPageTitle("o nas");
    }
    @Test
    void _test_Page_Source_Not_Corrupted(){
        assertThat(driver.getPageSource()).containsIgnoringCase("</html>");
    }
}
