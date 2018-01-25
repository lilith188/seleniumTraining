package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static setup.DriverSetup.getDriver;

public class DynamicLoadPage extends BasePage {
    private By startButton = By.cssSelector("#start button");
    private By finishText = By.id("finish");
    private By loadingText = By.id("loading");

    public DynamicLoadPage() {
        visit(getUrl());
    }

    @Override
    public String getUrl() {
        return BASE_URL + "/dynamic_loading/1";
    }

    public void clickStart() {
        click(startButton);
    }

    public boolean isFinishDisplayed() {
        return isDisplayed(find(finishText), 10);
    }

    public boolean isLoadingDisplayed() {
        return isDisplayed(find(loadingText), 10);
    }

    public boolean isLoadingNotDisplayed() {
        return isNotDisplayed(find(loadingText), 10);
    }

    public WebElement getFinish() {
        return find(finishText);
    }
}
