package seleniumEx;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WindowHandlesDemo {

	@Test(groups = { "regression" })
	public void workflowWindoHandle() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver","Path to the driver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load the Homepage
		driver.get("http://www.naukri.com/");

		// Waiting for page to load completely
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("Complete");
		
		// Locating Some links on page
		WebElement companiesNavBarLink = driver.findElement(By.xpath("//div[text()='Companies']/parent::a"));
		WebElement servicesNavBarLink = driver.findElement(By.xpath("//div[text()='Services']/parent::a"));
		
		// Way 1. Opening them in new tabs Using Ctrl + click
		new Actions(driver).keyDown(Keys.CONTROL).click(companiesNavBarLink).click(servicesNavBarLink).keyUp(Keys.CONTROL).build().perform();
		
		// Way 2. Opening using JS executor
//		String href1 = companiesNavBarLink.getAttribute("href");
//		String href2 = servicesNavBarLink.getAttribute("href");
//		((JavascriptExecutor)driver).executeScript("window.open(arguments[0]), '_blank'", href1);
//		((JavascriptExecutor)driver).executeScript("window.open(arguments[0]), '_blank'", href2);
		
		// It will return the parent window hash as a String
		String parent = driver.getWindowHandle();
		System.out.println("Parent Tab- "+driver.getTitle());

		// Getting all the tabs opened
		Set<String> s = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> itr = s.iterator();
		while (itr.hasNext()) {
			String child_window = itr.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				Thread.sleep(2000);
				driver.close(); // This will close the current window
			}
		}
		
		// Switching back to parent window
		driver.switchTo().window(parent);
		System.out.println("Parent Tab- "+driver.getTitle());
		
		// This will open a new BLANK tab
//		driver.switchTo().newWindow(WindowType.TAB);
		
		// This will open a new WINDOW
//		driver.switchTo().newWindow(WindowType.WINDOW);

		// Quitting driver
		driver.quit();
	}

	@Test
	public void workingWithMultipleTabs() {
		// Set up WebDriver
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Open the first URL in the main tab
		driver.get("https://www.google.com");
		System.out.println("First Tab Title: " + driver.getTitle());

		// Open a new tab
		driver.switchTo().newWindow(WindowType.TAB );
//		driver.switchTo().newWindow(WindowType.WINDOW); //-> Opens a new Window

		// Navigate to another URL in the new tab
		driver.get("https://www.bing.com");
		System.out.println("Second Tab Title: " + driver.getTitle());

		// Get all window handles
		String firstTabHandle = driver.getWindowHandles().toArray()[0].toString();
		String secondTabHandle = driver.getWindowHandles().toArray()[1].toString();
		
		// Control is on Second window
		System.out.println("Switched back to First Tab: " + driver.getTitle());
		driver.close(); // Closing the second tab

		// Switch back to the first tab
		driver.switchTo().window(firstTabHandle);
		System.out.println("Switched back to First Tab: " + driver.getTitle());

		// Close all tabs
		driver.quit();
	}

	@Test
	public void getMethodOfWebdriver()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Step 1: Open first URL using get()
        driver.get("https://www.google.com");
        System.out.println("Opened: " + driver.getTitle());

        // Step 2: Open second URL using get()
        driver.get("https://www.wikipedia.org");
        System.out.println("Opened: " + driver.getTitle());

        // Step 3: Try navigating back
        driver.navigate().back();

        // Wait for a second to load
        try { Thread.sleep(2000);} catch(InterruptedException e){}

        // Step 4: Print title again
        System.out.println("After back(): " + driver.getTitle()); // May or may not return Google which is first tab
	}
	
	@Test
	public void navigateToMethodOfNavigation()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Step 1: Open first URL using navigate().to()
        driver.navigate().to("https://www.google.com");
        System.out.println("Opened: " + driver.getTitle());

        // Step 2: Open second URL using navigate().to()
        driver.navigate().to("https://www.wikipedia.org");
        System.out.println("Opened: " + driver.getTitle());

        // Step 3: Try navigating back
        driver.navigate().back();
        // Wait for a second to load
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        // Step 4: Print title again
        System.out.println("After back(): " + driver.getTitle()); // Google
        
        driver.navigate().forward();
        // Wait for a second to load
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        // Step 4: Print title again
        System.out.println("After forward(): " + driver.getTitle()); // Wikipedia
        
        driver.navigate().refresh();
        // Step 4: Print title again
        System.out.println("After refresh(): " + driver.getTitle()); // Wikipedia
		
	}
}