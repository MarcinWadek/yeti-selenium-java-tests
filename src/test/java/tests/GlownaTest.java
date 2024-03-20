package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Glowna;

public class GlownaTest extends BaseTest{

    Glowna glowna;

    @BeforeEach
    void setGlowna(){
        glowna = new Glowna(driver);
        glowna.setTimeoutSec(20);
        glowna.handleCookies();
    }

    @Test
    void test_Rontil_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToRontil()
                .verifyURL("https://rontil.com.pl/pl/");
    }

    @Test
    void test_KrzysiekPomaga_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToKrzysiek()
                .verifyURL("https://krzysiekpomaga.org/");
    }

    @Test
    void test_Head_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToHead()
         .verifyURL("https://www.head.com/pl_PL/");
    }

    @Test
    void test_LekarzSport_Page_Opens_Upon_Clicking_On_Logo() {
       glowna.redirectToLekarzSport()
               .verifyURL("https://lekarzsport.pl/");

    }

    @Test
    void test_TrainToWin_Page_Opens_Upon_Clicking_On_Logo() {
       glowna.redirectToTraintoWin()
               .verifyURL("https://traintowin.pl/");
    }

    @Test
    void test_JulekPeszko_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.redirectToJulek()
        .verifyURL("https://juliuszpeszko.pl/");
    }

    @Test
    void test_GoSnow_Page_Opens_Upon_Clicking_On_Logo() {
        new Glowna(driver).redirectToGoSnow()
                .verifyURL("http://go-snow.pl/");
    }

}
