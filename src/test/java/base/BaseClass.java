package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import utils.PageObjectManager;
import utils.WaitUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class BaseClass {
    protected WebDriver driver;
    protected PageObjectManager pageObjectManager;
    protected WaitUtils waitUtils;
    protected TakesScreenshot takesScreenshot;

    @BeforeMethod
    public void setDriver() throws MalformedURLException {
        String runMode = ConfigReader.getProperty("runMode");
        String browser = ConfigReader.getProperty("browser");
        String url = ConfigReader.getProperty("url");

        if (runMode.equalsIgnoreCase("remote")) {
            String sauceUsername = ConfigReader.getProperty("sauceUsername");
            String sauceAccessKey = ConfigReader.getProperty("sauceAccessKey");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browserName", browser);
            caps.setCapability("browserVersion", "latest");
            caps.setCapability("platformName", "Windows 11");

            URL sauceURL = new URL("https://" + sauceUsername + ":" + sauceAccessKey + "@ondemand.us-west-1.saucelabs.com:443/wd/hub");

            driver = new RemoteWebDriver(sauceURL, caps);
            System.out.println("Running tests on Sauce Labs Cloud...");
        } else {
            driver = new ChromeDriver();
            System.out.println("Running test locally on chrome browser..");
        }

        driver.get(url);
        driver.manage().window().maximize();
        pageObjectManager = new PageObjectManager(driver);
        waitUtils = new WaitUtils(driver, ConfigReader.getLongProperty("explicitWait"));
        takesScreenshot = (TakesScreenshot) driver;
    }

    @AfterMethod
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + testName + ".png");
            dest.getParentFile().mkdirs();
            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error Saving screenshot: " + e.getMessage());
        }
    }
}


