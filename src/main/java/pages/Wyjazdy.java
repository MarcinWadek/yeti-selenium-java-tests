package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wyjazdy extends BasePage{

    public Wyjazdy(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/wyjazdy/");
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "(//button[normalize-space()='Mar'])[1]")
    private WebElement wyjazdy_Marzec;

    @FindBy(xpath = "(//button[normalize-space()='Kwi'])[1]")
    private WebElement wyjazdy_Kwiecien;

    @FindBy(xpath = "(//button[normalize-space()='Maj'])[1]")
    private WebElement wyjazdy_Maj;

    @FindBy(xpath = "(//button[normalize-space()='Cze'])[1]")
    private WebElement wyjazdy_Czerwiec;

    @FindBy(xpath = "(//button[normalize-space()='Lip'])[1]")
    private WebElement wyjazdy_Lipiec;

    @FindBy(xpath = "(//button[normalize-space()='Sie'])[1]")
    private WebElement wyjazdy_Sierpien;

    @FindBy(xpath = "(//button[normalize-space()='Wrz'])[1]")
    private WebElement wyjazdy_Wrzesien;

    @FindBy(xpath = "(//button[normalize-space()='Paz'])[1]")
    private WebElement wyjazdy_Pazdziernik;

    @FindBy(xpath = "(//button[normalize-space()='Lis'])[1]")
    private WebElement wyjazdy_Listopad;

    @FindBy(xpath = "(//button[normalize-space()='Gru'])[1]")
    private WebElement wyjazdy_Grudzien;

    @FindBy(xpath = "(//button[normalize-space()='Sty'])[1]")
    private WebElement wyjazdy_Styczen;

    @FindBy(xpath = "(//button[normalize-space()='Lut'])[1]")
    private WebElement wyjazdy_Luty;

    @FindBy(xpath = "(//h3[normalize-space()='Obóz ferie 1'])[1]")
    private WebElement wyjazdy_Oboz_Ferie1;

    @FindBy(xpath = "(//span[@class='ylsl-name'])[1]")
    private WebElement wyjazdy_kartaZdrowia;

    @FindBy(xpath = "(//div[normalize-space()='SPORT'])[1]")
    private WebElement wyjazdy_Sport;

    @FindBy(xpath = "//span[@class='filter-text'][normalize-space()='Narty']")
    private WebElement wyjazdy_Narty;

    @FindBy(xpath = "(//span[@class='dbch-close'][contains(text(),'✕')])[1]")
    private WebElement wyjazdy_Zamknij;

    @FindBy(xpath = "(//div[normalize-space()='GRUPA'])[1]")
    private WebElement wyjazdy_Grupa;

    @FindBy(xpath = "(//span[normalize-space()='SENIOR'])[1]")
    private WebElement wyjazdy_Senior;

    @FindBy(xpath = "//div[@class='dropdown-btn collapse chosen']//span[@class='dbch-close'][contains(text(),'✕')]")
    private WebElement wyjazdy_Close_WindowGrupa;

    @FindBy(xpath = "(//div[normalize-space()='TYP'])[1]")
    private WebElement wyjazdy_Typ;

    @FindBy(xpath = "(//span[normalize-space()='OBÓZ'])[1]")
    private WebElement wyjazdy_Oboz;

    @FindBy(xpath = "(//span[@class='dbch-close'][contains(text(),'✕')])[3]")
    private WebElement wyjazdy_Close_WindowTyp;

    @FindBy(xpath = "(//a[contains(text(),'WYCZYŚĆ')])[1]")
    private WebElement wyjazdy_wyczysc;

    @FindBy(xpath = "(//a[contains(text(),'WYCZYŚĆ')])[1]")
    private WebElement clearTour;


    public Galeria checkWyjazdy(WebElement element){
        element.click();
        return new Galeria(driver);
    }

    public void chooseMonth(WebElement month) {
        month.click();
    }

    public void chooseTour(WebElement sport, WebElement grupa, WebElement typ) {
        wyjazdy_Sport.click();
        sport.click();
        wyjazdy_Grupa.click();
        grupa.click();
        wyjazdy_Typ.click();
        typ.click();
        wyjazdy_Close_WindowTyp.click();
    }

    public void clearTour() {
       clearTour.click();
    }

}