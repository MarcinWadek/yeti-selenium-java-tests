package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Galeria extends BasePage {

    public Galeria(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/galeria");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//h3[normalize-space()='Ferie 1'])[1]")
    public WebElement ferie1;

    @FindBy(xpath = "(//div[normalize-space()='ROK'])[1]")
    public WebElement rok;

    @FindBy(xpath = "(//span[normalize-space()='2016'])[1]")
    public WebElement rok2016;

    @FindBy(xpath = "//div[@class='dropdown-btn collapse']//span[@class='dbch-close'][contains(text(),'✕')]")
    public WebElement closeRokWindow;

    @FindBy(xpath = "(//div[normalize-space()='SPORT'])[1]")
    public WebElement sport;

    @FindBy(xpath = "(//span[@class='filter-text'][contains(text(),'Żagle')])[1]")
    public WebElement zagleSport;

    @FindBy(xpath = "(//span[normalize-space()='Rolki'])[1]")
    public WebElement rolkiSport;

    @FindBy(xpath = "(//span[@class='dbch-close'][contains(text(),'✕')])[2]")
    public WebElement closeSportWindow;

    @FindBy(xpath = "(//a[contains(text(),'WYCZYŚĆ')])[1]")
    public WebElement wyczyscGaleria;

    @FindBy(xpath = "//h3[normalize-space()='Ferie 1']")
    public WebElement ferieGaleria;

    @FindBy(xpath = "(//h3[contains(text(),'Styczniowy')])[1]")
    public WebElement styczniowyGaleria;

    @FindBy(xpath = "(//img[@class='wp-image-141435 lazyloaded'])[1]")
    public WebElement photoOne;

    @FindBy(xpath = "(//button[@class='lg-next lg-icon'])[1]")
    public WebElement nextPhoto;

    @FindBy(xpath = "(//span[@class='lg-close lg-icon'])[1]")
    public WebElement photoClose;

    @FindBy(xpath = "(//button[contains(text(),'Zobacz więcej')])[1]")
    public WebElement morePhotos;

    @FindBy(xpath = "//h3[normalize-space()='Lodowiec wiosenny']")
    public WebElement lodowiecWiosenny;


    public Logowanie checkGaleria(WebElement element) {
        element.click();
        return new Logowanie(driver);
    }

    public void seePhotos(WebElement album, WebElement photo) {
        album.click();
        photo.click();
        nextPhoto.click();
        photoClose.click();
    }

    public void seeAlbum(WebElement album) {
        album.click();
    }

    public void filtrGaleria(WebElement rokWybor, WebElement sportWybor) {
        rok.click();
        rokWybor.click();
        sport.click();
        sportWybor.click();
        closeSportWindow.click();
    }
    public void filtrGaleria1() {
        rok.click();
        rok2016.click();
        sport.click();
        rolkiSport.click();
        closeSportWindow.click();
    }
    public void clearGaleria() {
        wyczyscGaleria.click();
    }

    public void seeMorePhotos() {
        morePhotos.click();
    }

}
