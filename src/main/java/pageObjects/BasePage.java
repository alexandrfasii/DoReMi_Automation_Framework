package pageObjects;

import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverFactory.driver, this);
    }
}
