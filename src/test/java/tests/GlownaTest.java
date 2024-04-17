package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Glowna;

public class GlownaTest extends BaseTest {

    Glowna glowna;

    @BeforeEach
    void setGlowna() {
        glowna = new Glowna(driver);
        glowna.setTimeoutSec(20);
        glowna.handleCookies();
    }

    @Test
    @Epic("Page Responsiveness")
    @Feature("MainPage")
    @DisplayName("Rontil hyperlink responsiveness")
    void test_Rontil_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToRontil()
                .verifyURL("https://rontil.com.pl/pl/");
    }

    @Test
    @Epic("Page Responsiveness")
    @Feature("MainPage")
    @DisplayName("KrzysiekPomaga hyperlink responsiveness")
    void test_KrzysiekPomaga_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToKrzysiek()
                .verifyURL("https://krzysiekpomaga.org/");
    }

    @Test
    @Epic("Page Responsiveness")
    @Feature("MainPage")
    @DisplayName("Head hyperlink responsiveness")
    void test_Head_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToHead()
                .verifyURL("https://www.head.com/pl_PL/");
    }

    @Test
    @Epic("Page Responsiveness")
    @Feature("MainPage")
    @DisplayName("LekarzSport hyperlink responsiveness")
    void test_LekarzSport_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToLekarzSport()
                .verifyURL("https://lekarzsport.pl/");

    }

    @Test
    @Epic("Page Responsiveness")
    @Feature("MainPage")
    @DisplayName("TrainToWin hyperlink responsiveness")
    void test_TrainToWin_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToTraintoWin()
                .verifyURL("https://yeti.org.pl/");
    }

    @Test
    @Epic("Page Responsiveness")
    @Feature("MainPage")
    @DisplayName("JulekPeszko hyperlink responsiveness")
    void test_JulekPeszko_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToJulek()
                .verifyURL("https://juliuszpeszko.pl/");
    }

    @Test
    @Epic("Page Responsiveness")
    @Feature("MainPage")
    @DisplayName("GoSnow hyperlink responsiveness")
    void test_GoSnow_Page_Opens_Upon_Clicking_On_Logo() {
        new Glowna(driver).redirectToGoSnow()
                .verifyURL("https://go-snow.pl/");
    }

}
