package objetcs;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.LocalAbstractScreen;

public class FillOutFormsPage extends LocalAbstractScreen {

    public FillOutFormsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "body")
    private WebElement body;

    @FindBy(id = "et_pb_contact_name_0")
    private WebElement nameTextField1;

    @FindBy(id = "et_pb_contact_name_1")
    private WebElement nameTextField2;

    @FindBy(id = "et_pb_contact_message_0")
    private WebElement messageTextArea1;

    @FindBy(id = "et_pb_contact_message_1")
    private WebElement messageTextArea2;

    @FindBy(className = "et_pb_contact_captcha_question")
    private WebElement captchaQuestion;

    @FindBy(name = "et_pb_contact_captcha_1")
    private WebElement captchaAnswer;

    @FindBy(name = "et_builder_submit_button")
    private WebElement submitButton1;

    @FindBy(xpath = "//*[text()='Thanks for contacting us']")
    private WebElement formOneFilledSuccessfully;

    @FindBy(xpath = "(//*[text()='Thanks for contacting us'])[2]")
    private WebElement formTwoFilledSuccessfully;

    public void addNameAndMessageDetailsForFirstSubmission() throws InterruptedException {

        driver.navigate().refresh();
        nameTextField1.sendKeys("Ryan");
        messageTextArea1.sendKeys("This is a test message 1");
        submitButton1.click();
        Assert.assertTrue(formOneFilledSuccessfully.isDisplayed());
        nameTextField2.sendKeys("Ryan");
        messageTextArea2.sendKeys("This is a test message 2");
        calculateCaptchaAnswer();
        submitButton1.click();
        Assert.assertTrue(formTwoFilledSuccessfully.isDisplayed());
    }

    public void calculateCaptchaAnswer() throws InterruptedException {
        String question = captchaQuestion.getText();
        String[] split = question.split("\\s+");
        int num1 = Integer.parseInt(split[0]);
        int num2 = Integer.parseInt(split[2]);
        int ans = 0;
        if (split[1].equals("+")) {
            ans = num1 + num2;
        }
        String answer = String.valueOf(ans);
        captchaAnswer.sendKeys(answer);
    }
}
