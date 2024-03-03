package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Glowna {

    public Glowna(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }
    public void handleCookies(){
        driver.findElement(By.xpath("//div[@class='cmi-close']")).click();
    }

    WebDriver driver;
    WebDriverWait wait;

    By Rontil = By.cssSelector("div[class='slick-slide slick-cloned slick-active'] div img[title='RONTIL']");

    By KrzysiekPomaga = By.cssSelector("div[class='slick-slide slick-cloned slick-active'] div img[title='KPP']");

    By Head = By.xpath("//div[@class='slick-slide slick-cloned slick-active']//div//img[@title='HEAD']");

    By LekarzSport = By.xpath("(//img[@title='Lekarz Sport'])[2]");

    By TrainToWin = By.xpath("(//img[@title='TTW'])[2]");

    By JulekPeszko = By.xpath("//div[@class='slick-slide slick-active']//div//img[@title='Juliusz Peszko']");

    By GoSnow = By.xpath("//div[@class='slick-slide slick-active']//div//img[@title='Go Snow']");


    public void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }
    public void waitAndClick(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
    }

    public By getRontil() {
        return Rontil;
    }

    public By getKrzysiekPomaga() {
        return KrzysiekPomaga;
    }

    public By getHead() {
        return Head;
    }

    public By getLekarzSport() {
        return LekarzSport;
    }

    public By getTrainToWin() {
        return TrainToWin;
    }

    public By getJulekPeszko() {
        return JulekPeszko;
    }

    public By getGoSnow() {
        return GoSnow;
    }
}