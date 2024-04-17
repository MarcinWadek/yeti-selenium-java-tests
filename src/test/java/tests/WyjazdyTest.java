package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Wyjazdy;

public class WyjazdyTest extends BaseTest {

    Wyjazdy wyjazdy;

    @BeforeEach
    void setWyjazdy() {
        driver.get(config.getToursURL());
        wyjazdy = new Wyjazdy(driver);
        wyjazdy.handleCookies();
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Wyjazdy Page")
    @DisplayName("Check April tours")
    void test_Different_Month_Selection_April() {
        wyjazdy.chooseKwiecien()
                .assertActiveMonth("2024-04-01", "2024-04-30");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Wyjazdy Page")
    @DisplayName("Check December tours")
    void test_Different_Month_Selection_December() {
        wyjazdy.chooseGrudzien()
                .assertActiveMonth("2024-12-01", "2024-12-31");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Wyjazdy Page")
    @DisplayName("Filter tours with April")
    void test_Tour_Filter_Per_Month() {
        wyjazdy.chooseKwiecien()
                .assertToursAfterFilter(1);
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Wyjazdy Page")
    @DisplayName("Use the clear button")
    void test_Clear_Button() {
        wyjazdy.chooseKwiecien()
                .assertToursAfterFilter(1)
                .clearTour()
                .assertToursAfterFilter(5);
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Wyjazdy Page")
    @DisplayName("Filter tours with June")
    void test_Tour_Filter_Per_Month_June() {
        wyjazdy.chooseCzerwiec()
                .assertToursAfterFilter(2);
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Wyjazdy Page")
    @DisplayName("Using all the filters")
    void test_All_Filters() {
        wyjazdy.chooseWindsurfing()
                .assertToursAfterFilter(1)
                .chooseGroup()
                .assertToursAfterFilter(1)
                .chooseType()
                .assertToursAfterFilter(1);
    }
}
