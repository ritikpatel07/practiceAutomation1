package testngEx;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
 * Grouping Testcases-
 * 1. Test Groups
 * 2. Exclusion Groups
 * 3. Meta Groups (Group of groups)
 * 4. Partial Groups
 * */

@Test(groups = {"allC1"})
public class Class1 {
	
	@Test(groups = {"sanity", "regression"})
	public void firstMethod()
	{
		System.out.println("Class1 -> First Method");
		
		Assert.assertEquals(true, true);
	}
	
	@Test(groups = {"sanity", "regression", "smoke"}, invocationCount = 2)
	public void secondMethod()
	{
		System.out.println("Reading from POM " +System.getProperty("env"));
		System.out.println("Class1 -> Second Method");
	}
	
	@Test
	public void thirdMethod()
	{
		System.out.println("Class1 -> Third Method");
	}
	
	@Test(groups = {"sanity", "regression"})
	public void fourthMethod()
	{
		System.out.println("Class1 -> Fourth Method");
	}
}
