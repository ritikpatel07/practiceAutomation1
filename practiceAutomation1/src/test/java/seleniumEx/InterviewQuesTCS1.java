package seleniumEx;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class InterviewQuesTCS1 {

	public static void main(String[] args) {
//		WebDriver driver1 = new ChromeDriver();
//		WebDriver driver2 = new ChromeDriver();
//		WebDriver driver3 = new ChromeDriver();

//		driver1.get("https://www.google.com/");
//		driver3.get("https://the-internet.herokuapp.com/");
//		driver2.get("https://demo.nopcommerce.com/");

		try {
			int a = 10 / 0;
//			throw new ArithmeticException("Throwing RTE");
//			System.out.println("Try block");
//			System.exit(0);
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally block");
		}

//		driver2.close();
//		driver2.quit();
	}
}
