package utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtility {

	
	public static String getCurrentDate(String Format) {
		String Date = null;
		try {
			// "MM/dd/yy"
			DateFormat dateFormat = new SimpleDateFormat(Format);
			Calendar cal = Calendar.getInstance();
			Date = dateFormat.format(cal.getTime());
		} catch (Exception e) {
			Date = null;
		}
		return Date;
	}

	public static String getDate(String Format,int noOfDays) {
		String Date = null;
		try {
			// "MM/dd/yy"
			DateFormat dateFormat = new SimpleDateFormat(Format);
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, noOfDays);
			Date = dateFormat.format(cal.getTime());
			
		} catch (Exception e) {
			Date = null;
		}
		return Date;
	}
}
