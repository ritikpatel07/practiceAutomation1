package seleniumEx.threadSafety;

import org.openqa.selenium.WebDriver;

// This utlity can convert your instance to a thread safe version
public class DriverManager {
	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();
	
	public static void setDriver(WebDriver driver){
		tdriver.set(driver);
	}
	
	public static WebDriver getDriver() {
		return tdriver.get();
	}
	
	public static void quitDriver() {
		if(tdriver.get() != null) {
			tdriver.get().quit();
			tdriver.remove();
		}
	}
}
