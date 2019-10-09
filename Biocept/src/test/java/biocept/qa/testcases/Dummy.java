package biocept.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import biocept.qa.base.BioceptBase;

public class Dummy extends BioceptBase {
	@Test
	public void f() {
		System.out.println("Testing");
		Assert.assertEquals(true, true);
	}
}
