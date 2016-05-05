/**
 *   File Name: LoginPage.java<br>
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

/**
 * LoginPage //ADDD (description of class)
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
public class LoginPage extends DefaultPage {

	@FindBy(id = "login")
	private WebElement loginBtn;
	@FindBy(id = "password")
	private WebElement passwordFld;
	@FindBy(id = "username")
	private WebElement usernameFld;

	@FindBy(how = How.CSS, using = "td.welcome_menu")
	private WebElement welvomeElement;

	public LoginPage(WebDriver driver) {
		setDriver(driver);
		// PageFactory.initElements(driver, this);
		// Can now call initElements directly because this class extends
		// DefaultPage which extends PageFactory
		initElements(driver, this);

	}

	public LoginPage enterPassword(String password) {
		this.passwordFld.sendKeys(password);
		return this;
	}

	public LoginPage enterUsername(String username) {
		this.usernameFld.sendKeys(username);
		return this;
	}

	public SearchPage login() {
		this.loginBtn.click();
		return new SearchPage();
	}

}