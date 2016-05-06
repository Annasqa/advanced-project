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

import java.text.*;

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
public class TC102 {
	private static WebDriver driver;

	@DataProvider
	public static Object[][] tc102data() {
		return new Object[][] {
				{ "kathytest", "t3stmail", "Sydney", "Hotel Creek", "Standard", "1", "01/06/2016", "4", "2", true },
				{ "kathytest", "t3stmail", "Paris", "Hotel Creek", "Deluxe", "9", "02/06/2018", "2", "4", true } };
	}

	public SearchPage searchPage;

	String baseURL = "http://adactin.com/HotelAppBuild2";

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get(this.baseURL);
	}

	@Test(dataProvider = "tc102data")
	public void testCheckInOut(String username, String password, String location, String hotel, String roomType,
			String numRooms, String checkIn, String adultsInRoom, String childrenInRoom, boolean expectedResults)
					throws ParseException {
		boolean actualResults;
		System.out.println("TC-102");
		// Eval CeckOut Date:
		String checkOut = DefaultPage.changeDate(checkIn, 7);
		System.out.println("Check-in: " + checkIn + "Check-out: " + checkOut);

		// Login
		if (this.searchPage == null) {
			this.searchPage = new LoginPage(driver).enterUsername(username).enterPassword(password).login();

		} else {
			this.searchPage.getDriver().get(DefaultPage.getBaseURL() + "/SearchHotel.php");
		}

		System.out.println("Enter Information: ");
		this.searchPage.chooseLocation(location).chooseHotel(hotel).chooseroomType(roomType).choosenumOfRooms(numRooms)
				.chooseCheckInDate(checkIn).chooseCheckOutDate(checkOut).chooseNumAdultsInRoom(adultsInRoom)
				.chooseNumChildrenInRoom(childrenInRoom)
				// submit
				.submit();
		// checkout if actual is same as expected results
		actualResults = !this.searchPage.hasCheckInErrorMessage();
		Assert.assertEquals(actualResults, expectedResults);
	}

}
