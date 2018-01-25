package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static setup.DriverSetup.getDriver;

public class GoogleSearchPage extends BasePage {
    private By searchInput = By.cssSelector("input#lst-ib");
    private By searchButton = By.cssSelector("input[name='btnK']");

    public GoogleSearchPage(){
        visit(getUrl());
    }

    @Override
    public String getUrl() {
        return "http://google.com";
    }

    public void clickSearchButton(){
        click(searchButton);
    }
     public void typeSearchText(String text) {
        type(searchInput, text);
     }

     public void search(String text){
        typeSearchText(text);
        clickSearchButton();
     }
public WebElement getFirstResult(){
        List<WebElement> elements = findElements(By.cssSelector(".rc .r"));
        return elements.get(0);
}

}
