package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Header extends Footer {

    public Header(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@href='https://yeti.org.pl/'][contains(text(),'Strona główna')])[1]")
    private WebElement header_Strona_Glowna;

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
    private WebElement email;

//    public void browsingThroughPages() {
//        new Onas(driver)
//                .checkOnas(header_Newsy)
//                .checkNewsy(header_Treningi)
//                .checkTreningi(header_Wyjazdy)
//                .checkWyjazdy(header_Galeria)
//                .checkGaleria(header_Logowanie)
//                .checkLogowanie(header_ONas)
//                .verifyURL("https://yeti.org.pl/o-nas/");
//
//    }

}