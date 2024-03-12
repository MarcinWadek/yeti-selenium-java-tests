package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Onas extends BasePage{

    public Onas(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/o-nas/");
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='dph-image']//img[@class='lazyloaded']")
    public WebElement photoYeti;


    public Newsy checkOnas(WebElement element){
        element.click();
        return new Newsy(driver);
    }
}

