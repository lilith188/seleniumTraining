import org.testng.annotations.Test;
import pages.CheckBoxPage;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertFalse;

public class CheckBoxTest extends BaseTest {

    @Test
    public void checkboxSelect() {
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        assertFalse(checkBoxPage.getCheckBox(0).isSelected());
        checkBoxPage.clickOnCheckBox(0);
        assertTrue(checkBoxPage.getCheckBox(0).isSelected());

    }
}
