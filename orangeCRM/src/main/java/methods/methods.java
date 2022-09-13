package methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.pages;

//Author: Benito Paul G J
//HR: Divya Srinivasan
//Date given: 12-sep-2022 9:30 PM

//This class contains all the methods used by the components.
// All the DOM WebEmelemt locators are inherited from the page class.
public class methods extends pages {

	public static WebDriver driver1;
	public static WebDriverWait Driverwait;
	

	public static boolean OpenBrowser(String url) {

		try {
			
			System.setProperty("webdriver.chrome.driver", ".//driver.//chromedriver104.exe");
			driver1 = new ChromeDriver();
			Driverwait = new WebDriverWait(driver1, 5);
			
			System.out.println("*****************Inside OpenBrowser************************");
			driver1.get(url);
			driver1.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

			driver1.manage().window().maximize();

			Thread.sleep(100);

			driver1.manage().timeouts();
			
			return true;
		} catch (Exception e) {
			System.out.println("Exception occurred in open broswer Method:  " + e);
			return false;
		}

	}
	
	public static boolean sendkeys(String locators, String value) {
	
		// TODO Auto-generated method stub
		driver1.findElement(By.xpath(locators)).sendKeys(value);
		return true;
	}

	public static boolean pageloadcheck(String locator) {
		// TODO Auto-generated method stub
		
		try
		{
		System.out.println("**pageloadcheck method in progress****");
		System.out.println("asas::"+locator);
		WebDriverWait wait = new WebDriverWait(driver1, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		
		return false;
		
		}
		catch(Exception e)
		{
			System.out.println("Exception occurred is:"+e);
			return false;
		}
		
	}
	

	public static void click(String locator) {
		try
		{
		

		driver1.findElement(By.xpath(locator)).click();
	
		System.out.println("PAGE titile is"+driver1.getTitle());
		}
		catch(Exception e)
		{
			System.out.println("exception:"+e);
		}
	}



	
}
