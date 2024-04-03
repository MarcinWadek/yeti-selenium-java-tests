package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer extends BasePage {


    public Footer(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@href='https://yeti.org.pl/'][contains(text(),'Strona główna')])[1]")
    public WebElement footer_strona_Glowna;
    @FindBy(xpath = "(//a[normalize-space()='O Nas'])[2]")
    public WebElement footer_oNas;
    @FindBy(xpath = "(//a[normalize-space()='Newsy'])[2]")
    public WebElement footer_newsy;
    @FindBy(xpath = "(//a[normalize-space()='Treningi'])[2]")
    public WebElement footer_treningi;
    @FindBy(xpath = "(//a[normalize-space()='Wyjazdy'])[2]")
    public WebElement footer_wyjazdy;
    @FindBy(xpath = "(//a[normalize-space()='Galeria'])[2]")
    public WebElement footer_galeria;
    @FindBy(xpath = "(//a[normalize-space()='Logowanie'])[2]")
    public WebElement footer_logowanie;
    @FindBy(xpath = "(//img[@alt='Facebook'])[1]")
    public WebElement footer_Fb;
    @FindBy(xpath = "//img[@alt='Instagram']")
    public WebElement footer_Ig;
    @FindBy(xpath = "(//img[@alt='YouTube'])[1]")
    public WebElement footer_Yt;
    @FindBy(xpath = "(//a[contains(text(),'Zofia')])[1]")
    public WebElement footer_Zofia;
    @FindBy(xpath = "(//a[normalize-space()='WebCrafters Studio'])[1]")
    public WebElement footer_WebCrafter;
    @FindBy(xpath = "(//a[contains(text(),'Czytaj więcej')])[1]")
    public WebElement footer_PolitykaPrywatnosci;
    @FindBy(xpath = "(//input[@name='es_gdpr_consent'])[1]")
    public WebElement footer_Newsletter_Zgoda;
    @FindBy(xpath = "(//input[@placeholder='Adres e-mail'])[1]")
    public WebElement footer_Newsletter_Email;
    @FindBy(xpath = "(//img[@src='https://yeti.org.pl/wp-content/themes/yeti-org-pl/assets/images/arrow-right.svg'])[1]")
    public WebElement footer_Newsletter_Wyslij;
    @FindBy(xpath = "//div[@class='f-logo']//img[@class='lazyloaded']")
    public WebElement footer_logo;
    @FindBy(xpath = "(//span[@id='es_subscription_message_65e489eb12726'])[1]")
    public WebElement footer_sub;

    public Footer browsingThroughPages() {
        new Onas(driver)
                .checkGlowna()
                .checkOnas()
                .checkNewsy()
                .checkTreningi()
                .checkWyjazdy()
                .checkGaleria()
                .checkLogowanie();
        return this;
    }
    public Onas checkGlowna(){
        footer_oNas.click();
        return new Onas(driver);
    }

    public Footer signupForNewsletter(String email) {
        handleCookies();
        footer_Newsletter_Email.click();
        footer_Newsletter_Zgoda.click();
        footer_Newsletter_Wyslij.click();
        return this;
    }

    public Footer redirectToZofia() {
        footer_Zofia.click();
        redirectToNewTab();
        return this;
    }
    public Footer redirectToWebCrafter() {
        footer_WebCrafter.click();
        redirectToNewTab();
        return this;
    }
    public Footer redirectToYoutube() {
        footer_Yt.click();
        redirectToNewTab();
        return this;
    }
    public Footer redirectToInstagram() {
        footer_Ig.click();
        redirectToNewTab();
        return this;
    }
    public Footer redirectToFacebook() {
        footer_Fb.click();
        redirectToNewTab();
        return this;
    }

    public Footer redirectToPolicyPage(){
        footer_PolitykaPrywatnosci.click();
        return this;
    }


    public Footer assertSubConfirmationText(String expectedText){
        Assertions.assertEquals(expectedText, footer_sub.getText());
        return this;
    }
}