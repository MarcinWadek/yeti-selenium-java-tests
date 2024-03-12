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
import pages.Header;

import static org.assertj.core.api.Assertions.assertThat;

public class FooterTest extends BaseTest {


    @Test
    void navigatingThroughPages(){
        new Footer(driver).browsingThroughPages();
    }

    @Test
    void test_If_Can_SignUp_For_Newsletter() {
        new Footer(driver).signupForNewsletter("marcin@wp.pl");
//        Assertions.assertEquals("Sprawdź skrzynkę!\n" +
//                "Potwierdź, że chcesz otrzymywać newsletter.",driver.findElement(By.xpath("(//span[@id='es_subscription_message_65e489eb12726'])[1]")).getText());
//    }
    }
    @Test
    void test_If_Polityka_Prywatnosci_Redirect_To_Repsective_Page() {
        Footer footer = new Footer(driver);
        footer.footer_PolitykaPrywatnosci.click();
        footer.verifyURL("https://yeti.org.pl/polityka-prywatnosci");
    }

    @Test
    void test_If_WebCrafter_Redirect_To_Repsective_Page() {
        Footer footer = new Footer(driver);
        footer.redirectToWebCrafter();
        footer.verifyURL("https://webcrafters.studio/");
    }

    @Test
    void test_If_Zofia_Redirect_To_Repsective_Page() {
        Footer footer = new Footer(driver);
        footer.redirectToZofia();
        footer.verifyURL("http://rusinowska.pl/");
    }

    @Test
    void test_If_Yt_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_Yt.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/#");
    }

    @Test
    void test_If_Ig_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_Ig.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.instagram.com/kn_yeti/");
    }

    @Test
    void test_If_Fb_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_Fb.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://www.facebook.com/klubyeti");
    }

    @Test
    void test_If_logowanie_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_logowanie.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/logowanie/");
    }

    @Test
    void test_If_galeria_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_galeria.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/galeria");
    }

    @Test
    void test_If_wyjazdy_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_wyjazdy.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/wyjazdy/");
    }

    @Test
    void test_If_treningi_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_treningi.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/treningi");
    }

    @Test
    void test_If_newsy_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_newsy.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/newsy/");
    }

    @Test
    void test_If_oNas_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_oNas.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/o-nas/");
    }

    @Test
    void test_If_strona_Glowna_Redirect_To_Repsective_Page() {
        new Footer(driver).footer_strona_Glowna.click();
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/");
    }
}