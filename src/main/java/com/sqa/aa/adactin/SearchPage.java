/**
 *   File Name: SearchPage.java<br>
 *
 *   LastName, FirstName<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: May 2, 2016
 *
 */

package com.sqa.aa.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import com.sqa.aa.util.helpers.*;

/**
 * SearchPage //ADDD (description of class)
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
public class SearchPage extends DefaultPage {

	@FindBy(id = "adult_room")
	private WebElement adultsPerRoom;

	@FindBy(id = "datepick_in")
	private WebElement checkIn;

	@FindBy(id = "datepick_out")
	private WebElement checkOut;

	@FindBy(id = "child_room")
	private WebElement childPerRoom;

	@FindBy(id = "checkout_span")
	private WebElement errorMEsCheckOut;

	@FindBy(id = "checkin_span")
	private WebElement errorMesChekIn;

	@FindBy(id = "hotels")
	private WebElement hotels;

	@FindBy(id = "location")
	private WebElement location;

	@FindBy(id = "login")
	private WebElement loginBtn;

	@FindBy(id = "room_nos")
	private WebElement numOfRooms;

	@FindBy(id = "password")
	private WebElement password;

	@FindBy(id = "Reset")
	private WebElement resetBtn;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(id = "Submit")
	private WebElement submitBtn;

	@FindBy(id = "username_show")
	private WebElement successLogin;

	@FindBy(id = "username")
	private WebElement username;

	public SearchPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(getDriver(), this);
	}

	public SearchPage chooseHotel(String hotelChooice) {
		Select selectHotels = new Select(this.hotels);
		selectHotels.selectByValue(hotelChooice);
		return this;
	}

	public SearchPage chooseLocation(String locationChooice) {
		Select selectLocation = new Select(this.location);
		selectLocation.selectByValue(locationChooice);
		return this;

	}

	public SearchPage choosenumOfRooms(String numRooms) {
		Select selectnumRooms = new Select(this.numOfRooms);
		selectnumRooms.selectByValue(numRooms);
		return this;
	}

	public SearchPage chooseroomType(String roomType) {
		Select selectRoomType = new Select(this.roomType);
		selectRoomType.selectByValue(roomType);
		return this;

	}

	public boolean hasWelcomeMsg() {
		// return AutoBasics.isElementPresent(driver,
		// By.cssSelector("td.welcome_menu"));
		try {
			AutoBasics.isElementPresent(getDriver(), By.cssSelector("td.welcome_menu"));
			return AutoBasics.isElementPresent(By.cssSelector("td.welcome_menu"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getLogger().warn(e.getMessage() + getClass().getEnclosingMethod());
			return false;
		}
	}

}
