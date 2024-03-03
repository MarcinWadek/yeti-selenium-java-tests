package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Onas {

    WebDriver driver;

    public Onas(WebDriver driver) {
        this.driver = driver;
    }

    public void handleCookies(){
        driver.findElement(By.xpath("//div[@class='cmi-close']")).click();
    }
    By photoYeti = By.xpath("//div[@class='dph-image']//img[@class='lazyloaded']");

    public boolean getPhotoYeti() {
        return driver.findElement(photoYeti).isDisplayed();
    }
}
