package com.sqa.aa.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.*;
import org.testng.annotations.*;

public class LoginTest {
	// creating baseURL variable and giving the value (current app's site)
	private static String baseURL = "http://adactin.com/HotelAppBuild2";
	// creating driver var to identify on which browser(s) test will run
	private static WebDriver driver;

	@BeforeClass
	//
	public static void setupFirefox() throws InterruptedException {
		// giving value Firefox to driver variable
		driver = new FirefoxDriver();
		// getting the actual URL
		driver.get(baseURL);

	}

	@Test
	public void testLogin() throws InterruptedException {
		logInToWebsite();

		boolean msgElementPresent;
		msgElementPresent = isElementPresent(By.id("username_show"));
		Assert.assertTrue(msgElementPresent, "No welcome message present");
		System.out.println("Passed login test!");

		// Assert.assertTrue(isElementPresent(By.id("username_show")), "No
		// welcome message present");
	}

	private boolean isElementPresent(By by) {
		try {
			this.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 *
	 */
	private void logInToWebsite() {
		WebElement username;
		WebElement password;
		username = driver.findElement(By.id("username"));
		password = driver.findElement(By.id("password"));
		username.sendKeys("kathytest");
		password.sendKeys("t3stmail");
		driver.findElement(By.id("login")).click();
	}

}
