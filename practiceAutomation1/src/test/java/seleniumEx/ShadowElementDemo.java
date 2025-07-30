package seleniumEx;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/*
 * Shadow element can't be located directly.
 * First locate the ShadowHost by cssSelector
 * Then locate the ShadowRoot by cssSelector
 * Then locate the ShadowElement by cssSelector
 * */
public class ShadowElementDemo {

	@Test
	public void shadowElement() throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver","Path to the driver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Load the website
		driver.get("https://books-pwakit.appspot.com/");

		// Locating shadowRoot with the help of Host
		SearchContext shadowRoot = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(2000);

		// Locating shadowElement with the help of Shadow Element
		shadowRoot.findElement(By.cssSelector("#input")).sendKeys("Welcome!");

		driver.close();
	}

}
