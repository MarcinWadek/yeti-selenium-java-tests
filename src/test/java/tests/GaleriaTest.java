package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Galeria;
import pages.Glowna;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class GaleriaTest {


    WebDriver driver;
    Galeria galeria;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        galeria = new Galeria(driver);

        driver.get("https://yeti.org.pl/galeria");
        galeria.handleCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test_If_Photos_Are_Displayed() {
        galeria.seePhotos(galeria.getFerieGaleria(), galeria.getPhotoOne());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/galeria/ferie-1/");
    }

    @Test
    void test_Album_Is_Displayed() {
        galeria.seeAbum(galeria.getStyczniowyGaleria());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/galeria/styczniowy-2024/");
    }

    @Test
    void test_If_Can_See_More_Photos() {
        galeria.seeMorePhotos();
    }

    @Test
    void test_Galeria_Fileter() {
        galeria.filtrGaleria(galeria.getRok2016(), galeria.getRolkiSport());
    }

    @Test
    void test_If_Clear_Galeria_Clears() {
        galeria.seeMorePhotos();
        galeria.clearGaleria();
    }
}
