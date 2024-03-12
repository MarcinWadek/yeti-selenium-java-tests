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


    @Test
    void test_Rontil_Page_Opens_Upon_Clicking_On_Logo() {
    new Glowna(driver).redirectToRontil();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://rontil.com.pl/pl/", currentUrl);
    }

    @Test
    void test_KrzysiekPomaga_Page_Opens_Upon_Clicking_On_Logo() {
        new Glowna(driver).redirectToKrzysiek();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://krzysiekpomaga.org/", currentUrl);
    }

    @Test
    void test_Head_Page_Opens_Upon_Clicking_On_Logo() {
        new Glowna(driver).redirectToHead();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.head.com/pl_PL/", currentUrl);
    }

    @Test
    void test_LekarzSport_Page_Opens_Upon_Clicking_On_Logo() {
        new Glowna(driver).redirectToLekarzSport();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://lekarzsport.pl/", currentUrl);

    }

    @Test
    void test_TrainToWin_Page_Opens_Upon_Clicking_On_Logo() {
        new Glowna(driver).redirectToTraintoWin();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://traintowin.pl/", currentUrl);
    }

    @Test
    void test_JulekPeszko_Page_Opens_Upon_Clicking_On_Logo() {
        new Glowna(driver).redirectToJulek();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://juliuszpeszko.pl/", currentUrl);
    }

    @Test
    void test_GoSnow_Page_Opens_Upon_Clicking_On_Logo() {
        new Glowna(driver).redirectToGoSnow();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://go-snow.pl/", currentUrl);
    }

}
