/**
 *   File Name: BasicAutoTest.java<br>
 *
 *   LastName, FirstName<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: Apr 20, 2016
 *
 */

package com.sqa.aa;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.opera.*;
import org.openqa.selenium.safari.*;
import org.testng.annotations.*;

/**
 * BasicAutoTest //ADDD (description of class)
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
public class BasicAutoTest {
	static WebDriver driver;

	@DataProvider(name = "UserAccountInfo")
	public static Object[][] getData() {
		Object[][] data = { { "leotest140@gmail.com", "t3stmail" }, { "melisatest140@gmaail.com", "t3stmail" },
				{ "jons.tutor@gmail.com", "t3stmail" }

		};
		return data;

	}

	@BeforeClass(enabled = false, groups = "chrome")
	public static void setupChrome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);

	}

	@BeforeClass(enabled = false, groups = "firefox")
	public static void setupFirefox() throws InterruptedException {
		driver = new FirefoxDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);

	}

	@BeforeClass(enabled = true, groups = "opera")
	public static void setupOpera() throws InterruptedException {
		System.setProperty("webdriver.opera.driver", "drivers/operadriver");
		driver = new OperaDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);

	}

	@BeforeClass(enabled = false, groups = "safari")
	public static void setupSafari() throws InterruptedException {
		driver = new SafariDriver();
		driver.get("http://gmail.com");
		Thread.sleep(1000);

	}

	@Test(dataProvider = "UserAccountInfo")
	public void test(String username, String password) throws InterruptedException {
		System.out.println("Basic Test: U-" + username + "/P-" + password);

	}
}
