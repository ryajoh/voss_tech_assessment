package objetcs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import utils.LocalAbstractScreen;

import java.io.File;

import static utils.LocalWebTestBase.browserWindow;

public class HomePage extends LocalAbstractScreen {

    public HomePage(WebDriver driver) {
        super(driver);

    }

    @FindBy(linkText = "Login automation")
    WebElement loginAutomationLink;

    @FindBy(linkText = "Fill out forms")
    WebElement fillOutFormsLink;

    @FindBy(linkText = "Fake Pricing Page")
    WebElement fakePricingPageLink;

    public void verifyPageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Practice - Ultimate QA";

        Assert.assertEquals(expectedTitle, actualTitle, "The actual title does not match the expected title!");
    }

    public void takeScreenShot() throws Exception{
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        if (browserWindow.equals("chrome")) {
            FileUtils.copyFile(scrFile, new File("screenshots\\screenshot_chrome.png"));
        } else if (browserWindow.equals("firefox")) {
            FileUtils.copyFile(scrFile, new File("screenshots\\screenshot_firefox.png"));
        }
    }

    public void maximiseBrowser() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    public void userClicksLoginAutomationLink() {
        loginAutomationLink.click();
    }

    public void userClicksFillOutFormsLink() throws InterruptedException {
        goToHomePage();
        fillOutFormsLink.click();
    }

    public void userClicksFakePricingPageLink() throws InterruptedException {
        goToHomePage();
        fakePricingPageLink.click();

    }

    public void goToHomePage() {
        driver.get("https://ultimateqa.com/automation/");
    }

}
