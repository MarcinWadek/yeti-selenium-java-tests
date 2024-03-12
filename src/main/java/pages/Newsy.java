package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Newsy extends BasePage{


    public Newsy (WebDriver driver){
        super(driver);
        visit("https://yeti.org.pl/newsy/");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[normalize-space()='Szkolenia narciarskie']")
    private WebElement news_Szkolenia_Narciarskie;

    @FindBy(xpath = "//a[normalize-space()='2']")
    private WebElement nextPage;

    public Treningi checkNewsy(WebElement element){
        element.click();
        return new Treningi(driver);
    }

}