/**
 *   File Name: DefaultPage.java<br>
 *
 *   LastName, FirstName<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: May 2, 2016
 *
 */

package com.sqa.aa.adactin;

import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.support.*;

/**
 * DefaultPage //ADDD (description of class)
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
public class DefaultPage extends PageFactory {
	private static String baseURL;

	private static WebDriver driver;

	/**
	 * @return the baseURL
	 */
	public static String getBaseURL() {
		return baseURL;
	}

	/**
	 * @param baseURL
	 *            the baseURL to set
	 */
	public static void setBaseURL(String baseURL) {
		DefaultPage.baseURL = baseURL;
	}

	private Logger logger;

	public DefaultPage() {
		try {
			setDriver();
		} catch (DriverAlreadyInitializedException e) {
			getLogger().warn(
					"Driver may have been initialized already, does not need reinitilaization from Core Constructor.");
		}
		PageFactory.initElements(getDriver(), this);
	}

	public DefaultPage(WebDriver driver) {
		setDriver(driver);
		PageFactory.initElements(getDriver(), this);
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		if (DefaultPage.driver == null) {
			try {
				throw new DriverNotInitializedException();
			} catch (DriverNotInitializedException e) {
				getLogger().warn("Driver was not initialized, setting Firefox as default WebDriver");
				DefaultPage.driver = new FirefoxDriver();
			}
		}
		return DefaultPage.driver;
	}

	public Logger getLogger() {
		if (this.logger == null) {
			this.logger = this.logger.getLogger(this.getClass());
		}
		return this.logger;
	}

	public void setDriver() throws DriverAlreadyInitializedException {
		if (DefaultPage.driver == null) {
			DefaultPage.driver = new FirefoxDriver();
			getLogger().warn("Using default Firefox Driver implementation");
		} else {
			throw new DriverAlreadyInitializedException();
		}
	}

	/**
	 * @param driver
	 *            the driver to set
	 */
	public void setDriver(WebDriver driver) {
		getLogger().info("Driver is init in LoginPage");
		if (DefaultPage.driver == null) {
			DefaultPage.driver = driver;
		}
	}

}
