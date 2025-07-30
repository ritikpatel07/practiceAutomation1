package assertionsEx;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsDemo {
	
	@Test
	public void hardAssertionsM1()
	{
		System.out.println("Statement 1");
		System.out.println("Statement 2");
		
		Assert.assertEquals(11, 12); // Hard Assertions
		
		System.out.println("Statement 3"); // This statement won't execute
	}
	
	@Test
	public void softAssertionsM1() 
	{
		System.out.println("Statement 1");
		System.out.println("Statement 2");
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(11, 12); // Soft Assertions
		sa.assertTrue(false);
		
		System.out.println("Statement 3 "); // This statement will still execute
		
		sa.assertAll(); // Mandatory to be used to update the Status of method as PASSED/ FAILED
	}
}
