package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer extends BasePage {


    public Footer(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/");
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

    public void browsingThroughPages() {
        handleCookies();
        new Onas(driver)
                .checkOnas(footer_newsy)
                .checkNewsy(footer_treningi)
                .checkTreningi(footer_wyjazdy)
                .checkWyjazdy(footer_galeria)
                .checkGaleria(footer_logowanie)
                .checkLogowanie(footer_oNas);
    }


    public void signupForNewsletter(String email) {
        handleCookies();
        footer_Newsletter_Email.click();
        footer_Newsletter_Zgoda.click();
        footer_Newsletter_Wyslij.click();
    }

    public void redirectToZofia() {
        footer_Zofia.click();
        redirectToNewTab();
    }

    public void redirectToWebCrafter() {
        footer_WebCrafter.click();
        redirectToNewTab();
    }

}