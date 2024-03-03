package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class Footer {

    WebDriver driver;

    public Footer(WebDriver driver) {
        this.driver = driver;
    }
    public void handleCookies(){
        driver.findElement(By.xpath("//div[@class='cmi-close']")).click();
    }
    By footer_strona_Glowna = By.xpath("(//a[@href='https://yeti.org.pl/'][contains(text(),'Strona główna')])[1]");
    By footer_oNas = By.xpath("(//a[normalize-space()='O Nas'])[2]");
    By footer_newsy = By.xpath("(//a[normalize-space()='Newsy'])[2]");
    By footer_treningi = By.xpath("(//a[normalize-space()='Treningi'])[2]");
    By footer_wyjazdy = By.xpath("(//a[normalize-space()='Wyjazdy'])[2]");
    By footer_galeria = By.xpath("(//a[normalize-space()='Galeria'])[2]");
    By footer_logowanie = By.xpath("(//a[normalize-space()='Logowanie'])[2]");
    By footer_Fb = By.xpath("(//img[@alt='Facebook'])[1]");
    By footer_Ig = By.xpath("//img[@alt='Instagram']");
    By footer_Yt = By.xpath("(//img[@alt='YouTube'])[1]");
    By footer_Zofia = By.xpath("(//a[contains(text(),'Zofia')])[1]");
    By footer_WebCrafter = By.xpath("(//a[normalize-space()='WebCrafters Studio'])[1]");
    By footer_PolitykaPrywatnosci = By.xpath("(//a[contains(text(),'Czytaj więcej')])[1]");
    By footer_Newsletter_Zgoda = By.xpath("(//input[@name='es_gdpr_consent'])[1]");
    By footer_Newsletter_Email = By.xpath("(//input[@placeholder='Adres e-mail'])[1]");
    By footer_Newsletter_Wyslij = By.xpath("(//img[@src='https://yeti.org.pl/wp-content/themes/yeti-org-pl/assets/images/arrow-right.svg'])[1]");
    By footer_logo = By.xpath("//div[@class='f-logo']//img[@class='lazyloaded']");

    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void signupForNewsletter(String email) {
        driver.findElement(footer_Newsletter_Email).sendKeys(email);
        driver.findElement(footer_Newsletter_Zgoda).click();
        driver.findElement(footer_Newsletter_Wyslij).click();
    }


    public void goDown(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
    }
    public boolean footerPresent() {
        return driver.findElement(footer_logo).isDisplayed();
    }

    public By getFooter_strona_Glowna() {
        return footer_strona_Glowna;
    }

    public By getFooter_oNas() {
        return footer_oNas;
    }

    public By getFooter_newsy() {
        return footer_newsy;
    }

    public By getFooter_treningi() {
        return footer_treningi;
    }

    public By getFooter_wyjazdy() {
        return footer_wyjazdy;
    }

    public By getFooter_galeria() {
        return footer_galeria;
    }

    public By getFooter_logowanie() {
        return footer_logowanie;
    }

    public By getFooter_Fb() {
        return footer_Fb;
    }

    public By getFooter_Ig() {
        return footer_Ig;
    }

    public By getFooter_Yt() {
        return footer_Yt;
    }

    public By getFooter_Zofia() {
        return footer_Zofia;
    }

    public By getFooter_WebCrafter() {
        return footer_WebCrafter;
    }

    public By getFooter_PolitykaPrywatnosci() {
        return footer_PolitykaPrywatnosci;
    }

    public By getFooter_Newsletter_Zgoda() {
        return footer_Newsletter_Zgoda;
    }

    public By getFooter_Newsletter_Email() {
        return footer_Newsletter_Email;
    }

    public By getFooter_Newsletter_Wyslij() {
        return footer_Newsletter_Wyslij;
    }

    public By getFooter_logo() {
        return footer_logo;
    }
}