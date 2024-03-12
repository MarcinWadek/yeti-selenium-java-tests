package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logowanie extends BasePage {

    public Logowanie(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/logowanie/");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='user_email']")
    private WebElement logowanie_Email;

    @FindBy(name = "user_password")
    private WebElement logowanie_Haslo;

    @FindBy(xpath = "(//button[normalize-space()='Zaloguj'])[1]")
    private WebElement logowanie_Submit;

    @FindBy(xpath = "(//a[contains(text(),'Dołącz do klubu')])[1]")
    private WebElement dolacz_Do_Klubu;

    @FindBy(xpath = "//span[@class='ylsl-name']")
    private WebElement przeczytaj_Regulamin;

    @FindBy(linkText = "Nie pamiętasz hasła?")
    private WebElement reset_Hasla;

    @FindBy(xpath = "//input[@name='user_email']")
    private WebElement reset_Input_Email;

    @FindBy(xpath = "//button[contains(text(),'Resetuj hasło')]")
    private WebElement reset_Submit;

    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement rejestracja_First_Name;

    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement rejestracja_Last_Name;

    @FindBy(xpath = "//input[@name='user_email']")
    private WebElement rejestracja_Email;

    @FindBy(xpath = "//input[@name='user_password']")
    private WebElement rejestracja_Password;

    @FindBy(xpath = "//input[@name='user_password_repeat']")
    private WebElement rejestracja_PasswordRepeat;

    @FindBy(xpath = "//label[@for='regulations_aprove']//span[1]")
    private WebElement rejestracja_Regulamin;

    @FindBy(xpath = "(//span[contains(text(),'Wyrażam zgodę na przetwarzanie moich danych zgodni')])[1]")
    private WebElement rejestracja_PrzetwarzanieDanych;

    @FindBy(xpath = "(//span[normalize-space()='Zapisz mnie do newslettera.'])[1]")
    private WebElement rejestracja_Zapisz_Do_Newslettera;

    @FindBy(xpath = "(//button[contains(text(),'ZAREJETRUJ')])[1]")
    private WebElement rejestracja_Zarejestruj;

    public Logowanie checkLogowanie(WebElement element) {
        element.click();
        return this;
    }

    public Logowanie reset_Password(String email) {
        reset_Hasla.click();
        type(reset_Input_Email,email);
        reset_Submit.click();
        return this;
    }

    public Logowanie logIn(String email, String password) {
        type(logowanie_Email,email);
        type(logowanie_Haslo, password);
        logowanie_Submit.submit();
        return this;
    }

    public Logowanie register(String firstName, String lastName, String email, String password, String passwordRepeat) {
        dolacz_Do_Klubu.click();
        type(rejestracja_First_Name, firstName);
        type(rejestracja_Last_Name, lastName);
        type(rejestracja_Email,email);
        type(rejestracja_Password,password);
        type(rejestracja_PasswordRepeat,passwordRepeat);
        rejestracja_Regulamin.click();
        rejestracja_PrzetwarzanieDanych.click();
        rejestracja_Zarejestruj.submit();
        return this;
    }

}