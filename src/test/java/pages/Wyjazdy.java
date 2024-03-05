package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wyjazdy extends BasePage{

    public Wyjazdy(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/wyjazdy/");
    }

    By wyjazdy_Marzec = By.xpath("(//button[normalize-space()='Mar'])[1]");
    By wyjazdy_Kwiecien = By.xpath("(//button[normalize-space()='Kwi'])[1]");
    By wyjazdy_Maj = By.xpath("(//button[normalize-space()='Maj'])[1]");
    By wyjazdy_Czerwiec = By.xpath("(//button[normalize-space()='Cze'])[1]");
    By wyjazdy_Lipiec = By.xpath("(//button[normalize-space()='Lip'])[1]");
    By wyjazdy_Sierpien = By.xpath("(//button[normalize-space()='Sie'])[1]");
    By wyjazdy_Wrzesien = By.xpath("(//button[normalize-space()='Wrz'])[1]");
    By wyjazdy_Pazdziernik = By.xpath("(//button[normalize-space()='Paz'])[1]");
    By wyjazdy_Listopad = By.xpath("(//button[normalize-space()='Lis'])[1]");
    By wyjazdy_Grudzien = By.xpath("(//button[normalize-space()='Gru'])[1]");
    By wyjazdy_Styczen = By.xpath("(//button[normalize-space()='Sty'])[1]");
    By wyjazdy_Luty = By.xpath("(//button[normalize-space()='Lut'])[1]");


    By wyjazdy_Oboz_Ferie1 = By.xpath("(//h3[normalize-space()='Obóz ferie 1'])[1]");

    By wyjazdy_kartaZdrowia = By.xpath("(//span[@class='ylsl-name'])[1]");
    By wyjazdy_Sport = By.xpath("(//div[normalize-space()='SPORT'])[1]");

    By wyjazdy_Narty = By.xpath("//span[@class='filter-text'][normalize-space()='Narty']");
    By wyjazdy_Zamknij = By.xpath("(//span[@class='dbch-close'][contains(text(),'✕')])[1]");

    By wyjazdy_Grupa = By.xpath("(//div[normalize-space()='GRUPA'])[1]");
    By wyjazdy_Senior = By.xpath("(//span[normalize-space()='SENIOR'])[1]");
    By wyjazdy_Close_WindowGrupa = By.xpath("//div[@class='dropdown-btn collapse chosen']//span[@class='dbch-close'][contains(text(),'✕')]");

    By wyjazdy_Typ = By.xpath("(//div[normalize-space()='TYP'])[1]");
    By wyjazdy_Oboz = By.xpath("(//span[normalize-space()='OBÓZ'])[1]");
    By wyjazdy_Close_WindowTyp = By.xpath("(//span[@class='dbch-close'][contains(text(),'✕')])[3]");
    By wyjazdy_wyczysc = By.xpath("(//a[contains(text(),'WYCZYŚĆ')])[1]");

    public void chooseMonth(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void chooseTour(By sport, By grupa, By typ) {
        driver.findElement(wyjazdy_Sport).click();
        WebElement elementSport = driver.findElement(sport);
        elementSport.click();
        driver.findElement(wyjazdy_Grupa).click();
        WebElement elementGrupa = driver.findElement(grupa);
        elementGrupa.click();
        driver.findElement(wyjazdy_Typ).click();
        WebElement elementTyp = driver.findElement(typ);
        elementTyp.click();
        driver.findElement(wyjazdy_Close_WindowTyp).click();
    }

    public void clearTour() {
        driver.findElement(By.xpath("(//a[contains(text(),'WYCZYŚĆ')])[1]")).click();
    }

    public By getWyjazdy_Marzec() {
        return wyjazdy_Marzec;
    }

    public By getWyjazdy_Kwiecien() {
        return wyjazdy_Kwiecien;
    }

    public By getWyjazdy_Maj() {
        return wyjazdy_Maj;
    }

    public By getWyjazdy_Czerwiec() {
        return wyjazdy_Czerwiec;
    }

    public By getWyjazdy_Lipiec() {
        return wyjazdy_Lipiec;
    }

    public By getWyjazdy_Sierpien() {
        return wyjazdy_Sierpien;
    }

    public By getWyjazdy_Wrzesien() {
        return wyjazdy_Wrzesien;
    }

    public By getWyjazdy_Pazdziernik() {
        return wyjazdy_Pazdziernik;
    }

    public By getWyjazdy_Listopad() {
        return wyjazdy_Listopad;
    }

    public By getWyjazdy_Grudzien() {
        return wyjazdy_Grudzien;
    }

    public By getWyjazdy_Styczen() {
        return wyjazdy_Styczen;
    }

    public By getWyjazdy_Luty() {
        return wyjazdy_Luty;
    }

    public By getWyjazdy_Oboz_Ferie1() {
        return wyjazdy_Oboz_Ferie1;
    }

    public By getWyjazdy_kartaZdrowia() {
        return wyjazdy_kartaZdrowia;
    }

    public By getWyjazdy_Sport() {
        return wyjazdy_Sport;
    }

    public By getWyjazdy_Narty() {
        return wyjazdy_Narty;
    }

    public By getWyjazdy_Zamknij() {
        return wyjazdy_Zamknij;
    }

    public By getWyjazdy_Grupa() {
        return wyjazdy_Grupa;
    }

    public By getWyjazdy_Senior() {
        return wyjazdy_Senior;
    }

    public By getWyjazdy_Close_WindowGrupa() {
        return wyjazdy_Close_WindowGrupa;
    }

    public By getWyjazdy_Typ() {
        return wyjazdy_Typ;
    }

    public By getWyjazdy_Oboz() {
        return wyjazdy_Oboz;
    }

    public By getWyjazdy_Close_WindowTyp() {
        return wyjazdy_Close_WindowTyp;
    }

    public By getWyjazdy_wyczysc() {
        return wyjazdy_wyczysc;
    }
}