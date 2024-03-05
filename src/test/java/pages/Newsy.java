package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class Newsy extends BasePage{


    public Newsy (WebDriver driver){
        super(driver);
        visit("https://yeti.org.pl/newsy/");
    }

    By news_Szkolenia_Narciarskie = By.xpath("//h3[normalize-space()='Szkolenia narciarskie']");
    By nextPage = By.xpath("//a[normalize-space()='2']");

    public By getNews_Szkolenia_Narciarskie() {
        return news_Szkolenia_Narciarskie;
    }

    public By getNextPage() {
        return nextPage;
    }
}