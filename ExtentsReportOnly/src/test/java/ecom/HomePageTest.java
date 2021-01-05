package ecom;

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

public class HomePageTest extends CommonBaseClass{
	
	HomePageMain<Object> h = new HomePageMain<Object>();
	//HomePageMain pf = PageFactory.initElements(d, HomePageMain.class);

	
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
	public void signin() throws Exception {
		
		extenttest=extentreport.createTest("signin()");
		h.click_on_sign();
		Thread.sleep(5000); 
		
		
	}

	@Test(priority=2)
	public void contact_us() throws Exception {
		
		extenttest=extentreport.createTest("contact_us()");
		h.click_Contact_us_link();
		Thread.sleep(5000); 
	}

	@Test(priority=3)
	public void enter_search() {
		extenttest=extentreport.createTest("enter_search");
		h.enter_search();
		 
	}

	@Test(priority=4)
	public void click_search_click() {
		extenttest=extentreport.createTest("click_search_click");
		h.enter_search();
		h.click_search_click();
		  
	}

	@Test(priority=5)
	public void title() {
		extenttest=extentreport.createTest("title");
		String expt="awesome";
		String act=h.gettitle();
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
			String sd=h.getscreenshot(d, r.getName());
			extenttest.addScreencastFromPath(sd);
		}

		d.quit();

	}
	
	@AfterSuite
	public void teardownforextents()
	{
		HomePageMain.teardownextent();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
