package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Treningi;

public class TreningiTest extends BaseTest {

Treningi treningi;

@BeforeEach
void setTreningi(){
    driver.get(config.getTrainingURL());
    treningi = new Treningi(driver);
}
    @Test
    void test_Page_Title(){
       treningi.assertPageTitle("TRENINGI");
    }
    @Test
    void test_Monday_Trainings_On_Page(){
        treningi.verifyMondayTrainingsText();
}
    @Test
    void test_Thursday_Trainings_On_Page(){
        treningi.verifyThursdayTrainingsText();
    }
}
