package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Newsy;

public class NewsyTest extends BaseTest {

    Newsy newsy;

    @BeforeEach
    void setNewsy() {
        driver.get(config.getNewsURL());
        newsy = new Newsy(driver);
        newsy.handleCookies();
    }


    @Test
    @Epic("Website Architecture")
    @Feature("News Page")
    @DisplayName("Veryfing newsy HTML title name")
    void test_Accurate_Title_In_HTML_Addres() {
        newsy.assertPageTitle("NEWSY");
    }

    @Test
    @Epic("Navigation")
    @Feature("News Page")
    @DisplayName("Page navigation through next button")
    void test_Next_Page_Button_Takes_To_Another_Page() {
        newsy.more_News()
                .verifyURL("https://yeti.org.pl/newsy/page/2/");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("News Page")
    @DisplayName("Open 'Stroje' news")
    void test_News_Stroje_Opens_Upon_Clicking_On_It() {
        newsy.news_Stroje()
                .verifyURL("https://yeti.org.pl/stroje-klubowe-2024-25/");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("News Page")
    @DisplayName("Open 'Zamowienia' news")
    void test_News_Zamowienia_Opens_Upon_Clicking_On_It() {
        newsy.news_Zamowienia()
                .verifyURL("https://yeti.org.pl/zamowienia-head-na-sezon-2024-2025/");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("News Page")
    @DisplayName("Open 'Szkolenia' news")
    void test_News_Szkolenia_Opens_Upon_Clicking_On_It() {
        newsy.news_Szkolenia()
                .verifyURL("https://yeti.org.pl/szkolenia-narciarskie/");
    }

    @Test
    @Epic("Navigation")
    @Feature("News Page")
    @DisplayName("Browsing through the news page")
    void test_Newsy_Page_Navigation() {
        newsy.page_News()
                .news_Stroje()
                .page_News()
                .news_Szkolenia()
                .page_News()
                .news_Zamowienia()
                .page_News()
                .more_News()
                .more_News()
                .verifyURL("https://yeti.org.pl/newsy/page/2/");
    }
}