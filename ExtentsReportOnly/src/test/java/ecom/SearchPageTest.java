package ecom;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import common_base.CommonBaseClass;
import ecommain.HomePageMain;

public class SearchPageTest extends CommonBaseClass{
	


	HomePageMain pfn = PageFactory.initElements(d, HomePageMain.class);


	@BeforeSuite
	public void extentreportinitialisation()
	{
		CommonBaseClass.extentconfig();
		
	}
	@BeforeMethod
	public void access() {
		
		CommonBaseClass.propertyconfig();
		CommonBaseClass.launchWebdriver();
	}

	@Test(priority=1)
	public void test1() {
		
		extenttest=extentreport.createTest("test1()");
	   System.out.println("this is first test1");

	}

	@Test(priority=2)
	public void contact_us() {
		
		extenttest=extentreport.createTest("contact_us()");
		  System.out.println("this is second test1");
	}

	@Test(priority=3)
	public void titletest3() {
		extenttest=extentreport.createTest("test3");
		String expt="awesome";
		String act=pfn.gettitle();
	    Assert.assertEquals(act, expt);
		  
	}
	
	
	@AfterMethod
	public void teardown(ITestResult r) throws Exception {   // ItestResult is belong to testNG hence write in only in testnG
		if(r.getStatus()==ITestResult.SUCCESS)
		{
			extenttest.log(Status.PASS, "Test case is passed" +r.getName());
			
		}
		
		
		else if(r.getStatus()==ITestResult.SKIP)
		{
			extenttest.log(Status.SKIP, "test case is skipped" +r.getName());
		}
		
		else if(r.getStatus()==ITestResult.FAILURE)
		{
			extenttest.log(Status.FAIL, "test case is failed" + r.getName());
			extenttest.log(Status.FAIL, r.getThrowable());
			String sd=CommonBaseClass.getscreenshot(d, r.getName());
			extenttest.addScreencastFromPath(sd);
		}

		d.quit();

	}
	
	@AfterSuite
	public void teardownforextents()
	{
		CommonBaseClass.teardownextent();
	}	
	
	
	
	
	
	
	
	

}
