package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Galeria;

public class GaleriaTest extends BaseTest {

    Galeria galeria;

    @BeforeEach
    void setGaleria() {
        driver.get(config.getGalleryURL());
        galeria = new Galeria(driver);
        galeria.handleCookies();


    }

    @Test
    @Epic("Page Functionality")
    @Feature("Galeria Page")
    @DisplayName("Display 'Ferie 1' album in the gallery")
    void test_If_Ferie1_Album_Is_Displayed() {
        galeria.seeFerie1()
                .verifyURL("https://yeti.org.pl/galeria/ferie-1/");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Galeria Page")
    @DisplayName("Display 'Ferie 2' album in the gallery")
    void test_If_Ferie2_Album_Is_Displayed() {
        galeria.seeFerie2()
                .verifyURL("https://yeti.org.pl/galeria/ferie-2/");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Galeria Page")
    @DisplayName("Display 'Styczniowy' album in the gallery")
    void test_Styczniowy_Album_Is_Displayed() {
        galeria.seeStyczniowy()
                .verifyURL("https://yeti.org.pl/galeria/styczniowy-2024/");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Galeria Page")
    @DisplayName("Display 'Lodowiec' album in the gallery")
    void test_Lodowiec_Album_Is_Displayed() {
        galeria.seeLodowiec()
                .verifyURL("https://yeti.org.pl/galeria/lodowiec/");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Galeria Page")
    @DisplayName("Display 'Lodowiec' album in the gallery")
    void test_If_Can_See_More_Photos() {
        galeria.seeMorePhotos()
                .assertNumberOfAlbumsDisplayed(18);
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Galeria Page")
    @DisplayName("Filter the gallery with 2018 and zagle")
    void test_Galeria_Check_Filter() {
        galeria.choose2018()
                .chooseZagle()
                .assertNumberOfAlbumsDisplayed(1);
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Galeria Page")
    @DisplayName("Clear the gallery filter")
    void test_If_Clear_Button_Works() {
        galeria.seeMorePhotos()
                .clearGaleria()
                .assertNumberOfAlbumsDisplayed(9);
    }
}
