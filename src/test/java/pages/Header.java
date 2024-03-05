package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class Header extends BasePage {

public Header (WebDriver driver){
    super(driver);
    visit("https://yeti.org.pl/");
}
By header_Strona_Glowna = By.xpath("(//a[@href='https://yeti.org.pl/'][contains(text(),'Strona główna')])[1]");
By header_ONas = By.xpath("(//a[normalize-space()='O Nas'])[1]");
By header_Newsy = By.xpath("(//a[normalize-space()='Newsy'])[1]");
By header_Treningi = By.xpath("(//a[normalize-space()='Treningi'])[1]");
By header_Wyjazdy = By.xpath("(//a[normalize-space()='Wyjazdy'])[1]");
By header_Galeria = By.xpath("(//a[normalize-space()='Galeria'])[1]");
By header_Logowanie = By.xpath("(//a[normalize-space()='Logowanie'])[1]");
By header_Telefon = By.xpath("(//a[contains(text(),'+48 601-396-601')])[1]");
By email = By.xpath("(//a[@href='mailto:biuro@yeti.org.pl'][normalize-space()='biuro@yeti.org.pl'])[1]");

    public By getHeader_Strona_Glowna() {
        return header_Strona_Glowna;
    }

    public By getHeader_ONas() {
        return header_ONas;
    }

    public By getHeader_Newsy() {
        return header_Newsy;
    }

    public By getHeader_Treningi() {
        return header_Treningi;
    }

    public By getHeader_Wyjazdy() {
        return header_Wyjazdy;
    }

    public By getHeader_Galeria() {
        return header_Galeria;
    }

    public By getHeader_Logowanie() {
        return header_Logowanie;
    }

    public By getHeader_Telefon() {
        return header_Telefon;
    }

    public By getEmail() {
        return email;
    }
}