package tests;

import org.junit.jupiter.api.BeforeEach;
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
    void test_Accurate_Title_In_HTML_Addres() {
        newsy.assertPageTitle("NEWSY");
    }

    @Test
    void test_Next_Page_Button_Takes_To_Another_Page() {
        newsy.more_News()
                .verifyURL("https://yeti.org.pl/newsy/page/2/");
    }

    @Test
    void test_News_Stroje_Opens_Upon_Clicking_On_It() {
        newsy.news_Stroje()
                .verifyURL("https://yeti.org.pl/stroje-klubowe-2024-25/");
    }

    @Test
    void test_News_Zamowienia_Opens_Upon_Clicking_On_It() {
        newsy.news_Zamowienia()
                .verifyURL("https://yeti.org.pl/zamowienia-head-na-sezon-2024-2025/");
    }

    @Test
    void test_News_Szkolenia_Opens_Upon_Clicking_On_It() {
        newsy.news_Szkolenia()
                .verifyURL("https://yeti.org.pl/szkolenia-narciarskie/");
    }

    @Test
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