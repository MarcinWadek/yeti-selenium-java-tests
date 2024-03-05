package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Treningi;
import pages.Wyjazdy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WyjazdyTest {

    WebDriver driver;
    Wyjazdy wyjazdy;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        wyjazdy = new Wyjazdy(driver);
        wyjazdy.handleCookies();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test_Filter_Tour() {
        wyjazdy.chooseTour(wyjazdy.getWyjazdy_Narty(), wyjazdy.getWyjazdy_Senior(), wyjazdy.getWyjazdy_Oboz());
//        Assertions.assertTrue(driver.findElement(By.xpath("//h3[normalize-space()='Szkolenie narciarskie']")).isDisplayed(),
//                "The <h3> element with text 'Szkolenie narciarskie' is not present on the page");
    }

    @Test
    void test_That_Only_One_Element_Is_Displayed_After_Filter_Usage() {
        wyjazdy.chooseTour(wyjazdy.getWyjazdy_Narty(), wyjazdy.getWyjazdy_Senior(), wyjazdy.getWyjazdy_Oboz());
//        List<WebElement> wyjazdyAfterFilter = driver.findElements(By.partialLinkText("narciarskie"));
//        Assertions.assertEquals(1, wyjazdyAfterFilter.size());
    }

    @Test
    void test_Browse_Month() {
        wyjazdy.chooseMonth(wyjazdy.getWyjazdy_Czerwiec());
    }

    @Test
    void test_clear_Button() {
        wyjazdy.chooseMonth(wyjazdy.getWyjazdy_Czerwiec());
        wyjazdy.clearTour();
    }

}
