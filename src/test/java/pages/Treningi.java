package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Treningi {

WebDriver driver;

public Treningi(WebDriver driver){
    this.driver = driver;
}

    public void handleCookies(){
        driver.findElement(By.xpath("//div[@class='cmi-close']")).click();
    }
By Grafik = By.xpath("(//h2[normalize-space()='Grafik treningów'])[1]");
By GrafikPonLocator = By.xpath("(//div[@class='col-md-8'])[2]");
By GrafikCzwLocator = By.xpath("(//div[@class='col-md-8'])[3]");
String GrafikPonText = "    17:00 - 18:00\n" +
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
    public By getGrafik() {
        return Grafik;
    }

    public By getGrafikPon() {
        return GrafikPonLocator;
    }

    public By getGrafikCzw() {
        return GrafikCzwLocator;
    }

    public String getGrafikPonText() {
        return GrafikPonText;
    }

    public String getGrafikCzwText() {
        return GrafikCzwText;
    }
}
