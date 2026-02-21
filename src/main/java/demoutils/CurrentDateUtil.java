package demoutils;

import java.util.Date;

import org.testng.annotations.Test;

public class CurrentDateUtil {
//	@Test
	public static String getCurrentDate() {
		Date d = new Date();
		return d.toString().replace(":","_");
	}

}
