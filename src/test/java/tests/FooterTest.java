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
    Footer footer;
    @BeforeEach
    void setFooter() {
        footer = new Footer(driver);
        footer.handleCookies();
    }

    @Test
    void test_If_Able_To_Navigate_Through_Pages(){
        footer.browsingThroughPages();
        footer.verifyURL("https://yeti.org.pl/o-nas/");
    }

    @Test
    void test_If_Can_SignUp_For_Newsletter() {
        new Footer(driver).signupForNewsletter("marcin@wp.pl");
        Assertions.assertEquals("Sprawdź skrzynkę!\n" +
                "Potwierdź, że chcesz otrzymywać newsletter.",footer.find(footer.footer_sub).getText());
    }

    @Test
    void test_If_Polityka_Prywatnosci_Redirect_To_Repsective_Page() {

        footer.footer_PolitykaPrywatnosci.click();
        footer.verifyURL("https://yeti.org.pl/polityka-prywatnosci");
    }

    @Test
    void test_If_WebCrafter_Redirect_To_Repsective_Page() {
        footer.redirectToWebCrafter();
        footer.verifyURL("https://webcrafters.studio/");
    }

    @Test
    void test_If_Zofia_Redirect_To_Repsective_Page() {
        footer.redirectToZofia();
        footer.verifyURL("http://rusinowska.pl/");
    }

    @Test
    void test_If_Yt_Redirect_To_Repsective_Page() {
   footer.footer_Yt.click();
   footer.verifyURL("https://yeti.org.pl/#");
    }

    @Test
    void test_If_Ig_Redirect_To_Repsective_Page() {
        footer.footer_Ig.click();
        footer.verifyURL("https://www.instagram.com/kn_yeti/");
    }

    @Test
    void test_If_Fb_Redirect_To_Repsective_Page() {
        footer.footer_Fb.click();
        footer.verifyURL("https://www.facebook.com/klubyeti");
    }

    @Test
    void test_If_logowanie_Redirect_To_Repsective_Page() {
        footer.footer_logowanie.click();
        footer.verifyURL("https://yeti.org.pl/logowanie/");
    }

    @Test
    void test_If_galeria_Redirect_To_Repsective_Page() {
       footer.footer_galeria.click();
        footer.verifyURL("https://yeti.org.pl/galeria");
    }

    @Test
    void test_If_wyjazdy_Redirect_To_Repsective_Page() {
       footer.footer_wyjazdy.click();
        footer.verifyURL("https://yeti.org.pl/wyjazdy/");
    }

    @Test
    void test_If_treningi_Redirect_To_Repsective_Page() {
        footer.footer_treningi.click();
        footer.verifyURL("https://yeti.org.pl/treningi");
    }

    @Test
    void test_If_newsy_Redirect_To_Repsective_Page() {
        footer.footer_newsy.click();
        footer.verifyURL("https://yeti.org.pl/newsy/");
    }

    @Test
    void test_If_oNas_Redirect_To_Repsective_Page() {
        footer.footer_oNas.click();
        footer.verifyURL("https://yeti.org.pl/o-nas/");
    }

    @Test
    void test_If_strona_Glowna_Redirect_To_Repsective_Page() {
       footer.footer_strona_Glowna.click();
        footer.verifyURL("https://yeti.org.pl/");
    }
}