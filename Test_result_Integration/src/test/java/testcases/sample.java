package testcases;
	 
	import java.util.concurrent.TimeUnit;
import base_class.*;
import org.openqa.selenium.By;


import org.testng.annotations.Test;

import testlink.api.java.client.TestLinkAPIClient;
	import testlink.api.java.client.TestLinkAPIException;
	import testlink.api.java.client.TestLinkAPIResults;
	 
	public class sample extends Test_class{
	 
	public static String DEVKEY="2b9b04ffb74b0065364466684c2df562";
	public static String URL="http://182.74.106.218//testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	 
	public static void reportResult(String TestProject,String TestPlan,String Testcase,String Build,String Notes,String Result) throws TestLinkAPIException{
	TestLinkAPIClient api=new TestLinkAPIClient(DEVKEY, URL);
	api.reportTestCaseResult(TestProject, TestPlan, Testcase, Build, Notes, Result);
	}
	 
	@Test
	public void Test1()throws Exception
	{
		//sample a=new sample();
	//WebDriver driver=new ChromeDriver();

	String testProject="Demo Project";
	String testPlan="Plan 1";
	String testCase="US132_TC01_Verify if Admin is able to Deactivate a role without user mapped";
	String build="Build #01";
	String notes=null;
	String result=null;
	try{
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@href='/loginUser']")).click();

	driver.findElement(By.xpath("//*[@id='userNameInput']")).sendKeys("suruthi@telliant.net");

	driver.findElement(By.xpath("//*[@id='passwordInput//']")).sendKeys("Welcome@123");

	driver.findElement(By.xpath("//*[@class='btn btn-gray ']")).click();

	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	result= TestLinkAPIResults.TEST_PASSED;
	notes="Executed successfully2";
	}
	catch(Exception e){
	result=TestLinkAPIResults.TEST_FAILED;
	notes="Execution failed2";
	}
	finally{
	 
	sample.reportResult(testProject, testPlan, testCase, build, notes, result);
	driver.quit();
	}
	}
	}

