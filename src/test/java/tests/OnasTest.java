package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.Onas;

import static org.assertj.core.api.Assertions.assertThat;

public class OnasTest extends BaseTest {

    Onas onas;

    @BeforeEach
    void setOnas() {
        driver.get(config.getAboutUsURL());
        onas = new Onas(driver);

    }

    @Test
    @Epic("Website Architecture")
    @Feature("O nas Page")
    @DisplayName("Veryfing O nas HTML title name")
    void test_Accurate_Title_In_HTML_Addres() {
        onas.assertPageTitle("o nas");
    }

    @Test
    @Epic("Website Architecture")
    @Feature("O nas Page")
    @DisplayName("Veryfing O nas HTML page structure")
    void _test_Page_Source_Not_Corrupted() {
        assertThat(driver.getPageSource()).containsIgnoringCase("</html>");
    }
}
