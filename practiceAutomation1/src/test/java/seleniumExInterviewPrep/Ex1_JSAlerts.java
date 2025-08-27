package seleniumExInterviewPrep;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TimesPanel;

import dev.failsafe.internal.util.Durations;

/**
 * This has- 
 * 1. JavaScript Alerts - Handling in different way
 * 2. Actions Demo
 * 3. Screenshot Demo
 * 4. Browser Navigation back & forth 
 */
public class Ex1_JSAlerts {

	@Test
	public void typesOfBrowserAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.automationtesting.in/Alerts.html");

		// 1. Alert with OK button
//		driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
//		Thread.sleep(2000);
//		driver.switchTo().alert().accept();

		// 2. Alert with OK and Cancel button
//		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click(); // Clicking on 'Alert and Ok' link
//		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click(); // // Clicking on Alert btn to generate alert
//		Alert a = driver.switchTo().alert();
//		System.out.println("The msg on the alert is: "+ a.getText());
//		Thread.sleep(2000);
//		a.accept();
//		a.dismiss();

		// 3. Alert with a Prompt box & OK, Cancel button
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click(); // Click on 'Alert with TextBox' link
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click(); // Click on Alert btn to generate alert
		Thread.sleep(2000);
		Alert a = driver.switchTo().alert();
		System.out.println("The msg on the alert is: " + a.getText());
		a.sendKeys("Ritik Patel"); // by this way we can enter in the box
		Thread.sleep(3000);
//		a.accept();
		a.dismiss();

//		driver.close();

	}

	@Test
	public void handleAlertInDifferentWays() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement element = driver.findElement(By.id("alertBtn"));
		element.click();

		// 1. Using switchTo().alert() - General Way to switch to Alert
		driver.switchTo().alert().accept();

		// 2. Using Explicit wait
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert a1 = wait.until(ExpectedConditions.alertIsPresent()); // Once alert is available it will return
//		a1.accept();
//		
		// 3. Using JavaScriptExecutor
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		Alert a2 = null;
//		try {
//			a2 = (Alert) js.executeScript("window.alert=function{};");
//		} catch(Exception e){
//			
//		}
//		if(a2 != null)
//			a2.accept();

//		driver.close();
	}

	@Test
	public void actionClassWorkflows() {
		String baseUrl = "http://www.facebook.com/";
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		WebElement txtUsername = driver.findElement(By.id("email"));

		boolean isVisible = new WebDriverWait(driver, Duration.ofSeconds(20)).until(d -> txtUsername.isDisplayed());

		/*
		 * // Fluent Waits- Wait<WebDriver> wait = new FluentWait<>(driver)
		 * .withTimeout(Duration.ofSeconds(10)) .pollingEvery(Duration.ofSeconds(2))
		 * .ignoring(Exception.class); 
		 * wait.until( d -> { txtUsername.isDisplayed();
		 * return true; });
		 */

		// Moving control on text field & entering hello by pressing SHIFT key
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder.moveToElement(txtUsername).click().keyDown(txtUsername, Keys.SHIFT)
				.sendKeys(txtUsername, "hello").keyUp(txtUsername, Keys.SHIFT) // releasing key press
				.doubleClick(txtUsername) // Selecting the text
				.contextClick() // right click
				.build();

		seriesOfActions.perform();
	}

	@Test
	public void screenShotOrangeHRMLogin() throws InterruptedException {
		String baseUrl = "https://opensource-demo.orangehrmlive.com";
		String userName = "Admin";
		String pwd = "admin123";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		driver.navigate().to(baseUrl);

		Thread.sleep(4000);

		WebElement userNameTextBox = driver.findElement(By.name("username"));
		WebElement pwdTextBox = driver.findElement(By.name("password"));
		WebElement submitBtn = driver.findElement(By.xpath("//button[@type='submit']"));

		// 1. Taking Screenshot of an full page
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshot/Page1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(2000);

		// 2. Taking Screenshot of an element only
		File src1 = userNameTextBox.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src1, new File("./Screenshot/element1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		new WebDriverWait(driver, Duration.ofSeconds(20))
				.until(ExpectedConditions.elementToBeClickable(userNameTextBox));

		Thread.sleep(3000);
		userNameTextBox.sendKeys(userName);
		Thread.sleep(2000);
		pwdTextBox.sendKeys(pwd);
		Thread.sleep(2000);
		submitBtn.click();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// ---> Login Flow using Actions
//		Actions builder = new Actions(driver);
//		builder
//			.moveToElement(userNameTextBox)
//			.click()
//			.sendKeys(userName)
//			.build()
//			.perform();
//		
//		builder
//			.moveToElement(pwdTextBox)      
//			.click()
//			.sendKeys(pwd)
//			.build()
//			.perform();
//		
//		builder.moveToElement(submitBtn).click().build().perform();

		driver.quit();

	}

	@Test
	public void navigationBackAndForthDemo() {
		// Browser Navigation-
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://google.com");

		Wait<WebDriver> fw = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(15))
				.pollingEvery(Duration.ofSeconds(1)).ignoring(Exception.class);
		fw.until(ExpectedConditions.titleContains("Google"));
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com");

		driver.navigate().back();

		driver.getCurrentUrl().contains("Google");
		
		driver.navigate().refresh();

		driver.quit();

	}
}
