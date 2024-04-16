package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Glowna extends BasePage {

    @FindBy(css = "div[class='slick-slide slick-active'] div img[title='RONTIL']")
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

    public Glowna(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Glowna redirectToRontil() {
        rontil.click();
        redirectToNewTab();
        return this;
    }

    public Glowna redirectToKrzysiek() {
        krzysiekPomaga.click();
        redirectToNewTab();
        return this;
    }

    public Glowna redirectToHead() {
        head.click();
        redirectToNewTab();
        return this;
    }

    public Glowna redirectToLekarzSport() {
        lekarzSport.click();
        redirectToNewTab();
        return this;
    }

    public Glowna redirectToTraintoWin() {
        trainToWin.click();
        redirectToNewTab();
        return this;
    }

    public Glowna redirectToJulek() {
        julekPeszko.click();
        redirectToNewTab();
        return this;
    }

    public Glowna redirectToGoSnow() {
        goSnow.click();
        redirectToNewTab();
        return this;
    }

}