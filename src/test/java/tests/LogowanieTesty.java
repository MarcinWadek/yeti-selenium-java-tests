package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Galeria;
import pages.Logowanie;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LogowanieTesty {


    WebDriver driver;
    Logowanie logowanie;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().create();

        driver = new ChromeDriver();
        logowanie = new Logowanie(driver);
        logowanie.handleCookies();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test_Password_Reset_With_Invalid_Email() {
        logowanie.reset_Password("marcin@wp.pl");
        Assertions.assertEquals("Podany e-mail nie istnieje w naszej bazie danych", driver.findElement(By.xpath("//li[normalize-space()='Podany e-mail nie istnieje w naszej bazie danych']")).getText());
    }

    @Test
    void test_LogIn_With_Invalid_Data() {
        logowanie.logIn("marcin@pl.wp", "admin123");
        Assertions.assertEquals("Błędny e-mail lub hasło", driver.findElement(By.xpath("//div[@class='yeti-notification error']")).getText());
    }

    @Test
    void test_Register_New_User_With_Incomplete_Email() {
        logowanie.register("Kuba", "Wojas", "kuba", "Admin123", "Admin123");
        Assertions.assertEquals("Wszystkie pola są wymagane.", driver.findElement(By.xpath("//div[@class='yeti-notification error']")).getText());
    }

    @Test
    void test_Register_New_User_With_Invalid_Password() {
        logowanie.register("Kuba", "Wojas", "kuba@wp.pl", "admin123", "admin12");
        Assertions.assertEquals("Hasła nie pasują do siebie.\n" +
                "Hasło musi składać się z minimum 8 znaków a w tym przynajmnnej z: jednej małej i dużej litery.", driver.findElement(By.xpath("//div[@class='yeti-notification error']")).getText());
    }

}
