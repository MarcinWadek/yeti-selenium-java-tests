package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Glowna extends BasePage {

    public Glowna(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/");
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[class='slick-slide slick-cloned slick-active'] div img[title='RONTIL']")
    public WebElement rontil;

    @FindBy(css = "div[class='slick-slide slick-cloned slick-active'] div img[title='KPP']")
    public WebElement krzysiekPomaga;

    @FindBy(xpath = "//div[@class='slick-slide slick-cloned slick-active']//div//img[@title='HEAD']")
    public WebElement head;

    @FindBy(xpath = "(//img[@title='Lekarz Sport'])[2]")
    public WebElement lekarzSport;

    @FindBy(xpath = "(//img[@title='TTW'])[2]")
    public WebElement trainToWin;

    @FindBy(xpath = "//div[@class='slick-slide slick-active']//div//img[@title='Juliusz Peszko']")
    public WebElement julekPeszko;

    @FindBy(xpath = "//div[@class='slick-slide slick-active']//div//img[@title='Go Snow']")
    public WebElement goSnow;

    public void redirectToRontil() {
        rontil.click();
        redirectToNewTab();
    }

    public void redirectToKrzysiek() {
        krzysiekPomaga.click();
        redirectToNewTab();
    }

    public void redirectToHead() {
        head.click();
        redirectToNewTab();
    }

    public void redirectToLekarzSport() {
        lekarzSport.click();
        redirectToNewTab();
    }

    public void redirectToTraintoWin() {
        trainToWin.click();
        redirectToNewTab();
    }

    public void redirectToJulek() {
        julekPeszko.click();
        redirectToNewTab();
    }

    public void redirectToGoSnow() {
        goSnow.click();
        redirectToNewTab();
    }

}