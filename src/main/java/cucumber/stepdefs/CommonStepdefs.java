package cucumber.stepdefs;

import managers.drivermanager.BaseDriver;
import org.openqa.selenium.WebElement;

public class CommonStepdefs extends BaseDriver {

    public void click(WebElement webElement) {
        webElement.click();
    }
}
