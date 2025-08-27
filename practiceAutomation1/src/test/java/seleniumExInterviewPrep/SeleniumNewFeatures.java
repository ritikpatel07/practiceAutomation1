package seleniumExInterviewPrep;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

/*
 * Demonstration of Selenium 4 Features
 * */
public class SeleniumNewFeatures {

	@Test(description = "Testing Relative locator strategy in Selenium 4")
	public void relativeLocatorsTest()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.browserstack.com/guide/relative-locators-in-selenium");
		driver.manage().window().maximize();
		
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // --> Deprecated from Selenium 4
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // --> New -Selenium 4

		WebElement SecondaryBtn = driver.findElement(RelativeLocator.with(By.className("btn btn-primary open-csf-form btn-lg col-md-3 vwo-hide guide-rh-demo-cta")).toRightOf(By.tagName("button")));
		
		System.out.println(SecondaryBtn.getText());
	}
	
	@Test
	public void takeScreenShot() throws IOException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		// 1. Taking Screenshot of a page Existing Feature from Selenium 3
//		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File("./Screeshot/Homepage.png"));
		
		// 2. Taking Screenshot of a WebElement -- Selenium 4
		WebElement logo = driver.findElement(By.cssSelector("img[alt='nopCommerce demo store']"));
		highlight(logo, driver);
		File src1 = logo.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("./Screenshot/logo.png"));
		
		driver.quit();
	}
	
	public void highlight(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='2px solid red'", element);
	}
}
