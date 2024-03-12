package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.Logowanie;

import static org.assertj.core.api.Assertions.assertThat;

public class LogowanieTest extends BaseTest {

    @Test
    void test_Password_Reset_With_Invalid_Email() {
        new Logowanie(driver).reset_Password("marcin@wp.pl");
        Assertions.assertEquals("Podany e-mail nie istnieje w naszej bazie danych", driver.findElement(By.xpath("//li[normalize-space()='Podany e-mail nie istnieje w naszej bazie danych']")).getText());
    }

    @Test
    void test_LogIn_With_Invalid_Data() {
        new Logowanie(driver).logIn("marcin@pl.wp", "admin123");
        Assertions.assertEquals("Błędny e-mail lub hasło", driver.findElement(By.xpath("//div[@class='yeti-notification error']")).getText());
    }

    @Test
    void test_Register_New_User_With_Incomplete_Email() {
        new Logowanie(driver).register("Kuba", "Wojas", "kuba", "Admin123", "Admin123");
        Assertions.assertEquals("Wszystkie pola są wymagane.", driver.findElement(By.xpath("//div[@class='yeti-notification error']")).getText());
    }

    @Test
    void test_Register_New_User_With_Invalid_Password() {
        new Logowanie(driver).register("Kuba", "Wojas", "kuba@wp.pl", "admin123", "admin12");
        Assertions.assertEquals("Hasła nie pasują do siebie.\n" +
                "Hasło musi składać się z minimum 8 znaków a w tym przynajmnnej z: jednej małej i dużej litery.", driver.findElement(By.xpath("//div[@class='yeti-notification error']")).getText());
    }

    }

