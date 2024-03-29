package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Onas extends BasePage{

    public Onas(WebDriver driver) {
        super(driver);
        visit("https://yeti.org.pl/o-nas/");
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='dph-image']//img[@class='lazyloaded']")
    public WebElement photoYeti;
    @FindBy(xpath = "//div/span[contains(text(), 'Nas')]")
    private WebElement pageTitle;

    public Newsy checkOnas(WebElement element){
        element.click();
        return new Newsy(driver);
    }

    public Onas assertPageTitle(String expectedVale) {
        assertEquals(expectedVale, pageTitle.getText().toLowerCase());
        return this;
    }
}

