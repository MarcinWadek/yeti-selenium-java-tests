package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Onas extends BasePage{

    public Onas(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/o-nas/");
    }

    By photoYeti = By.xpath("//div[@class='dph-image']//img[@class='lazyloaded']");

    public By getPhotoYeti() {
        return photoYeti;
    }
}

