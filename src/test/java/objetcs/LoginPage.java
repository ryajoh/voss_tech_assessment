package objetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LocalAbstractScreen;

public class LoginPage extends LocalAbstractScreen {
    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public WebDriver driver;

    @FindBy(id = "user[email]")
    WebElement emailTextField;

    @FindBy(id = "user[password]")
    WebElement passwordTextField;

    @FindBy(xpath = "//input[@value='Sign in']")
    WebElement signInButton;

    public void userLogsInToCoursesSection(String username, String password) throws InterruptedException {
        emailTextField.sendKeys(username);
        passwordTextField.sendKeys(password);
        signInButton.click();
    }
}
