package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Footer;
import pages.Header;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class HeaderTest {

    WebDriver driver;
    Header header;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        header = new Header(driver);
        header.handleCookies();
    }
    @AfterEach
    void teardown(){
        driver.quit();
    }
    @Test
    void test_If_logowanie_Redirect_To_Repsective_Page(){
        header.clickElement(header.getHeader_Logowanie());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/logowanie/");
    }
    @Test
    void test_If_galeria_Redirect_To_Repsective_Page(){
        header.clickElement(header.getHeader_Galeria());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/galeria");
    }
    @Test
    void test_If_wyjazdy_Redirect_To_Repsective_Page(){
        header.clickElement(header.getHeader_Wyjazdy());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/wyjazdy/");
    }
    @Test
    void test_If_treningi_Redirect_To_Repsective_Page(){
        header.clickElement(header.getHeader_Treningi());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/treningi");
    }
    @Test
    void test_If_newsy_Redirect_To_Repsective_Page(){
        header.clickElement(header.getHeader_Newsy());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/newsy/");
    }
    @Test
    void test_If_oNas_Redirect_To_Repsective_Page(){
        header.clickElement(header.getHeader_ONas());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/o-nas/");
    }
    @Test
    void test_If_strona_Glowna_Redirect_To_Repsective_Page(){
        header.clickElement(header.getHeader_Strona_Glowna());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/");
    }
}
