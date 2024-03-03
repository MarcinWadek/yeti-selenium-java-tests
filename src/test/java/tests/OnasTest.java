package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.Onas;

import java.util.concurrent.TimeUnit;

public class OnasTest {


    WebDriver driver;
    Onas onas;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        onas = new Onas(driver);
        driver.get("https://yeti.org.pl/o-nas/");
        onas.handleCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void test_Photo_Yeti_Is_Displayed(){
        Assertions.assertTrue(onas.getPhotoYeti());

    }

}
