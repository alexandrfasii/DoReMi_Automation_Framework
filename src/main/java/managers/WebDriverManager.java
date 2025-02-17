package managers;

import java.util.concurrent.TimeUnit;

import managers.drivermanager.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverManager {
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    public static WebDriver driver;
    private static DriverType driverType;

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
    }

    public WebDriver getDriver() {
        if (driver == null) driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() {
        switch (driverType) {
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
                driver = new ChromeDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) {
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
