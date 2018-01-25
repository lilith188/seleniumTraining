import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoverPage;

import static org.testng.Assert.assertTrue;

public class HoverTest extends BaseTest {
    private HoverPage hoverPage;

    @BeforeMethod
    public void setUp() {
        hoverPage = new HoverPage();
    }

    @Test
    public void hoverOnAvatar() {
     //   assertTrue(hoverPage.isHeaderNotDisplayed(), "Header was visible!");
        hoverPage.hoverAvatar();
        assertTrue(hoverPage.isHeaderDisplayed(), "Header was not visible!");

        assertTrue(hoverPage.getHeader().getText().contains("name: user1"), "Header text was not correct");

    }


}
