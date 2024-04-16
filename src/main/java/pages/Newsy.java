package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Newsy extends Footer {


    @FindBy(xpath = "//h3[normalize-space()='Szkolenia narciarskie']")
    private WebElement news_Szkolenia_Narciarskie;
    @FindBy(xpath = "//a[normalize-space()='2']")
    private WebElement nextPage;
    @FindBy(xpath = "(//a[normalize-space()='Newsy'])[1]")
    private WebElement pageTitle;
    @FindBy(xpath = "//h3[normalize-space()='Stroje klubowe 2024/25']")
    private WebElement stroje;
    @FindBy(xpath = "//h3[normalize-space()='ZAMÓWIENIA HEAD NA SEZON 2024/2025']")
    private WebElement zamowienia_Head;
    @FindBy(xpath = "//h3[normalize-space()='Szkolenia narciarskie']")
    private WebElement szkolenia_Narciarskie;
    @FindBy(xpath = "(//a[normalize-space()='Newsy'])[1]")
    private WebElement page_Newsy;
    public Newsy(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Treningi checkNewsy() {
        footer_treningi.click();
        return new Treningi(driver);
    }

    public Newsy news_Stroje() {
        stroje.click();
        return this;
    }

    public Newsy news_Zamowienia() {
        zamowienia_Head.click();
        return this;
    }

    public Newsy news_Szkolenia() {
        szkolenia_Narciarskie.click();
        return this;
    }

    public Newsy page_News() {
        page_Newsy.click();
        return this;
    }

    public Newsy more_News() {
        nextPage.click();
        return this;
    }

    public Newsy assertPageTitle(String expectedVale) {
        assertEquals(expectedVale, pageTitle.getText());
        return this;
    }


}