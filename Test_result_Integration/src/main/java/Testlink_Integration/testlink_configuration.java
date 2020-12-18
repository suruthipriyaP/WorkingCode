package Testlink_Integration;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import utilities.*;
public class testlink_configuration {
	
	
	public static void updateResults(String Testcase_Name, String exception, String result, String notes) throws TestLinkAPIException {
	    TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(PropertyFile.prop.getProperty("APIKEY"), PropertyFile.prop.getProperty("Testlink_URL"));
	    
	    testlinkAPIClient.reportTestCaseResult(PropertyFile.prop.getProperty("project_Name"),
	    		PropertyFile.prop.getProperty("Test_Plan"), Testcase_Name, 
	    		PropertyFile.prop.getProperty("Build_Name"),notes, result,exception);

	}

}
