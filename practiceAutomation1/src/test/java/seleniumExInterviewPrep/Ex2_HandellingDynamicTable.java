package seleniumExInterviewPrep;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Ex2_HandellingDynamicTable {
	@Test
	public void handlingDynamicTable(){
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://testautomationpractice.blogspot.com/");
		
		WebElement dynamicTable = driver.findElement(By.id("taskTable"));
		
		// Target is to get CPU % for chrome from dynamic table
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicTable);
		
		// Adding explicit wait to wait for dynamic table to load
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@Id='taskTable']")) );
		
		// Getting All rows
		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@Id='taskTable']//tbody//tr"));
		// Looking for each row having Chrome column
		for(int r = 0; r < tableRows.size(); r++)
		{
			// Indexing for locator starts from 1
			WebElement nameElement = driver.findElement(By.xpath("//table[@Id='taskTable']//tbody//tr["+ (r+1) +"]/td[1]"));
			boolean isChromeRow = nameElement.getText().equals("Chrome");
			if(isChromeRow)
			{
				// Getting CPU Percentage value for ChromeColumn
				String cpuPercentage = driver.findElement(By.xpath("//td[normalize-space()= 'Chrome']//following-sibling::*[contains(text(),'%')]")).getText();
				System.out.println("Chrome CPU percentage is: "+ cpuPercentage);
				break;
			}
		}
		
//		driver.close();
	}
	
	@Test
	public void checkSelectOptionsAreSorted()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Scrolling to option
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("label[for='animals']")));
		
		// Creating a list to store values
		List<String> originalValues = new ArrayList<String>();
		
		Select options = new Select(driver.findElement(By.cssSelector("select#animals")));
		for(WebElement option: options.getOptions())
		{
			originalValues.add(option.getText().trim());
		}
		
		// Creating a copy of original Link
		List<String> tempValues = new ArrayList<>(originalValues);
		Collections.sort(tempValues);
		
		if(originalValues.equals(tempValues))
		{
			System.out.println("List is sorted");
		}
		else {
			System.out.println("List is unsorted");
		}
		
		driver.quit();
	}
	
	@Test
	public void checkSelectOptionsAreSorted1()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Scrolling to option
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("label[for='colors']")));
		
		// Creating a list to store values
		List<String> originalValues = new ArrayList<String>();
	
	}
	
}
