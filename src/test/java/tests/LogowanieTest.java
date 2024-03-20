package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import pages.Logowanie;

import static org.assertj.core.api.Assertions.assertThat;

public class LogowanieTest extends BaseTest {

    @Test
    void test_Password_Reset_With_Invalid_Email() {
        new Logowanie(driver)
                .reset_Password("marcin@wp.pl")
                .assertPasswordResetReturnInfo("Podany e-mail nie istnieje w naszej bazie danych");

    }

    @Test
    void test_Login_With_Valid_Credentials(){
        new Logowanie(driver)
                .logIn("maksiu04@wp.pl", "Admin123")
                .verifyURL("https://yeti.org.pl/moj-profil/");
    }

    @Test
    void test_Login_With_Invalid_Password(){
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "Admin12")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_With_Unregistered_Email(){
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "Admin12")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_Without_AT_Symbol() {
        new Logowanie(driver).logIn("marcinwp.pl", "Admin123");
        Assertions.assertEquals("Błędny e-mail lub hasło", driver.findElement(By.xpath("//div[@class='yeti-notification error']")).getText());
    }
    @Test
    void test_Login_Without_First_Part_Of_The_Emaill() {
        new Logowanie(driver)
                .logIn("@wp.pl", "Admin123")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_Without_Email_Domain() {
        new Logowanie(driver).logIn("marcin@", "Admin123")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_With_1_Character_Password() {
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "a")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Login_With_7_Characters_Password() {
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "abcdefg")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_With_100_Characters_Password() {
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Login_With_LowerCase_Password() {
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "admin13")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Login_With_Upper_Case_Password() {
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "LOREM IPSUM DOLOR SIT AMET, CONSECTETUER ADIPISCING ELIT. AENEAN COMMODO LIGULA EGET DOLOR. AENEAN M")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Login_With_Numberless_Password() {
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "Asdfghjk")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
       void test_Login_With_Only_Numbers_Password() {
        new Logowanie(driver)
                .logIn("marcin@wp.pl", "12345678")
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Register_With_Valid_Credentials(){
        new Logowanie(driver)
                .register( "Dale", "Cooper","cooper@gmail.com", "Admin123", "Admin123");
    }

    @Test
    void test_Register_With_Blank_Fields() {
        new Logowanie(driver).register("", "", "", "", "");
    }
    @Test
    void testRegisterWithoutATsymbol(){
        new Logowanie(driver).register("Dale", "Cooper","coopergmail.com", "Admin123", "Admin123");
    }
    @Test
    void testRegisterWithoutFirstPartOfTheEmaill(){
        new Logowanie(driver).register("Dale", "Cooper","@gmail.com", "Admin123", "Admin123");
    }
    @Test
    void testRegisterWithoutEmailDomain(){
        new Logowanie(driver).register("Dale", "Cooper","cooper@", "Admin123", "Admin123");
    }
    @Test
    void testRegisterWithExistingEmail(){
        new Logowanie(driver).register("maksiu04@wp.pl", "Dale", "Cooper", "Admin1234", "Admin123");
    }
    @Test

    void testRegisterWith100characterEmail(){
        new Logowanie(driver)
                .register( "Long", "Email", "abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij@example.com","Admin1234", "Admin123");
    }
    @Test
    void testRegisterWithShortEmail(){
        new Logowanie(driver)
                .register( "Short", "Email","2@p.pl", "Admin1234", "Admin123");
    }
    @Test
    void testRegisterWith7characterPassword(){
        new Logowanie(driver).register( "Dale", "Cooper", "cooper@gmail.com","Admin12", "Admin12");
    }
    @Test
    void testRegisterWith1characterPassword(){
        new Logowanie(driver).register("Dale", "Cooper","cooper@gmail.com",  "A", "A");
    }
    @Test
    void testRegisterWithMissmatchedPasswords(){
        new Logowanie(driver).register( "Dale", "Cooper", "cooper@gmail.com","Admin123", "Admin124");
    }
    @Test
       void testRegisterWith100CharacterPassword(){
        new Logowanie(driver).register("many", "letters", "onehundredpassword@gmail.com", "aP@ssw0rd123456789!@#$%^&*()-_+=abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ", "P@ssw0rd123456789!@#$%^&*()-_+=abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }
    @Test
    void testRegisterWitLowercasePassword(){
        new Logowanie(driver).register( "Dale", "Cooper", "cooper@gmail.com","admin123", "admin123");
    }
    @Test
    void testRegisterWitUppercasePassword(){
        new Logowanie(driver).register( "DALE", "COOPER", "UPPER@gmail.com","ADMIN1234", "ADMIN123");
    }
    @Test
    void testRegisterWithNumberlessPassword(){
        new Logowanie(driver).register("Dale", "Cooper", "cooper@gmail.com","adminadm", "adminadm");
    }
    @Test
    void testRegisterWithOnlyNumberPassword(){
        new Logowanie(driver).register("Dale", "Cooper", "cooper@gmail.com", "123456785", "12345678");
    }
    @Test
    void testRegisterWithInvalidFirstName(){
        new Logowanie(driver).register( "123!@#", "Cooper", "specialsigns@gmail.com","Admin1234", "Admin123");
    }
    @Test
    void testRegisterWithInvalidLastName(){
        new Logowanie(driver).register("specialsignslastname@gmail.com", "Dale", "123!@#", "Admin1234", "Admin123");
    }
    @Test

    void testRegisterWithShortName(){
        new Logowanie(driver).register( "C", "D", "cooper@gmail.com","Admin1234", "Admin123");
    }
    @Test
    void testRegisterWithAllFieldsFilledExceptConfirmEmail(){
        new Logowanie(driver).register( "Dale", "Cooper", "cooper@gmail.com","Admin123", "");
    }





    }

