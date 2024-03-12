package assertions;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class assertmethods {

    WebDriver driver;
    public void verifyURL(String URLtoVerify){
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(URLtoVerify, currentUrl);
    }
}
