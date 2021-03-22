package tests;

import objetcs.*;
import org.testng.annotations.Test;
import utils.LocalWebTestBase;

public class VariousTests extends LocalWebTestBase {

    public VariousTests() {

    }

    @Test
    public void endToEndScenario() throws Exception {
        HomePage home = new HomePage(driver);
        LoginPage login = new LoginPage(driver);
        AllCoursesPage allCourses = new AllCoursesPage(driver);
        FillOutFormsPage fillOutForms = new FillOutFormsPage(driver);
        FakePricingPage pricing = new FakePricingPage(driver);

        home.verifyPageTitle();
        home.takeScreenShot();
        home.maximiseBrowser();
        home.userClicksLoginAutomationLink();
        login.userLogsInToCoursesSection("ryajoh@hotmail.com", "Password123$2");
        allCourses.userClicksLogOutButton();
        home.userClicksFillOutFormsLink();
        fillOutForms.addNameAndMessageDetailsForFirstSubmission();
        home.userClicksFakePricingPageLink();
        pricing.userPurchasesBasicPlan();
    }
}
