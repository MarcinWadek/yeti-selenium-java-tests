package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Footer;
import pages.Glowna;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GlownaTest {

    WebDriver driver;
    Glowna glowna;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        glowna = new Glowna(driver);

        driver.get("https://yeti.org.pl/");
        glowna.handleCookies();
    }
    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test_Rontil_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.clickElement(glowna.getRontil());

        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://rontil.com.pl/pl/", currentUrl);
    }

    @Test
    void test_KrzysiekPomaga_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.clickElement(glowna.getKrzysiekPomaga());

        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://krzysiekpomaga.org/", currentUrl);
    }

    @Test
    void test_Head_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.clickElement(glowna.getHead());

        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.head.com/pl_PL/", currentUrl);
    }

    @Test
    void test_LekarzSport_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.clickElement(glowna.getLekarzSport());

        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://lekarzsport.pl/", currentUrl);

    }

    @Test
    void test_TrainToWin_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.clickElement(glowna.getTrainToWin());

        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://traintowin.pl/", currentUrl);
    }

    @Test
    void test_JulekPeszko_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.clickElement(glowna.getJulekPeszko());

        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://juliuszpeszko.pl/", currentUrl);
    }

    @Test
    void test_GoSnow_Page_Opens_Upon_Clicking_On_Logo() {
        glowna.clickElement(glowna.getGoSnow());

        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("http://go-snow.pl/", currentUrl);
    }

}
