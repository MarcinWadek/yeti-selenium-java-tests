package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class Galeria extends BasePage {

    public Galeria(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/galeria");
    }

    By Ferie1 = By.xpath("(//h3[normalize-space()='Ferie 1'])[1]");
    By Rok = By.xpath("(//div[normalize-space()='ROK'])[1]");
    By rok2016 = By.xpath("(//span[normalize-space()='2016'])[1]");
    By closeRokWindow = By.xpath("//div[@class='dropdown-btn collapse']//span[@class='dbch-close'][contains(text(),'✕')]");
    By Sport = By.xpath("(//div[normalize-space()='SPORT'])[1]");
    By zagleSport = By.xpath("(//span[@class='filter-text'][contains(text(),'Żagle')])[1]");
    By rolkiSport = By.xpath("(//span[normalize-space()='Rolki'])[1]");
    By closeSportWindow = By.xpath("(//span[@class='dbch-close'][contains(text(),'✕')])[2]");
    By wyczyscGaleria = By.xpath("(//a[contains(text(),'WYCZYŚĆ')])[1]");
    By ferieGaleria = By.xpath("//h3[normalize-space()='Ferie 1']");
    By styczniowyGaleria = By.xpath("(//h3[contains(text(),'Styczniowy')])[1]");
    By photoOne = By.xpath("(//img[@class='wp-image-141435 lazyloaded'])[1]");
    By nextPhoto = By.xpath("(//button[@class='lg-next lg-icon'])[1]");
    By photoClose = By.xpath("(//span[@class='lg-close lg-icon'])[1]");
    By morePhotos = By.xpath("(//button[contains(text(),'Zobacz więcej')])[1]");


    public void seePhotos(By album, By photo) {
        WebElement elementAlbum = driver.findElement(album);
        elementAlbum.click();
        WebElement elementPhoto = driver.findElement(photo);
        elementPhoto.click();
        driver.findElement(nextPhoto).click();
        driver.findElement(photoClose).click();
    }

    public void seeAbum(By album) {
        WebElement elementAlbum = driver.findElement(album);
        elementAlbum.click();
    }

    public void filtrGaleria(By rok, By sport) {
        driver.findElement(Rok).click();
        WebElement elementRok = driver.findElement(rok);
        elementRok.click();
        driver.findElement(Sport).click();
        WebElement elementSport = driver.findElement(sport);
        elementSport.click();
        driver.findElement(closeSportWindow).click();
    }

    public void clearGaleria() {
        driver.findElement(wyczyscGaleria).click();
    }

    public void seeMorePhotos() {
        driver.findElement(morePhotos).click();
    }


    public By getFerie1() {
        return Ferie1;
    }

    public By getRok() {
        return Rok;
    }

    public By getRok2016() {
        return rok2016;
    }

    public By getSport() {
        return Sport;
    }

    public By getZagleSport() {
        return zagleSport;
    }

    public By getCloseSportWindow() {
        return closeSportWindow;
    }

    public By getWyczyscGaleria() {
        return wyczyscGaleria;
    }

    public By getFerieGaleria() {
        return ferieGaleria;
    }

    public By getPhotoOne() {
        return photoOne;
    }

    public By getNextPhoto() {
        return nextPhoto;
    }

    public By getPhotoClose() {
        return photoClose;
    }

    public By getMorePhotos() {
        return morePhotos;
    }

    public By getStyczniowyGaleria() {
        return styczniowyGaleria;
    }

    public By getRolkiSport() {
        return rolkiSport;
    }
}


