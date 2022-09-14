package seleexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class seleniumsec {
	 WebDriver driver;
	 ExtentReports extentReport;
	 ExtentSparkReporter html;
	 ExtentTest Testcase;
	@BeforeSuite
	public void bs() {
	
		html=new ExtentSparkReporter("Extentreport.html");
		extentReport=new ExtentReports();
		extentReport.attachReporter(html);
		 System.setProperty("webdriver.chrome.driver",
				  "E:\\Jarfiles\\chromedriver_win32\\chromedriver.exe");
				   driver=new
				  ChromeDriver();
	}
	
	@AfterSuite
	public void as() {
		extentReport.flush();
		driver.quit();
	}
	
	@Test
	public void method1() {
    	//System.out.println("Sample Test Test case Started...");
    	Testcase=extentReport.createTest("Opening google");
    	driver.get("https://www.google.com/");
    	Testcase.log(Status.PASS, "Opened Google Successfully");
    }
	@Test
	public void method2() {
		/*
		 * System.out.println("Sample Test Test case 1"); Assert.assertEquals(false,
		 * true);
		 */
		Testcase=extentReport.createTest("Opening Bing");
    	driver.get("https://www.bing.com/");
    	Testcase.log(Status.PASS, "Opened Bing Successfully");
    }
}
