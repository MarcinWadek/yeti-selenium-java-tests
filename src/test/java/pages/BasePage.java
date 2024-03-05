package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    int timeoutSec = 30;

    By cookies = By.xpath("//div[@class='cmi-close']");

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
    }

    public void visit(String url){
        driver.get(url);
    }
    public void setTimeoutSec(int timeoutSec) {
        this.timeoutSec = timeoutSec;
    }
    public void handleCookies(){
        driver.findElement(cookies).click();
    }
    public void clickElement(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.click();
    }
    public boolean isImageDisplayed(By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
    }


}
