package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LocalAbstractScreen {

    public WebDriver driver;

    public LocalAbstractScreen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LocalAbstractScreen() {

    }
}
