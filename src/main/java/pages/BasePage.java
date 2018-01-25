package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import static setup.DriverSetup.getDriver;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
    Logger log = Logger.getLogger(Log.class.getName());
    protected WebDriver driver;
    public static final String BASE_URL =
            System.getProperty("selenium.url", "http://the-internet.herokuapp.com");

    public BasePage() {
        driver = getDriver();
        PageFactory.initElements(driver, this);
    }


    public void visit(String url) {
        log.info("Visiting " + url);
        driver.get(url);
        this.get();
    }

    public WebElement find(By locator) {
        log.info("Finding element by locator " + locator.toString());
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator) {
        log.info("Finding elements by locator " + locator.toString());
        return driver.findElements(locator);
    }

    public WebElement find(String cssSelector) {
        log.info("Finding element by cssSelector " + cssSelector);
        return find(By.cssSelector(cssSelector));
    }

    public void click(By locator) {
        log.info("Finding element by locator " + locator.toString());
        click(find(locator));
    }

    public void click(WebElement element) {
        log.info("Clicking on element " + element.toString());
        element.click();
    }

    public void click(String cssSelector) {
        log.info("Clicking on element " + cssSelector);
        click(find(cssSelector));
    }

    public void type(By locator, String text) {
        log.info("Typing " + text + " into element " + locator.toString());
        type(find(locator), text);
    }

    public void type(WebElement element, String text) {
        log.info("Typing " + text + " into element " + element.toString());
        element.sendKeys(text);
    }

    public void type(String cssSelector, String text) {
        log.info("Typing " + text + " into element " + cssSelector);
        type(find(cssSelector), text);
    }

    public boolean isDisplayed(WebElement element) {
        log.info("Checking element visibility " + element.toString());
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isDisplayed(By locator) {
        return isDisplayed(find(locator));
    }

    public boolean isDisplayed(String cssSelector) {
        return isDisplayed(find(cssSelector));
    }

    public boolean isDisplayed(WebElement element, Integer timeout) {
        log.info("Checking element visibility of " + element.toString());
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public boolean isNotDisplayed(WebElement element, Integer timeout) {
        log.info("Checking element invisibility of " + element.toString());
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    public WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public abstract String getUrl();

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        driver.getCurrentUrl().contains(getUrl());
    }
}
