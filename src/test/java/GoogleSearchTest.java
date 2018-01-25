import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

import static org.testng.AssertJUnit.assertTrue;

public class GoogleSearchTest {
    private GoogleSearchPage googleSearchPage;



    @BeforeMethod
    public void setUp(){
        googleSearchPage = new GoogleSearchPage();
    }


    @Test
    public void searchTest(){
        googleSearchPage.search("Armenia");
        assertTrue(googleSearchPage.getFirstResult().getText().contains("Wikipedia"));
    }
}
