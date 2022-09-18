package seleexamples;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
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
	 ExtentSparkReporter spark;
	 ExtentTest Testcase;
	@BeforeSuite
	public void bs() {
	
		spark=new ExtentSparkReporter("Extentreport.html");
		extentReport=new ExtentReports();
		extentReport.attachReporter(spark);
		 System.setProperty("webdriver.chrome.driver",
				  "E:\\Jarfiles\\chromedriver_win32\\chromedriver.exe");
				   driver=new
				  ChromeDriver();
				 //  spark.config().
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
	public void method2() throws IOException, InterruptedException {
		/*
		 * System.out.println("Sample Test Test case 1"); Assert.assertEquals(false,
		 * true);
		 */
		Testcase=extentReport.createTest("Opening Bing");
    	driver.get("https://www.bing.com/");
    	//Thread.sleep(3000);
    	if(driver.getTitle().equals("google1")) 
    	{//
    		Testcase.pass("Values are matching");
    		Testcase.log(Status.PASS, "Opened Bing Successfully");
    	}else {
    		Testcase.fail("Values are not matching");
    		TakesScreenshot screenshot=(TakesScreenshot)driver;
    		File source=screenshot.getScreenshotAs(OutputType.FILE);
    		File destination=new File("extentsample.png");
    		FileHandler.copy(source, destination);
    		Testcase.addScreenCaptureFromPath("extentsample.png");
    		Testcase.log(Status.FAIL, "Not Opened Bing Successfully");
    	}
    	
    }
}
