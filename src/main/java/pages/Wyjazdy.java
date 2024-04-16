package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Wyjazdy extends Footer {

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
    @FindBy(css = "label[for='sport_rolki'] span[class='filter-text']")
    private WebElement wyjazdy_Rolki;
    @FindBy(css = "label[for='sport_windsurfing'] span[class='filter-text']")
    private WebElement wyjazdy_Windsurfing;
    @FindBy(xpath = "(//span[@class='dbch-close'][contains(text(),'✕')])[1]")
    private WebElement wyjazdy_Zamknij;
    @FindBy(xpath = "(//div[normalize-space()='GRUPA'])[1]")
    private WebElement wyjazdy_Grupa;
    @FindBy(xpath = "(//span[normalize-space()='SENIOR'])[1]")
    private WebElement wyjazdy_Senior;
    @FindBy(css = "label[for='grupa_mlodsi'] span[class='filter-text']")
    private WebElement wyjazdy_mlodsi;
    @FindBy(xpath = "//div[@class='dropdown-btn collapse chosen']//span[@class='dbch-close'][contains(text(),'✕')]")
    private WebElement wyjazdy_Close_WindowGrupa;
    @FindBy(xpath = "(//div[normalize-space()='TYP'])[1]")
    private WebElement wyjazdy_Typ;
    @FindBy(xpath = "(//span[normalize-space()='OBÓZ'])[1]")
    private WebElement wyjazdy_Oboz;
    @FindBy(xpath = "(//span[@class='dbch-close'][contains(text(),'✕')])[3]")
    private WebElement wyjazdy_Close_WindowTyp;
    @FindBy(css = "div[class='dropdown-btn collapse'] span[class='dbch-close']")
    private WebElement wyjazdy_Close_WindowSport;
    @FindBy(xpath = "(//a[contains(text(),'WYCZYŚĆ')])[1]")
    private WebElement wyjazdy_wyczysc;
    @FindBy(xpath = "(//a[contains(text(),'WYCZYŚĆ')])[1]")
    private WebElement clearTour;
    @FindBy(css = "button.filter-month-btn.active-month")
    private WebElement activeMonth;
    @FindAll(@FindBy(css = "a[class='tl-single tl-single-trip single-post-in-loop']"))
    private List<WebElement> toursAvailable;
    @FindBy(xpath = "//h3[normalize-space()='Wind & Surf']")
    private WebElement WindAndSurf;
    @FindBy(xpath = "(//a[contains(text(),'Zapisz się')])[1]")
    private WebElement SignUpForWindAndSurf;



    public Wyjazdy(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Galeria checkWyjazdy() {
        footer_galeria.click();
        return new Galeria(driver);
    }

    public Wyjazdy chooseStyczen() {
        wyjazdy_Styczen.click();
        return this;
    }

    public Wyjazdy chooseLuty() {
        wyjazdy_Luty.click();
        return this;
    }

    public Wyjazdy chooseMarzec() {
        wyjazdy_Marzec.click();
        return this;
    }

    public Wyjazdy chooseKwiecien() {
        wyjazdy_Kwiecien.click();
        return this;
    }

    public Wyjazdy chooseCzerwiec() {
        wyjazdy_Czerwiec.click();
        return this;
    }

    public Wyjazdy chooseGrudzien() {
        wyjazdy_Grudzien.click();
        return this;
    }

    public Wyjazdy chooseWindsurfing() {
        wyjazdy_Sport.click();
        wyjazdy_Windsurfing.click();

        return this;
    }

    public Wyjazdy chooseSkiing() {
        wyjazdy_Sport.click();
        wyjazdy_Narty.click();

        return this;
    }

    public Wyjazdy chooseGroup() {
        wyjazdy_Grupa.click();
        wyjazdy_mlodsi.click();
        return this;
    }

    public Wyjazdy chooseType() {
        wyjazdy_Typ.click();
        wyjazdy_Oboz.click();
        wyjazdy_Close_WindowTyp.click();
        return this;
    }

    public Wyjazdy clearTour() {
        clearTour.click();
        return this;
    }
    public Wyjazdy windAndSurfSignUp(){
        WindAndSurf.click();
        SignUpForWindAndSurf.click();
        redirectToNewTab();
        return new Wyjazdy(driver);
    }


    public Wyjazdy assertActiveMonth(String expectedStartDate, String expectedEndDate) {
        String startDateAttribute = activeMonth.getAttribute("data-start");
        String endDateAttribute = activeMonth.getAttribute("data-end");
        Assertions.assertEquals(expectedStartDate, startDateAttribute, "Start date of active month is incorrect");
        Assertions.assertEquals(expectedEndDate, endDateAttribute, "End date of active month is incorrect");
        return this;
    }

    public Wyjazdy assertToursAfterFilter(int filteredTours) {
        Assertions.assertEquals(filteredTours, toursAvailable.size());
        return this;
    }
}
