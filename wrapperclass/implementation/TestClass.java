package com.wrapperclass.implementation;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;



public class TestClass {
	Driver driver;

	@Before
	public void setUp() {
		driver = new Driver("CHROME");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test1() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.open();
		ResultsPage results = home.searchFor("oracle");
		Assert.assertTrue(results.itemsCountText().length() > 0);
		Assert.assertTrue(results.titleText().length() > 0);
	}
}
