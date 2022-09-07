package seleexamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selefir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  System.setProperty("webdriver.chrome.driver",
		  "E:\\Jarfiles\\chromedriver_win32\\chromedriver.exe");
		  WebDriver driver=new
		  ChromeDriver(); driver.get("http://www.google.com");
		  driver.manage().window().maximize(); driver.quit();
		 ////
	}

}
