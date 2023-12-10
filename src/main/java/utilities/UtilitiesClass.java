package utilities;

import java.util.Date;

public class UtilitiesClass {
		
	public static String genrateTimeStamp() {
		Date date= new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}

}
