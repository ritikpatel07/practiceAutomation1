package seleniumEx;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Ex3_DetectBrokenLinks {
	
	@Test
	public void detectBrokenLinksOnPage()
	{
		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://testautomationpractice.blogspot.com/";
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		List<WebElement> links = driver.findElements(By.cssSelector("a"));
		System.out.println("Total links found on the page: "+ links.size());
		
		for(WebElement link: links)
		{			
			String linkUrl = link.getDomAttribute("href");
			
			if( (linkUrl == null) || (linkUrl.isEmpty() || linkUrl.equals("#"))) {
				System.out.println("Url is either null or empty or doesn't have any reference!");
				continue;
			}
			else if(!linkUrl.startsWith("http")) // /users
				linkUrl = baseUrl + linkUrl;
			
			verifyLink(linkUrl);
		}
		
		driver.quit();
	}
	
	@Test
	public void clickingOnUniqueLinks() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("");
		
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		Set<String> uniqueLinks = new HashSet<String>();
		
		for(WebElement element: elements) {
			String href = element.getDomAttribute("href");
			if(!uniqueLinks.contains(href))
				uniqueLinks.add(href);
		}
		
		for(String url: uniqueLinks) {
			driver.navigate().to(url);
			System.out.println("Visited: "+url +" | "+driver.getCurrentUrl());
			
			Thread.sleep(2000);
			
			driver.navigate().back();
		}
		
	}
	
	public void verifyLink(String link)
	{
		URI uri = null;
		try {
			uri = new URI(link);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} 
		
		try {
			HttpURLConnection httpConn = (HttpURLConnection) uri.toURL().openConnection();
			httpConn.setConnectTimeout(3000);
			httpConn.connect();
			
			if(httpConn.getResponseCode() >= 400)
			{
				System.out.println("Invalid url: "+ uri);
			}
			else
			{
				System.out.println("Valid url: "+ uri);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
