import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DragAndDropPage;

import static org.testng.AssertJUnit.assertEquals;

public class DragAndDropTest extends BaseTest{
    private DragAndDropPage dragAndDropPage;


    @BeforeMethod
    public void setUp(){
        dragAndDropPage = (DragAndDropPage) new DragAndDropPage().get();
    }

    @Test
    public void dragAndDrop (){
        assertEquals(dragAndDropPage.getDropText(), "Drop here");
        dragAndDropPage.dragAndDrop();
        assertEquals(dragAndDropPage.getDropText(), "Dropped!");
    }
}
