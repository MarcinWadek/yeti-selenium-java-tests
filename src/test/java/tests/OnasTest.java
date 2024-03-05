package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.Onas;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class OnasTest {


    WebDriver driver;
    Onas onas;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        onas = new Onas(driver);
        onas.handleCookies();
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void test_Photo_Yeti_Is_Displayed(){
        Assertions.assertTrue(onas.isImageDisplayed(onas.getPhotoYeti()));
    }
    @Test
    void test_Accurate_Title_In_HTML_Addres(){
        assertThat(driver.getTitle()).isEqualTo("O Nas - Yeti");
    }
    @Test
    void _test_Page_Source_Not_Corrupted(){
        assertThat(driver.getPageSource()).containsIgnoringCase("</html>");
    }

}
