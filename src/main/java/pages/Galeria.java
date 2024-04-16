package pages;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class Galeria extends Footer {

    @FindBy(xpath = "(//div[normalize-space()='ROK'])[1]")
    public WebElement rok;
    @FindBy(xpath = "(//span[normalize-space()='2016'])[1]")
    public WebElement rok2016;
    @FindBy(xpath = "(//span[normalize-space()='2017'])[1]")
    public WebElement rok2017;
    @FindBy(xpath = "(//span[normalize-space()='2018'])[1]")
    public WebElement rok2018;
    @FindBy(xpath = "(//span[normalize-space()='2019'])[1]")
    public WebElement rok2019;
    @FindBy(xpath = "//div[@class='dropdown-btn collapse']//span[@class='dbch-close'][contains(text(),'✕')]")
    public WebElement closeRokWindow;
    @FindBy(xpath = "(//div[normalize-space()='SPORT'])[1]")
    public WebElement sport;
    @FindBy(xpath = "(//span[@class='filter-text'][contains(text(),'Żagle')])[1]")
    public WebElement zagleSport;
    @FindBy(xpath = "(//span[normalize-space()='Rolki'])[1]")
    public WebElement rolkiSport;
    @FindBy(xpath = "(//span[normalize-space()='Surfing'])[1]")
    public WebElement surfingSport;
    @FindBy(xpath = "(//span[normalize-space()='Rowery'])[1]")
    public WebElement rowerySport;
    @FindBy(xpath = "(//span[@class='filter-text'][normalize-space()='Narty'])[1]")
    public WebElement nartySport;
    @FindBy(xpath = "(//span[@class='dbch-close'][contains(text(),'✕')])[2]")
    public WebElement closeSportWindow;
    @FindBy(xpath = "(//a[contains(text(),'WYCZYŚĆ')])[1]")
    public WebElement wyczyscGaleria;
    @FindBy(xpath = "//h3[normalize-space()='Ferie 1']")
    public WebElement ferie1;
    @FindBy(xpath = "(//h3[normalize-space()='Ferie 2'])[1]")
    public WebElement ferie2;
    @FindBy(xpath = "(//h3[contains(text(),'Styczniowy')])[1]")
    public WebElement styczniowy;
    @FindBy(xpath = "(//h3[contains(text(),'Sportowy')])[1]")
    public WebElement sportowy;
    @FindBy(xpath = "(//h3[normalize-space()='Lodowiec'])[1]")
    public WebElement lodowiec;
    @FindBy(xpath = "(//img[@class='wp-image-141435 lazyloaded'])[1]")
    public WebElement Ferie1_Photo1;
    @FindBy(xpath = "(//button[@class='lg-next lg-icon'])[1]")
    public WebElement nextPhoto;
    @FindBy(xpath = "(//button[@class='lg-prev lg-icon'])[1]")
    public WebElement previousPhoto;
    @FindBy(xpath = "(//span[@class='lg-close lg-icon'])[1]")
    public WebElement photoClose;
    @FindBy(xpath = "(//button[contains(text(),'Zobacz więcej')])[1]")
    public WebElement morePhotos;
    @FindAll(@FindBy(css = "div[style*=\"display: block;\"]"))
    private List<WebElement> albumsAvailable;

    public Galeria(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Logowanie checkGaleria() {
        footer_logowanie.click();
        return new Logowanie(driver);
    }

    public Galeria choose2016() {
        rok.click();
        rok2016.click();
        return this;
    }

    public Galeria choose2017() {
        rok.click();
        rok2017.click();
        return this;
    }

    public Galeria choose2018() {
        rok.click();
        rok2018.click();
        return this;
    }

    public Galeria choose2019() {
        rok.click();
        rok2019.click();
        return this;
    }

    public Galeria chooseSurfing() {
        sport.click();
        surfingSport.click();
        return this;
    }

    public Galeria chooseRolki() {
        sport.click();
        rolkiSport.click();
        return this;
    }

    public Galeria chooseNarty() {
        sport.click();
        nartySport.click();
        closeSportWindow.click();
        return this;
    }

    public Galeria chooseZagle() {
        sport.click();
        zagleSport.click();
        return this;
    }

    public Galeria chooseRowery() {
        sport.click();
        rowerySport.click();
        return this;
    }

    public Galeria seeFerie1() {
        ferie1.click();
        return this;
    }

    public Galeria seeFerie2() {
        ferie2.click();
        return this;
    }

    public Galeria seeStyczniowy() {
        styczniowy.click();
        return this;
    }

    public Galeria seeLodowiec() {
        lodowiec.click();
        return this;
    }

    public Galeria closeSportWindow() {
        closeSportWindow.click();
        return this;
    }

    public Galeria closeRokWindow() {
        closeRokWindow.click();
        return this;
    }

    public Galeria clearGaleria() {
        wyczyscGaleria.click();
        return this;
    }

    public Galeria seeMorePhotos() {
        morePhotos.click();
        return this;
    }

    public Galeria seePreviousPhoto() {
        previousPhoto.click();
        return this;
    }

    public Galeria seeNextPhoto() {
        nextPhoto.click();
        return this;
    }

    public Galeria assertNumberOfAlbumsDisplayed(int numberOfAlbumsExpected) {
        Assertions.assertEquals(numberOfAlbumsExpected, albumsAvailable.size());
        return this;
    }
}