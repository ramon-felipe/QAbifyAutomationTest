package helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	public static String getDate(String pattern) {
		SimpleDateFormat formatter = null;  
		Date date = new Date();

		try {
			formatter = new SimpleDateFormat(pattern);  
		} catch (Exception e) {
			System.out.println("Error defining date format");
		}
		
		return formatter.format(date);
	}
}
