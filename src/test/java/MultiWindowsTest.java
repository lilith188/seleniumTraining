import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MultiWindowsPage;

public class MultiWindowsTest extends BaseTest {
    private MultiWindowsPage multiWindowsPage;


    @BeforeMethod
    public void setUp(){
        multiWindowsPage = new MultiWindowsPage();
    }

    @Test
    public void windowChange(){
        multiWindowsPage.clickLink();
        multiWindowsPage.switchToWindow(0);
    }
}
