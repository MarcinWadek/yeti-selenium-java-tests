package pages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class Logowanie {

    WebDriver driver;

    public Logowanie(WebDriver driver) {
        this.driver = driver;
    }

    public void handleCookies(){
        driver.findElement(By.xpath("//div[@class='cmi-close']")).click();
    }
    By logowanie_Email = By.xpath("//input[@name='user_email']");
    By logowanie_Haslo = By.name("user_password");
    By logowanie_Submit = By.xpath("(//button[normalize-space()='Zaloguj'])[1]");

    By dolacz_Do_Klubu = By.xpath("(//a[contains(text(),'Dołącz do klubu')])[1]");
    By przeczytaj_Regulamin = By.xpath("//span[@class='ylsl-name']");

    By reset_Hasla = By.linkText("Nie pamiętasz hasła?");
    By reset_Input_Email = By.xpath("//input[@name='user_email']");
    By reset_Submit = By.xpath("//button[contains(text(),'Resetuj hasło')]");


    By rejestracja_First_Name = By.xpath("//input[@name='first_name']");
    By rejestracja_Last_Name = By.xpath("//input[@name='last_name']");
    By rejestracja_Email = By.xpath("//input[@name='user_email']");
    By rejestracja_Password = By.xpath("//input[@name='user_password']");
    By rejestracja_PasswordRepeat = By.xpath("//input[@name='user_password_repeat']");
    By rejestracja_Regulamin = By.xpath("//label[@for='regulations_aprove']//span[1]");
    By rejestracja_PrzetwarzanieDanych = By.xpath("(//span[contains(text(),'Wyrażam zgodę na przetwarzanie moich danych zgodni')])[1]");
    By rejestracja_Zapisz_Do_Newslettera = By.xpath("(//span[normalize-space()='Zapisz mnie do newslettera.'])[1]");
    By rejestracja_Zarejestruj = By.xpath("(//button[contains(text(),'ZAREJETRUJ')])[1]");


    public void reset_Password(String email){
        driver.findElement(reset_Hasla).click();
        driver.findElement(reset_Input_Email).sendKeys(email);
        driver.findElement(reset_Submit).click();
    }
    public void logIn (String email, String password){
        driver.findElement(logowanie_Email).sendKeys(email);
        driver.findElement(logowanie_Haslo).sendKeys(password);
        driver.findElement(logowanie_Submit).submit();
    }
    public void register(String firstName, String lastName, String email, String password, String passwordRepeat) {
        driver.findElement(dolacz_Do_Klubu).click();
        driver.findElement(rejestracja_First_Name).sendKeys(firstName);
        driver.findElement(rejestracja_Last_Name).sendKeys(lastName);
        driver.findElement(rejestracja_Email).sendKeys(email);
        driver.findElement(rejestracja_Password).sendKeys(password);
        driver.findElement(rejestracja_PasswordRepeat).sendKeys(passwordRepeat);
        driver.findElement(rejestracja_Regulamin).click();
        driver.findElement(rejestracja_PrzetwarzanieDanych).click();
        driver.findElement(rejestracja_Zarejestruj).submit();
    }

    public By getLogowanie_Email() {
        return logowanie_Email;
    }

    public By getLogowanie_Haslo() {
        return logowanie_Haslo;
    }

    public By getLogowanie_Submit() {
        return logowanie_Submit;
    }

    public By getDolacz_Do_Klubu() {
        return dolacz_Do_Klubu;
    }

    public By getPrzeczytaj_Regulamin() {
        return przeczytaj_Regulamin;
    }

    public By getReset_Hasla() {
        return reset_Hasla;
    }

    public By getReset_Input_Email() {
        return reset_Input_Email;
    }

    public By getReset_Submit() {
        return reset_Submit;
    }

    public By getRejestracja_First_Name() {
        return rejestracja_First_Name;
    }

    public By getRejestracja_Last_Name() {
        return rejestracja_Last_Name;
    }

    public By getRejestracja_Email() {
        return rejestracja_Email;
    }

    public By getRejestracja_Password() {
        return rejestracja_Password;
    }

    public By getRejestracja_PasswordRepeat() {
        return rejestracja_PasswordRepeat;
    }

    public By getRejestracja_Regulamin() {
        return rejestracja_Regulamin;
    }

    public By getRejestracja_PrzetwarzanieDanych() {
        return rejestracja_PrzetwarzanieDanych;
    }

    public By getRejestracja_Zapisz_Do_Newslettera() {
        return rejestracja_Zapisz_Do_Newslettera;
    }

    public By getRejestracja_Zarejestruj() {
        return rejestracja_Zarejestruj;
    }
}