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

    @Test
    void test_If_Photos_Are_Displayed() {
        Galeria galeria = new Galeria(driver);
        galeria.seePhotos(galeria.ferieGaleria, galeria.photoOne);
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/galeria/ferie-1/");
    }
//
//    @Test
//    void test_Album_Is_Displayed() {
//        galeria.seeAlbum(galeria.styczniowyGaleria);
//        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/galeria/styczniowy-2024/");
//    }
//
//    @Test
//    void test_If_Can_See_More_Photos() {
//        galeria.seeMorePhotos();
//    }
//
//    @Test
//    void test_Galeria_Filter() {
//        galeria.filtrGaleria(galeria.rok2016, galeria.rolkiSport);
//    }
//
//    @Test
//    void test_If_Clear_Galeria_Clears() {
//        galeria.seeMorePhotos();
//        galeria.clearGaleria();
//    }
}
