package testngEx;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/*
 * Helper attributes in TestNG
 * */

public class Class2 {
	
	@Parameters("browser")
	@Test
	public void test(@Optional("edge") String browser) // This will trigger on edge by default if parameter is not provided
	{
		System.out.println(browser);
	}
	
	@Test(dependsOnMethods = {"secondMethod"}, invocationCount = 2) // Running this method will invoke this method 2 times post executing dependent methods
	public void firstMethod()
	{
		System.out.println("Class2 -> First Method");
	}
	
	@Test(groups = {"smoke"})
	public void secondMethod()
	{
		System.out.println("Class2 -> Second Method");
	}
	
	@Test(groups = {"smoke", "sanity", "regression"})
	public void thirdMethod()
	{
		System.out.println("Class2 -> Third Method");
	}
}
