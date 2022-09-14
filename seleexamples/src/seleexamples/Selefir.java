package seleexamples;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selefir {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		
		  System.setProperty("webdriver.chrome.driver",
		  "E:\\Jarfiles\\chromedriver_win32\\chromedriver.exe");
		  WebDriver driver=new
		  ChromeDriver();
		  //Implicit wait
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.get("http://www.google.com");
		  driver.manage().window().maximize();// driver.quit();
		 ////
		//  driver.get("http://www.phptravels.net/login");
		  driver.get("http://www.leafground.com");
		  Thread.sleep(3000);
		  TakesScreenshot screenshot= (TakesScreenshot)driver;
		  File sourcefile=screenshot.getScreenshotAs(OutputType.FILE);
		  File destfile=new File("Sample.png");
		  FileHandler.copy(sourcefile, destfile);
			/*
			 * driver.findElement(By.name("email")).sendKeys("harialbie@phptravels.com");
			 * driver.findElement(By.name("password")).sendKeys("demouser");
			 * driver.findElement(By.xpath("//button[@type='submit']")).click();
			 */
		  
		//WebElement ele= driver.findElement(By.xpath("//a[@title='flights']"));
		  
		/*
		 * //Explicit wait WebDriverWait wait = new WebDriverWait(driver, null);
		 * WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//a[@title='flights']")));
		 */
			 
		// ele.click();
		  
		//Fluent Wait
		/*
		 * Wait wait= new
		 * FluentWait(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.
		 * ofSeconds(4)).ignoring(Exception.class);
		 * 
		 * WebElement ele = wait.until((Function) new Function() {
		 * 
		 * 
		 * 
		 * @Override public WebElement apply(WebDriver driver) { // TODO Auto-generated
		 * return driver.findElement(By.xpath("//a[@title='flights']")); }
		 * 
		 * });
		 */
		 
		  
		  System.out.println("Test completed");
		  driver.quit();
		  //driver.close(); difference is close current( driver has focus of) browser window quit closes all browser opened by driver
	}

}
