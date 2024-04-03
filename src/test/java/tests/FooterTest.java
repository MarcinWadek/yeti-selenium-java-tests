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
        footer.browsingThroughPages()
                .verifyURL(config.getApplicationURL());
    }

    @Test
    void test_If_Can_SignUp_For_Newsletter() {
        footer.signupForNewsletter("marcin@wp.pl");
        footer.assertSubConfirmationText("Sprawdź skrzynkę!\n" +
                "Potwierdź, że chcesz otrzymywać newsletter.");
    }

    @Test
    void test_If_Polityka_Prywatnosci_Redirect_To_Repsective_Page() {

        footer.redirectToPolicyPage()
                .verifyURL("https://yeti.org.pl/polityka-prywatnosci/");
    }

    @Test
    void test_If_WebCrafter_Redirect_To_Repsective_Page() {
        footer.redirectToWebCrafter()
        .verifyURL("https://webcrafters.studio/");
    }

    @Test
    void test_If_Zofia_Redirect_To_Repsective_Page() {
        footer.redirectToZofia()
        .verifyURL("http://rusinowska.pl/");
    }

    @Test
    void test_If_Yt_Redirect_To_Repsective_Page() {
   footer.redirectToYoutube()
    .verifyURL("https://yeti.org.pl/#");
    }

    @Test
    void test_If_Ig_Redirect_To_Repsective_Page() {
        footer.redirectToInstagram()
        .verifyURL("https://www.instagram.com/kn_yeti/");
    }

    @Test
    void test_If_Fb_Redirect_To_Repsective_Page() {
        footer.redirectToFacebook()
        .verifyURL("https://www.facebook.com/klubyeti");
    }

}