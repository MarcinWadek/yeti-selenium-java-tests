package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @Epic("Website Architecture")
    @Feature("Treningi Page")
    @DisplayName("Veryfing Treningi HTML title name")
    void test_Page_Title() {
        treningi.assertPageTitle("TRENINGI");
    }

    @Test
    @Epic("Website Architecture")
    @Feature("Treningi Page")
    @DisplayName("Veryfing Monday training HTML text")
    void test_Monday_Trainings_On_Page() {
        treningi.verifyMondayTrainingsText();
    }

    @Test
    @Epic("Website Architecture")
    @Feature("Treningi Page")
    @DisplayName("Veryfing Thursday training HTML text")
    void test_Thursday_Trainings_On_Page() {
        treningi.verifyThursdayTrainingsText();
    }
}
