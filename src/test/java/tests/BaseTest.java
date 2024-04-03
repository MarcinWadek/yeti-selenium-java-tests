package tests;

import com.github.javafaker.Faker;
import config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import pages.Footer;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected Config config;

    @BeforeEach
    public void baseBeforeClass() {
        config = new Config();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-in-process-stack-traces");
        options.addArguments("--disable-logging");
        options.addArguments("--log-level=3");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(config.getApplicationURL());
        }

    @AfterEach
    void teardown() {
        driver.quit();
    }
    public void baseAfterMethod() {
        driver.manage().deleteAllCookies();
    }
}