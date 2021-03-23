package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public abstract class LocalWebTestBase {

    public WebDriver driver;
    String url = "https://ultimateqa.com/automation/";
    public static String browserWindow;

    @BeforeTest
    @Parameters("browser")
    public void setup( @org.testng.annotations.Optional String browser) throws Exception{
        if(browser == null || browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            browserWindow = "chrome";
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            browserWindow = "firefox";
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}