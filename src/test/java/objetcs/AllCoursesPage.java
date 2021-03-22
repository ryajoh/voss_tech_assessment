package objetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocalAbstractScreen;

public class AllCoursesPage extends LocalAbstractScreen {

    public AllCoursesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "collections__heading")
    private WebElement allCoursesHeader;

    @FindBy(className = "header__user-avatar")
    WebElement userProfileIcon;

    @FindBy(linkText = "Sign Out")
    WebElement signOutButton;

    public void userClicksLogOutButton() throws InterruptedException {
        new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(allCoursesHeader));
        Thread.sleep(8000);
        userProfileIcon.click();
        signOutButton.click();
    }
}
