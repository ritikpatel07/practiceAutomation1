package seleniumExInterviewPrep;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ex11_WaitsInSelenium {
	
	public void waits() {
		 WebDriver driver = new ChromeDriver();

		 /// Implicitly wait
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		 /// Explicit wait - Declaration
		 Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 // Applying wait
		 wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(""))));

		 // Fluent waits - Declaration
		 Wait<WebDriver> fwait = new FluentWait<>(driver)
		 .withTimeout(Duration.ofSeconds(10))
		 .pollingEvery(Duration.ofMillis(200))
		 .ignoreAll(List.of(NoSuchElementException.class, ElementNotInteractableException.class));
		 // Applying fluent wait on a webelement to be displayed
		 WebElement element1 = fwait.until(new Function<WebDriver, WebElement>() {
		 public WebElement apply(WebDriver d) {
		 return d.findElement(By.id(""));
		 }
		 });
		 // Applying fluent wait- converting above statement to Lambda Expression
		 WebElement element = fwait.until(driver1 -> driver1.findElement(By.id("foo")));
		 }
}
