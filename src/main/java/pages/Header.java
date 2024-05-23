package pages;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;


public class Header extends Footer {

    @FindBy(xpath = "//img[@alt='Yeti']")
    private WebElement header_Logo;
    @FindBy(xpath = "(//a[normalize-space()='O Nas'])[1]")
    private WebElement header_ONas;
    @FindBy(xpath = "(//a[normalize-space()='Newsy'])[1]")
    private WebElement header_Newsy;
    @FindBy(xpath = "(//a[normalize-space()='Treningi'])[1]")
    private WebElement header_Treningi;
    @FindBy(xpath = "(//a[normalize-space()='Wyjazdy'])[1]")
    private WebElement header_Wyjazdy;
    @FindBy(xpath = "(//a[normalize-space()='Galeria'])[1]")
    private WebElement header_Galeria;
    @FindBy(xpath = "(//a[normalize-space()='Logowanie'])[1]")
    private WebElement header_Logowanie;
    @FindBy(xpath = "(//a[contains(text(),'+48 601-396-601')])[1]")
    private WebElement header_Telefon;
    @FindBy(xpath = "(//a[@href='mailto:biuro@yeti.org.pl'][normalize-space()='biuro@yeti.org.pl'])[1]")
    private WebElement header_Email;

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Header browsingThroughPages() {
        new Onas(driver)
                .checkOnas()
                .checkNewsy()
                .checkTreningi()
                .checkWyjazdy()
                .checkGaleria()
                .checkLogowanie()
                .verifyURL("https://yeti.org.pl/");

        return this;
    }
public Header checkTelephone(){
        elementDisplayed(header_Telefon);
        return this;
    }
    public Header checkEmail(){
        elementDisplayed(header_Email);
        return this;
    }
public Header checkLogo(){
    header_Logo.click();
    return this;
}

}