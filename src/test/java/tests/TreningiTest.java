package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Onas;
import pages.Treningi;

import java.util.concurrent.TimeUnit;

public class TreningiTest {


    WebDriver driver;
    Treningi treningi;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        treningi = new Treningi(driver);
        treningi.handleCookies();
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void test_Schedule_Displayed_On_Page(){
        Assertions.assertEquals("GRAFIK TRENINGÓW",driver.findElement(By.xpath("(//h2[normalize-space()='Grafik treningów'])[1]")).getText());
    }
    @Test
    void test_Monday_Trainings_On_Page(){
        Assertions.assertEquals(treningi.getGrafikPonText(), driver.findElement(treningi.getGrafikPon()).getText());
    }
    @Test
    void test_Thursday_Trainings_On_Page(){
        Assertions.assertEquals(treningi.getGrafikCzwText(), driver.findElement(treningi.getGrafikCzw()).getText());
    }
}
