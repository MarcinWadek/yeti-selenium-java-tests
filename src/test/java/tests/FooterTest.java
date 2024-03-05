package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Footer;

import static org.assertj.core.api.Assertions.assertThat;

public class FooterTest {

    WebDriver driver;
    Footer footer;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        footer = new Footer(driver);
        footer.handleCookies();
        footer.goDown();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }


    @Test
    void yeti() {
        Assertions.assertTrue(footer.isImageDisplayed(footer.getFooter_logo()));
    }

    @Test
    void test_If_Can_SignUp_For_Newsletter() {
        footer.signupForNewsletter("marcin@wp.pl");
        Assertions.assertEquals("Sprawdź skrzynkę!\n" +
                "Potwierdź, że chcesz otrzymywać newsletter.",driver.findElement(By.xpath("(//span[@id='es_subscription_message_65e489eb12726'])[1]")).getText());
    }

    @Test
    void test_If_Polityka_Prywatnosci_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_PolitykaPrywatnosci());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/polityka-prywatnosci");
    }

    @Test
    void test_If_WebCrafter_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_WebCrafter());

        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://webcrafters.studio/", currentUrl);
    }

    @Test
    void test_If_Zofia_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_Zofia());
        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://rusinowska.pl/", currentUrl);
    }

    @Test
    void test_If_Yt_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_Yt());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/#");
    }

    @Test
    void test_If_Ig_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_Ig());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.instagram.com/kn_yeti/");
    }

    @Test
    void test_If_Fb_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_Fb());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.facebook.com/klubyeti");
    }

    @Test
    void test_If_logowanie_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_logowanie());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/logowanie/");
    }

    @Test
    void test_If_galeria_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_galeria());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/galeria");
    }

    @Test
    void test_If_wyjazdy_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_wyjazdy());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/wyjazdy/");
    }

    @Test
    void test_If_treningi_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_treningi());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/treningi");
    }

    @Test
    void test_If_newsy_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_newsy());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/newsy/");
    }

    @Test
    void test_If_oNas_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_oNas());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/o-nas/");
    }

    @Test
    void test_If_strona_Glowna_Redirect_To_Repsective_Page() {
        footer.clickElement(footer.getFooter_strona_Glowna());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/");
    }
}