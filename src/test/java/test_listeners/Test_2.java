package test_listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_2 {

	@Test
	public void assertMethod() {

		System.out.println("Actual Test");
		Assert.assertTrue(true);

	}
	
	
	@Test
	public void assertMethod2() {

		System.out.println("Actual Test");
		Assert.assertTrue(false);
	
	}
}
