package parallelTesting;

import org.openqa.selenium.WebDriver;

public class DriverManager {
	private static final ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return tDriver.get();
	}
	
	public static void setDriver(WebDriver driver) {
		tDriver.set(driver);
	}
	
	public static void removeDriver() {
		tDriver.remove();
	}

}
