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
        driver.get(config.getGalleryURL());
        galeria = new Galeria(driver);
        galeria.handleCookies();


    }
    @Test
    void test_If_Ferie1_Album_Is_Displayed() {
        galeria.seeFerie1()
                .verifyURL("https://yeti.org.pl/galeria/ferie-1/");
    }
    @Test
    void test_If_Ferie2_Album_Is_Displayed() {
        galeria.seeFerie2()
                .verifyURL("https://yeti.org.pl/galeria/ferie-2/");
    }
    @Test
    void test_Styczniowy_Album_Is_Displayed() {
        galeria.seeStyczniowy()
        .verifyURL("https://yeti.org.pl/galeria/styczniowy-2024/");
    }
    @Test
    void test_Lodowiec_Album_Is_Displayed() {
        galeria.seeLodowiec()
                .verifyURL("https://yeti.org.pl/galeria/lodowiec/");
    }
    @Test
    void test_If_Can_See_More_Photos() {
        galeria.seeMorePhotos()
                .assertNumberOfAlbumsDisplayed(18);
    }
    @Test
    void test_Galeria_Check_Filter() {
        galeria.choose2018()
                .chooseZagle()
                .assertNumberOfAlbumsDisplayed(1);
    }
    @Test
    void test_If_Clear_Button_Works() {
        galeria.seeMorePhotos()
                .clearGaleria()
                .assertNumberOfAlbumsDisplayed(9);
    }
}
