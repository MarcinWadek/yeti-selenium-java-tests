package tests;

import dataprovider.LogowanieDP;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Footer;

public class FooterTest extends BaseTest {
    Footer footer;
    LogowanieDP logowanieDP;
    @BeforeEach
    void setFooter() {
        footer = new Footer(driver);
        logowanieDP = new LogowanieDP();
        footer.handleCookies();
    }

    @Test
    void test_If_Able_To_Navigate_Through_Pages() {
        footer.browsingThroughPages()
                .verifyURL(config.getApplicationURL());
    }

    @Test
    void test_I_Can_SignUp_For_Newsletter() {
        footer.signupForNewsletter(logowanieDP.getUnregisteredEmail());

        footer.verifyURL("https://yeti.org.pl/#es_form_f1-n1");
    }

    @Test
    void test_If_Polityka_Prywatnosci_Redirect_To_Repsective_Page() {

        footer.redirectToPolicyPage()
                .verifyURL("https://yeti.org.pl/polityka-prywatnosci");
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