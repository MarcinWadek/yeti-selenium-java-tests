package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Onas extends Footer {

    @FindBy(xpath = "//div[@class='dph-image']//img[@class='lazyloaded']")
    public WebElement photoYetiOne;
    @FindBy(xpath = "//div[@class='swib-image swib-right']//img[@class='lazyloaded']")
    public WebElement photoYetiTwo;
    @FindBy(css = "img[src='https://yeti.org.pl/wp-content/uploads/2020/05/2016-02-19_52-scaled.jpg']")
    public WebElement photoYetiThree;
    @FindBy(css = "img[src='https://yeti.org.pl/wp-content/uploads/2020/05/MG_8442-scaled.jpg']")
    public WebElement photoYetiFour;
    @FindBy(css = "img[src='https://yeti.org.pl/wp-content/uploads/2020/05/2016-04-09_66-1-scaled.jpg']")
    public WebElement photoYetiFive;
    @FindBy(css = "img[src='https://yeti.org.pl/wp-content/uploads/2020/06/MG_1569-scaled.jpg']")
    public WebElement photoYetiSix;
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
    public Onas YetiPhotoOneDisplayed(){
        elementDisplayed(photoYetiOne);
        return this;
    }
    public Onas YetiPhotoTwoDisplayed(){
        goDown();
        elementDisplayed(photoYetiTwo);
        return this;
    }
    public Onas YetiPhotoThreeDisplayed(){
        goDown();
        elementDisplayed(photoYetiThree);
        return this;
    }
    public Onas YetiPhotoFourDisplayed(){
        goDown();
        elementDisplayed(photoYetiFour);
        return this;
    }
    public Onas YetiPhotoFiveDisplayed(){
        goDown();
        elementDisplayed(photoYetiFive);
        return this;
    }
    public Onas YetiPhotoSixDisplayed(){
        goDown();
        elementDisplayed(photoYetiSix);
        return this;
    }


}

