package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Treningi extends Footer {

    String GrafikPonText = "17:00 - 18:00\n" +
            "yetiludki\n" +
            "/\n" +
            "klasa 1-3\n" +
            "18:00 - 19:00\n" +
            "młodsi\n" +
            "/\n" +
            "klasa 4-6\n" +
            "19:00 - 20:00\n" +
            "starsi\n" +
            "/\n" +
            "klasa 7-8 + liceum\n" +
            "20:00 - 20:45\n" +
            "senior\n" +
            "/";
    String GrafikCzwText = "18:30 - 19:15\n" +
            "yetiludki\n" +
            "/\n" +
            "klasa 1-3\n" +
            "19:15 - 20:00\n" +
            "młodsi\n" +
            "/\n" +
            "klasa 4-6\n" +
            "18:30 - 19:15\n" +
            "starsi\n" +
            "/\n" +
            "klasa 7-8 + liceum\n" +
            "19:15 - 20:00\n" +
            "senior\n" +
            "/";
    @FindBy(xpath = "(//h2[normalize-space()='Grafik treningów'])[1]")
    private WebElement Grafik;
    @FindBy(xpath = "(//div[@class='col-md-8'])[1]")
    private WebElement GrafikPonLocator;
    @FindBy(xpath = "(//div[@class='col-md-8'])[2]")
    private WebElement GrafikCzwLocator;
    @FindBy(xpath = "//h1[contains(text(), 'Treningi')]")
    private WebElement pageTitle;

    public Treningi(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Wyjazdy checkTreningi() {
        footer_wyjazdy.click();
        return new Wyjazdy(driver);
    }

    public Treningi assertPageTitle(String expectedVale) {
        assertEquals(expectedVale, pageTitle.getText());
        return this;
    }

    public Treningi verifyMondayTrainingsText() {
        Assertions.assertEquals(GrafikPonText, GrafikPonLocator.getText());
        return this;
    }

    public Treningi verifyThursdayTrainingsText() {
        Assertions.assertEquals(GrafikCzwText, GrafikCzwLocator.getText());
        return this;
    }
}
