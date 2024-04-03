package tests;

import com.github.javafaker.Faker;
import config.Config;
import dataprovider.LogowanieDP;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import pages.Logowanie;
import pages.Newsy;

import static org.assertj.core.api.Assertions.assertThat;

public class LogowanieTest extends BaseTest {


Logowanie logowanie;
LogowanieDP logowanieDP;

    @BeforeEach
    void setLogowanie() {
        driver.get(config.getLoginURL());
        logowanie = new Logowanie(driver);
        logowanieDP = new LogowanieDP();
    }
    @Test
    void test_If_Can_Access_The_Member_Page_Without_Login(){
        new Logowanie(driver)
                .visit("https://yeti.org.pl/moj-profil/")
                .assertAccessInformation("Brak dostępu");
    }
    @Test
    void test_Password_Reset_With_Unregistered_Email() {
        new Logowanie(driver)
                .reset_Password(logowanieDP.getUnregisteredEmail())
                .assertPasswordResetReturnInfo("Podany e-mail nie istnieje w naszej bazie danych");

    }
    @Test
    void test_Login_With_Valid_Credentials(){
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), config.getApplicationPassword())
                .verifyURL("https://yeti.org.pl/moj-profil/");
    }

    @Test
    void test_Login_With_Invalid_Password(){
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getInvalidPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_With_Unregistered_Email(){
        new Logowanie(driver)
                .logIn(logowanieDP.getUnregisteredEmail(), config.getApplicationPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_Without_AT_Symbol() {
        new Logowanie(driver).logIn(logowanieDP.getEmailWithoutAt(), config.getApplicationPassword())
       .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_Without_First_Part_Of_The_Emaill() {
        new Logowanie(driver)
                .logIn(logowanieDP.getEmailWithoutName(), config.getApplicationPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_Without_Email_Domain() {
        new Logowanie(driver).logIn(logowanieDP.getEmailWithoutDomain(), config.getApplicationPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_With_1_Character_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getOneCharPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Login_With_7_Characters_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getSevenCharPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Login_With_100_Characters_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getOneHundredCharPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Login_With_LowerCase_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getLowerCasePassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Login_With_Upper_Case_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getUpperCasePassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    void test_Login_With_Numberless_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getPasswordWithoutNumbers())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
       void test_Login_With_Only_Numbers_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getPasswordWithOnlyNumbers())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }
    @Test
    void test_Register_With_Blank_Fields() {
        new Logowanie(driver).register(logowanieDP.getBlankFied(), logowanieDP.getBlankFied(), logowanieDP.getBlankFied(), logowanieDP.getBlankFied(), logowanieDP.getBlankFied())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithoutATsymbol(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(),logowanieDP.getEmailWithoutAt(), config.getApplicationPassword(), config.getApplicationPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithoutFirstPartOfTheEmaill(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(),logowanieDP.getEmailWithoutName(), config.getApplicationPassword(), config.getApplicationPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithoutEmailDomain(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(),logowanieDP.getEmailWithoutDomain(), config.getApplicationPassword(), config.getApplicationPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithExistingEmail(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(),config.getApplicationUser(), config.getApplicationPassword(), config.getApplicationPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test

    void testRegisterWith100characterEmail(){
        new Logowanie(driver)
                .register(config.getApplicationFirstName(), config.getApplicationLastName(), logowanieDP.getOnHundredCharEmail(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithShortEmail(){
        new Logowanie(driver)
                .register(config.getApplicationFirstName(), config.getApplicationLastName(), logowanieDP.getOneCharEmail(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWith7characterPassword(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getSevenCharPassword(), logowanieDP.getSevenCharPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWith1characterPassword(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getOneCharPassword(), logowanieDP.getOneCharPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithMissmatchedPasswords(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), config.getApplicationPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
       void testRegisterWith100CharacterPassword(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getOneHundredCharPassword(), logowanieDP.getOneHundredCharPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWitLowercasePassword(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getLowerCasePassword(), logowanieDP.getLowerCasePassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWitUppercasePassword(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getUpperCasePassword(), logowanieDP.getUpperCasePassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithNumberlessPassword(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getPasswordWithoutNumbers(),  logowanieDP.getPasswordWithoutNumbers())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithOnlyNumberPassword(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getPasswordWithOnlyNumbers(), logowanieDP.getPasswordWithOnlyNumbers())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithInvalidFirstName(){
        new Logowanie(driver).register(logowanieDP.getInvalidFistName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithInvalidLastName(){
        new Logowanie(driver).register(logowanieDP.getInvalidLastName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test

    void testRegisterWithShortName(){
        new Logowanie(driver).register(logowanieDP.getShortName(), logowanieDP.getShortName(), config.getApplicationUser(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }
    @Test
    void testRegisterWithAllFieldsFilledExceptConfirmPassword(){
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getValidPassword(), logowanieDP.getBlankFied())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }





    }

