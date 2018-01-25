package pages;

import static setup.DriverSetup.getDriver;

public class MultiWindowsPage extends BasePage {
    public MultiWindowsPage(){
        visit(getUrl());
    }

    public String getUrl() {
        return BASE_URL + "/windows";
    }

    public void clickLink(){
        find(".example a").click();
    }

    public Object[] getAllWindows(){
        return driver.getWindowHandles().toArray();
    }

    public void switchToWindow(int index){
        driver.switchTo().window(getAllWindows()[index].toString());
    }


}
