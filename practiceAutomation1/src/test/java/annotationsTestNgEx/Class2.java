package annotationsTestNgEx;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class2 {

//	@Test
//	public void writeTestM2()
//	{
//		System.out.println("Write....");
//	}
//	
	@BeforeTest
	public void btM1() {
		System.out.println(">>--- Before Test ----<<");
	}

	@AfterTest
	public void afM1() {
		System.out.println(">>--- After Test ----<<");
	}

	@BeforeSuite
	public void bsM1() {
		System.out.println("<<>>---- Before Suite <<>>----");
	}

	@AfterSuite
	public void asM1() {
		System.out.println("<<>>---- After Suite <<>>----");
	}
}
