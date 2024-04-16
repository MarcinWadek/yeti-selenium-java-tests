package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Onas extends Footer {

    @FindBy(xpath = "//div[@class='dph-image']//img[@class='lazyloaded']")
    public WebElement photoYeti;
    @FindBy(xpath = "//div/span[contains(text(), 'Nas')]")
    private WebElement pageTitle;
    public Onas(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Newsy checkOnas() {
        footer_newsy.click();
        return new Newsy(driver);
    }

    public Onas assertPageTitle(String expectedVale) {
        assertEquals(expectedVale, pageTitle.getText().toLowerCase());
        return this;
    }
}

