package tests;

import dataprovider.LogowanieDP;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Logowanie;

public class LogowanieTest extends BaseTest {


    Logowanie logowanie;
    LogowanieDP logowanieDP;

    @BeforeEach
    void setLogowanie() {
        driver.get(config.getLoginURL());
        logowanie = new Logowanie(driver);
        logowanieDP = new LogowanieDP();
        logowanie.handleCookies();
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Enter member page without login")
    void test_If_Can_Access_The_Member_Page_Without_Login() {
        new Logowanie(driver)
                .visit("https://yeti.org.pl/moj-profil/")
                .assertAccessInformation("Brak dostępu");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Password reset with unregistered email")
    void test_Password_Reset_With_Unregistered_Email() {
        new Logowanie(driver)
                .reset_Password(logowanieDP.getUnregisteredEmail())
                .assertPasswordResetReturnInfo("Podany e-mail nie istnieje w naszej bazie danych");

    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with valid credentials")
    void test_Login_With_Valid_Credentials() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), config.getApplicationPassword())
                .verifyURL("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with invalid credentials")
    void test_Login_With_Invalid_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getInvalidPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with unregistered email")
    void test_Login_With_Unregistered_Email() {
        new Logowanie(driver)
                .logIn(logowanieDP.getUnregisteredEmail(), config.getApplicationPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with mail withot '@' symbol")
    void test_Login_Without_AT_Symbol() {
        new Logowanie(driver).logIn(logowanieDP.getEmailWithoutAt(), config.getApplicationPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with without first part of the email")
    void test_Login_Without_First_Part_Of_The_Emaill() {
        new Logowanie(driver)
                .logIn(logowanieDP.getEmailWithoutName(), config.getApplicationPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with without email domain")
    void test_Login_Without_Email_Domain() {
        new Logowanie(driver).logIn(logowanieDP.getEmailWithoutDomain(), config.getApplicationPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with 1 character password")
    void test_Login_With_1_Character_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getOneCharPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with 7 character password")
    void test_Login_With_7_Characters_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getSevenCharPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with 100 character password")
    void test_Login_With_100_Characters_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getOneHundredCharPassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with lowercase password")
    void test_Login_With_LowerCase_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getLowerCasePassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with uppercase password")
    void test_Login_With_Upper_Case_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getUpperCasePassword())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with numberless password")
    void test_Login_With_Numberless_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getPasswordWithoutNumbers())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with only number password")
    void test_Login_With_Only_Numbers_Password() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), logowanieDP.getPasswordWithOnlyNumbers())
                .assertLoginReturnInfo("Błędny e-mail lub hasło");
    }

    @Test
    @Epic("Logging")
    @Feature("Logowanie Page")
    @DisplayName("Logging with blank fields")
    void test_Register_With_Blank_Fields() {
        new Logowanie(driver).register(logowanieDP.getBlankFied(), logowanieDP.getBlankFied(), logowanieDP.getBlankFied(), logowanieDP.getBlankFied(), logowanieDP.getBlankFied())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with email without '@' symbol")
    void testRegisterWithoutATsymbol() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), logowanieDP.getEmailWithoutAt(), config.getApplicationPassword(), config.getApplicationPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with email without first part")
    void testRegisterWithoutFirstPartOfTheEmaill() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), logowanieDP.getEmailWithoutName(), config.getApplicationPassword(), config.getApplicationPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with email without domain")
    void testRegisterWithoutEmailDomain() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), logowanieDP.getEmailWithoutDomain(), config.getApplicationPassword(), config.getApplicationPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with existing email")
    void testRegisterWithExistingEmail() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), config.getApplicationPassword(), config.getApplicationPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with 100 character email")
    void testRegisterWith100characterEmail() {
        new Logowanie(driver)
                .register(config.getApplicationFirstName(), config.getApplicationLastName(), logowanieDP.getOnHundredCharEmail(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with 1 character email")
    void testRegisterWithShortEmail() {
        new Logowanie(driver)
                .register(config.getApplicationFirstName(), config.getApplicationLastName(), logowanieDP.getOneCharEmail(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with 7 character password")
    void testRegisterWith7characterPassword() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getSevenCharPassword(), logowanieDP.getSevenCharPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with 1 character password")
    void testRegisterWith1characterPassword() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getOneCharPassword(), logowanieDP.getOneCharPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with missmatched")
    void testRegisterWithMissmatchedPasswords() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), config.getApplicationPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with 100 characters password")
    void testRegisterWith100CharacterPassword() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getOneHundredCharPassword(), logowanieDP.getOneHundredCharPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with lowercase password")
    void testRegisterWitLowercasePassword() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getLowerCasePassword(), logowanieDP.getLowerCasePassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with uppercase password")
    void testRegisterWitUppercasePassword() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getUpperCasePassword(), logowanieDP.getUpperCasePassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with numberless password")
    void testRegisterWithNumberlessPassword() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getPasswordWithoutNumbers(), logowanieDP.getPasswordWithoutNumbers())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with only number passoword")
    void testRegisterWithOnlyNumberPassword() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getPasswordWithOnlyNumbers(), logowanieDP.getPasswordWithOnlyNumbers())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with invalid first name")
    void testRegisterWithInvalidFirstName() {
        new Logowanie(driver).register(logowanieDP.getInvalidFistName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with invalid last name")
    void testRegisterWithInvalidLastName() {
        new Logowanie(driver).register(logowanieDP.getInvalidLastName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with 2 characters first name")
    void testRegisterWithShortName() {
        new Logowanie(driver).register(logowanieDP.getShortName(), logowanieDP.getShortName(), config.getApplicationUser(), logowanieDP.getValidPassword(), logowanieDP.getValidPassword())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Register")
    @Feature("Logowanie Page")
    @DisplayName("Register with blank confirm password field")
    void testRegisterWithAllFieldsFilledExceptConfirmPassword() {
        new Logowanie(driver).register(config.getApplicationFirstName(), config.getApplicationLastName(), config.getApplicationUser(), logowanieDP.getValidPassword(), logowanieDP.getBlankFied())
                .assertURLNotModified("https://yeti.org.pl/moj-profil/");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Logowanie Page")
    @DisplayName("Logout")
    void testLogout() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), config.getApplicationPassword())
                .logout()
                .verifyURL("https://yeti.org.pl/logowanie");
    }

    @Test
    @Epic("Page Functionality")
    @Feature("Logowanie Page")
    @DisplayName("Signing up for a tour")
    void testSignUpForTour() {
        new Logowanie(driver)
                .logIn(config.getApplicationUser(), config.getApplicationPassword())
                .wyjazdyForSignUp()
                .windAndSurfSignUp()
                .verifyURL("https://docs.google.com/forms/d/e/1FAIpQLSfmoB28u2zANzGKYajlMyDF489KuG_pMnVwrppKlMFFXLxvxQ/viewform");
    }
}

