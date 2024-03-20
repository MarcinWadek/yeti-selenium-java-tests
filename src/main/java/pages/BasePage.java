package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    int timeoutSec = 10;

    @FindBy(xpath = "//div[@class='cmi-close']")
    WebElement cookies;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
        PageFactory.initElements(driver, this);
    }

    public WebElement find(WebElement element) {
        return element;
    }

    public void type(WebElement element, String text) {
        find(element).sendKeys(text);
    }

    public BasePage visit(String url) {
        driver.get(url);
        return this;
    }

    public void setTimeoutSec(int timeoutSec) {
        this.timeoutSec = timeoutSec;
    }

    public void handleCookies() {
        cookies.click();
    }

    public void click(WebElement element) {
        element.click();
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public boolean isImageDisplayed(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed();
    }

    public void goDown() {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
    }

    public void navigate() {
    }

    public void redirectToNewTab() {
        String originalTab = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalTab)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }
    public void verifyURL(String URLtoVerify){
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(URLtoVerify, currentUrl);
    }
    public boolean isDisplayed(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;  // Element is clickable, implying it is displayed
        } catch (TimeoutException e) {
            return false; // Element is not clickable within the timeout, hence not displayed
        }
    }


    public void elementDisplayed(WebElement element) {
        Assertions.assertTrue(isDisplayed(element));
    }
    public void elementNotDisplayed(WebElement element) {
        Assertions.assertFalse(isDisplayed(element));
    }
}

