import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicLoadPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DynamicLoadTest {

    private ChromeDriver driver;
    private DynamicLoadPage dynamicLoadPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\seleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        dynamicLoadPage = new DynamicLoadPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void dynamicLoad(){
        dynamicLoadPage.clickStart();
        assertTrue(dynamicLoadPage.isLoadingDisplayed());
        assertTrue(dynamicLoadPage.isLoadingNotDisplayed());
        assertTrue(dynamicLoadPage.isFinishDisplayed());
        assertEquals(dynamicLoadPage.getFinish().getText(), "Hello World!");
    }
}
