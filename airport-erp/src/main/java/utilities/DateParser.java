package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
	private static SimpleDateFormat dateFormat;

	public static Date convertStringToDate(String dateToBeConverted) {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = dateFormat.parse(dateToBeConverted);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
