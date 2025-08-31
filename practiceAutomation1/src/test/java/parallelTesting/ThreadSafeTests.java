package parallelTesting;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSafeTests {
	protected WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		DriverManager.setDriver(driver);
	}
	
	@AfterMethod
	public void cleanup() {
		DriverManager.getDriver().quit();
		DriverManager.removeDriver();
	}
	
	 @Test
	 public void test1(Method method) throws InterruptedException {
	 DriverManager.getDriver().get("https://www.google.com/");

	 System.out.println(method.getName()+": "+DriverManager.getDriver().getTitle());
	 Thread.sleep(2000);
	 Assert.assertEquals(DriverManager.getDriver().getTitle(), "Google");
	 }

	 @Test
	 public void test2(){
	 DriverManager.getDriver().get("https://testautomationpractice.blogspot.com/");

	 System.out.println("test2: " +DriverManager.getDriver().getTitle());
	 Assert.assertEquals(DriverManager.getDriver().getTitle(), "Automation Testing Practice");
	 }

	 @Test
	 public void test3(){
	 DriverManager.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

	 System.out.println("test3: "+DriverManager.getDriver().getCurrentUrl());
	 Assert.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("naveenautomationlabs"));
	 }
}
