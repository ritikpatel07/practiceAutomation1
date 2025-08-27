package seleniumExInterviewPrep;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Ex10DemoQA_ParallelDPDemo {
	
	@Test(dataProvider = "userData")
	public void test1(String eml, String pwd) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/login");
		
		WebElement email = driver.findElement(By.id("Email"));
		WebElement password = driver.findElement(By.id("Password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));

		email.sendKeys(eml);
		password.sendKeys(pwd);
		loginBtn.click();
		
		boolean status = false;
		try {
			status = driver.findElement(By.linkText("Log out")).isDisplayed();
		}
		catch (NoSuchElementException e) {
			Assert.assertTrue(status);
		}
		finally {
			driver.quit();
		}
		
	}
	
	// Concept 1. Let's say I want to run parallel however at a time only two data set should be considered
	// -> marke Parallel = true & Created testNG.xml> at the suite level add data provider thread count = "2"
	// -> Now when you trigger it using testNg.xml then at most 2 dataset will be picked for parallel execution
	
	// 2.With the help of indices, we can specify (Index 0 based) which test data to be considered from given set
	@DataProvider(name= "userData", parallel = true, indices = {0,2,4})
	public String[][] dataProvider(){
		return new String[][] {
			{"lgray@example.com", "test123"},
			{"tray@example.com", "test123"},
			{"lgray@example.com", "test123"},
			{"test@example.com", "test123"},
			{"asdf@example.com", "test123"},
			{"invalid@example.com", "test123"},
		};
	}
	
}
