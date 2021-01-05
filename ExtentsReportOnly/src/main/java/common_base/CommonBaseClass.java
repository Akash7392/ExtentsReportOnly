package common_base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class CommonBaseClass {
	

	public static WebDriver d;
	public static Properties prop;
	public static ExtentHtmlReporter extenthtmlreporter;
	public static ExtentReports extentreport;
	public static ExtentTest extenttest;

	public static void launchWebdriver() {
		System.setProperty("webdriver.chrome.driver", prop.getProperty("browserpath"));
		d = new ChromeDriver();
		d.get(prop.getProperty("url"));
		d.manage().window().maximize();
		d.manage().deleteAllCookies();
		implicitwait(10);
	}

	public static void propertyconfig() {
		prop = new Properties();

		try {
			FileInputStream f = new FileInputStream(
					"D:\\Eclipse\\eclipse-workspace\\ExtentsReportOnly\\src\\main\\java\\propertycongiguration\\config.properties");
			prop.load(f);
			
		}

		catch (Exception e) {
			System.out.println("file not founds");
		}

	}

	public static void implicitwait(long l) {
		d.manage().timeouts().implicitlyWait(l, TimeUnit.SECONDS);
	}

	public String getscreenshot(WebDriver wd, String name) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) wd;
		File s = ts.getScreenshotAs(OutputType.FILE);
		File d = new File(prop.getProperty("failscreenshotpath") + name + ".png");
	    Files.copy(s, d);
		String dest ="D:\\Eclipse\\eclipse-workspace\\ExtentsReportOnly\\Failedscreenshot\\";
		System.out.println(dest);
		return dest;

	}

	public static void extentconfig() {
		
	 extenthtmlreporter = new ExtentHtmlReporter("D:\\Eclipse\\eclipse-workspace\\ExtentsReportOnly\\ecomreport\\ecomtestresult.html");
	 extenthtmlreporter.config().setDocumentTitle("ecomtestresult");	
	 extenthtmlreporter.config().setReportName("ecomreport");
	 extenthtmlreporter.config().setTheme(Theme.DARK);
	 extentreport = new ExtentReports();
	 extentreport.attachReporter(extenthtmlreporter);
	 
	extentreport.setSystemInfo("UserName", "Akash");
	extentreport.setSystemInfo("BrowserName", "Chrome");
	extentreport.setSystemInfo("HostNmae","10.102.123.128");
	extentreport.setSystemInfo("OS","Window");
	}

  public static void teardownextent()
  {
	  extentreport.flush();
  }
	
	
	
}
