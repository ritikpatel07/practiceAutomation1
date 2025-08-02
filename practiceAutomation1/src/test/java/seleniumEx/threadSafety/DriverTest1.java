package seleniumEx.threadSafety;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverTest1 {
	WebDriver driver;
	
	@Test
	public void t1() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
	
	@Test
	public void t2() {
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println(driver.getTitle());
		
		driver.quit();
	}
}
