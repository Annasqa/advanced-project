/**
 *   File Name: DriverAlreadyInitializedException.java<br>
 *
 *   LastName, FirstName<br>
 *   Java Boot Camp Exercise<br>
 *   Instructor: Jean-francois Nepton<br>
 *   Created: May 4, 2016
 *
 */

package com.sqa.aa.adactin;

/**
 * DriverAlreadyInitializedException //ADDD (description of class)
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
public class DriverAlreadyInitializedException extends Exception {
	@Override
	public String getMessage() {
		this.getClass().getEnclosingMethod();
		return "AutoBasics may have not been initialized, first initialize it before running the method which requires driver to be initialized";

	}
}
