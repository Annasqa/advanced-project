/**
 *   File Name: TC105.java<br>
 *
 *   LastName, FirstName<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: May 2, 2016
 *
 */

package com.sqa.aa.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.*;
import org.testng.annotations.*;

/**
 * TC105 //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author LastName, FirstName
 * @version 1.0.0
 * @since 1.0
 *
 */
public class TC101 {
	private static WebDriver driver;
	String baseURL = "http://adactin.com/HotelAppBuild2";

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(this.baseURL);
	}

	@Test
	public void testLogin() {

		// LoginPage loginPage = new LoginPage(this.driver);
		// loginPage.enterUsername("kathytest").enterPassword("t3stmail").login();
		// Assert.assertTrue(loginPage.hasWelcomeMsg());

		// the short method - instead of three lines above it can be combined
		// into one
		Assert.assertTrue(new LoginPage(this.driver).enterUsername("kathytest").enterPassword("t3stmail").login()
				.hasWelcomeMsg());

	}

}
