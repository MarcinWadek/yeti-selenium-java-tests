package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header;
import pages.Newsy;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class NewsyTest {

    WebDriver driver;
    Newsy newsy;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        newsy = new Newsy(driver);
        driver.get("https://yeti.org.pl/newsy/");
        newsy.handleCookies();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }

    @Test
    void test_Next_Page_Button_Takes_To_Another_Page(){
        newsy.clickElement(newsy.getNextPage());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/newsy/page/2/");
    }
    @Test
    void test_News_Open_Upon_Clicking_On_It(){
        newsy.clickElement(newsy.getNews_Szkolenia_Narciarskie());
        assertThat(driver.getCurrentUrl()).isEqualTo("https://yeti.org.pl/szkolenia-narciarskie/");
    }
}
