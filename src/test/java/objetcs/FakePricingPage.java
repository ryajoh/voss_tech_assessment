package objetcs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.LocalAbstractScreen;

public class FakePricingPage extends LocalAbstractScreen {

    public FakePricingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//a[contains(@class, 'et_pb_pricing_table_button')])[2]")
    private WebElement purchaseBasicPlanButton;

    public void userPurchasesBasicPlan() {
        purchaseBasicPlanButton.click();

    }


}
