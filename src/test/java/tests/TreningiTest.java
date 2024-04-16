package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Treningi;

public class TreningiTest extends BaseTest {

    Treningi treningi;

    @BeforeEach
    void setTreningi() {
        driver.get(config.getTrainingURL());
        treningi = new Treningi(driver);
    }

    @Test
    void test_Page_Title() {
        treningi.assertPageTitle("TRENINGI");
    }

    @Test
    void test_Monday_Trainings_On_Page() {
        treningi.verifyMondayTrainingsText();
    }

    @Test
    void test_Thursday_Trainings_On_Page() {
        treningi.verifyThursdayTrainingsText();
    }
}
