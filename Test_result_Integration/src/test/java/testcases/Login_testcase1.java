package testcases;

import base_class.Test_class;
import testlink.api.java.client.TestLinkAPIResults;
import utilities.PropertyFile;

import java.lang.reflect.Method;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import PageObject.*;
import Testlink_Integration.*;

public class Login_testcase1 extends Test_class {
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	static String notes = null;
	static String testresult = null;
	public static String Actual;
	public static String Expected;
//	static String TestcaseID = null;

	@Test(priority = 1, testName = "test1", description = "DP-62")

	public void Login() throws Exception {
		//TestcaseID = "DP-62";
		loginpage.Clickloginlink();
		loginpage.enterUserName(PropertyFile.prop.getProperty("Myusername"));
		loginpage.enterPassword(PropertyFile.prop.getProperty("Mypassword"));
		loginpage.submitLogin();
		// Validation part
		Actual = loginpage.validateLoginScreen();
		Expected = PropertyFile.prop.getProperty("ExpectedLoggedUser");
		Assert.assertEquals(Actual, Expected);
		
	}

	@Test(priority = 2, testName = "test2", description = "DP-61")
	public void viewtimesheet() throws Throwable {
		//TestcaseID = "DP-61";
		homePage.clickOnViewTimesheetLink();
		Actual = homePage.validateViewTimeSheetpage();
		Expected = PropertyFile.prop.getProperty("ExpectedURl");
		Assert.assertEquals(Actual, Expected);
		
	}

	@AfterMethod

	public static void writeResult(ITestResult result) throws Exception {
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {

				notes = "Executed successfully11";
				testresult = TestLinkAPIResults.TEST_PASSED;
				// testlink_configuration.updateResults(TestcaseID, null,testresult, notes);
			}

			else if (result.getStatus() == ITestResult.FAILURE) {

				System.out.println("Log Message:: @AfterMethod: Method-" + "- has Failed");
				notes = "Execution Failed11";
				testresult = TestLinkAPIResults.TEST_FAILED;
				// testlink_configuration.updateResults("testcaseID, null,testresult, notes);
				

			}
		} catch (Exception e) {
			System.out.println("\nLog Message::@AfterMethod: Exception caught");
			notes = "Caught new Expection";
			
			testresult = TestLinkAPIResults.TEST_FAILED;
			// testlink_configuration.updateResults("testcaseID, null,testresult, notes);
			
		} finally {

			testlink_configuration.updateResults(result.getMethod().getDescription(), null, testresult, notes);
		}

	}
	

    @BeforeMethod
    public void testSetup(@Optional Method method) throws Exception {
        String description = method.getAnnotation(Test.class).description();
    System.out.println(""+description);
    }
}
  

