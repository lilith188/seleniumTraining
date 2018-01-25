package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Logger;

import static setup.DriverSetup.getDriver;

public class DragAndDropPage extends BasePage {
    Logger log = Logger.getLogger(Log.class.getName());

    public DragAndDropPage(){
        visit(getUrl());
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        log.info("Hi I'm in");
        waitForElement(find(By.cssSelector(".ui-draggable")));
    }

    public String getUrl(){
        return "http://jqueryui.com/resources/demos/droppable/default.html";
    }
    public void dragAndDrop(){
        WebElement draggable = find(By.cssSelector(".ui-draggable"));
        WebElement droppable = find(By.cssSelector(".ui-droppable"));
        dragAndDrop(draggable, droppable);
    }



    public void dragAndDrop(WebElement draggable, WebElement droppable){
    Actions actions = new Actions(getDriver());
        actions.dragAndDrop(draggable, droppable).build().perform();
}

public String getDropText(){
        return find(By.cssSelector(".ui-droppable")).getText();
}






}
