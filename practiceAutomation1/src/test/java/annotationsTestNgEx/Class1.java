package annotationsTestNgEx;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
 *  BeforeSuite             				AfterSuite
 *   	BeforeTest						AfterTest
 *   		BeforeClass				AfterClass
 *   			BeforeMethod	AfterMethod
 *  					   	Test
 * */

public class Class1 {
	@BeforeMethod
	public void bmM1()
	{
		System.out.println("Before Method --- >");
	}
	
	@AfterMethod
	public void amM1()
	{
		System.out.println("After Method --- >");
	}
	
	@AfterClass
	public void acM1()
	{
		System.out.println("<---- After Class --- >");
	}
	
	@BeforeClass
	public void bcM1()
	{
		System.out.println("<---- Before Class --- >");
	}
	
	@Test(priority = -1)
	public void loginTest()
	{
		System.out.println("Login.....");
	}
	
	@Test
	public void searchTestM1()
	{
		System.out.println("Search....");
	}
	
	@Test
	public void printTestM2()
	{
		System.out.println("Print....");
	}
	
	@Test(priority = 1)
	public void logoutTest()
	{
		System.out.println("Logout....");
	}
}
