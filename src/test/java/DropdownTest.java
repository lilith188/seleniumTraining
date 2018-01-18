import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropdownPage;

import static org.testng.AssertJUnit.assertEquals;

public class DropdownTest extends BaseTest {
    private DropdownPage dropdownPage;


    @BeforeMethod
    public void setUp() {
        dropdownPage = new DropdownPage();
    }

    @Test
    public void dropdownSelect(){
        dropdownPage.selectOption("Option 2");
        assertEquals(dropdownPage.getSelectedOption(),"Option 2");
    }

    @Test
    public void alert() {
        dropdownPage.forceAlert();
        dropdownPage.closeAlert();
    }
}
