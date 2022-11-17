package org.atmecs.constant;

import java.io.File;

public class FilePathConstants {
	public final static String USER_HOME = System.getProperty("user.dir") + File.separator;

	public final static String RESOURCES_HOME = USER_HOME + "src" + File.separator + "main" + File.separator
			+ "resources" + File.separator;

	public final static String LOCATOR_HOME = RESOURCES_HOME + "locators" + File.separator;
	public final static String SWAGLABS = LOCATOR_HOME + "swaglabs" + File.separator;

	public final static String LIB_HOME = USER_HOME + "lib" + File.separator;

	public final static String SWAGLABSDEMO = SWAGLABS
			+ "swaglabsdemo.properties";
	public final static String TESTDATA_HOME = RESOURCES_HOME + "testdata" + File.separator;
	public final static String TESTDATA = TESTDATA_HOME
			+ "testdata.xlsx";
	
}
