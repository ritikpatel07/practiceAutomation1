package seleniumEx.threadSafety;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverTest2_ThreadSafeVersion {
	WebDriver driver;
	
	@Test
	public void t1() {
		driver = new ChromeDriver();
		DriverManager.setDriver(driver);
		
		DriverManager.getDriver().get("https://www.google.com/");
		System.out.println(DriverManager.getDriver().getTitle());
		
		DriverManager.getDriver().quit();
	}
	
	@Test
	public void t2() {
		driver = new ChromeDriver();
		DriverManager.setDriver(driver);
		
		DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");
		System.out.println(DriverManager.getDriver().getTitle());
		
		DriverManager.getDriver().quit();
	}
}
