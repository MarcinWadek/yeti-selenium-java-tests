package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Galeria;

import static org.assertj.core.api.Assertions.assertThat;

public class GaleriaTest extends BaseTest{

    Galeria galeria;

    @BeforeEach
    void setGaleria(){
        galeria = new Galeria(driver);
        galeria.handleCookies();
    }
    @Test
    void test_If_Photos_Are_Displayed() {
        galeria.seePhotos(galeria.ferieGaleria, galeria.photoOne);
        galeria.verifyURL("https://yeti.org.pl/galeria/ferie-1/");
    }

    @Test
    void test_Album_Is_Displayed() {
        galeria.seeAlbum(galeria.styczniowyGaleria);
        galeria.verifyURL("https://yeti.org.pl/galeria/styczniowy-2024/");
    }

    @Test
    void test_If_Can_See_More_Photos() {
        galeria.seeMorePhotos();
        galeria.elementDisplayed(galeria.lodowiecWiosenny);
    }

    @Test
    void test_Galeria_Filter() {
        galeria.filtrGaleria(galeria.rok2016, galeria.rolkiSport);
        galeria.elementNotDisplayed(galeria.ferieGaleria);
    }
    @Test
    void test_Galeria_Filter1() {
        galeria.filtrGaleria1();
//        galeria.elementNotDisplayed(galeria.ferieGaleria);
    }
    @Test
    void test_If_Clear_Galeria_Clears() {
        galeria.seeMorePhotos();
        galeria.clearGaleria();
        galeria.elementNotDisplayed(galeria.lodowiecWiosenny);
    }
}
