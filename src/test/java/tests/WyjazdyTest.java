package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Wyjazdy;

public class WyjazdyTest extends BaseTest {

    Wyjazdy wyjazdy;

    @BeforeEach
    void setWyjazdy(){
        wyjazdy = new Wyjazdy(driver);
        wyjazdy.handleCookies();
    }

    @Test
    void test_Different_Month_Selection_April(){
        wyjazdy.chooseKwiecien()
                .assertActiveMonth("2024-04-01", "2024-04-30");
    }
    @Test
    void test_Different_Month_Selection_December(){
        wyjazdy.chooseGrudzien()
                .assertActiveMonth("2024-12-01", "2024-12-31");
    }
    @Test
    void test_Tour_Filter_Per_Month(){
        wyjazdy.chooseKwiecien()
                .assertToursAfterFilter(1);
    }
    @Test
    void test_Clear_Button(){
        wyjazdy.chooseKwiecien()
                .assertToursAfterFilter(1)
                .clearTour()
                .assertToursAfterFilter(5);
    }
    @Test
    void test_Tour_Filter_Per_Month_June(){
        wyjazdy.chooseCzerwiec()
                .assertToursAfterFilter(2);
    }

    @Test
    void test_All_Filters(){
        wyjazdy.chooseWindsurfing()
                .assertToursAfterFilter(1)
                .chooseGroup()
                .assertToursAfterFilter(1)
                .chooseType()
                .assertToursAfterFilter(1);
    }
    }
