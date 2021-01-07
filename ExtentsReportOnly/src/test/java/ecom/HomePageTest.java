package ecom;

import org.openqa.selenium.WebDriver;
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

public class HomePageTest extends CommonBaseClass{
	
	HomePageMain sd= new HomePageMain();
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
	public void signin() throws Exception {
		
		extenttest=extentreport.createTest("signin()");
		pfn.click_on_sign();
	

	}

	@Test(priority=2)
	public void contact_us() throws Exception {
		
		extenttest=extentreport.createTest("contact_us()");
		pfn.click_Contact_us_link();
		
	}

	@Test(priority=3)
	public void enter_search() {
		extenttest=extentreport.createTest("enter_search");
		pfn.enter_search();
		 
	}

	@Test(priority=4)
	public void click_search_click() {
		extenttest=extentreport.createTest("click_search_click");
		pfn.enter_search();
		pfn.click_search_click();
		  
	}

	@Test(priority=5)
	public void title() {
		extenttest=extentreport.createTest("title");
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
