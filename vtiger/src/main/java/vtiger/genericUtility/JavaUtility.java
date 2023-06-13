package vtiger.genericUtility;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
/**
 * This Class has all the java related generic methods
 * @author Akash
 *
 */
public class JavaUtility {
	/**
	 * This method returns a random number depending on the user input
	 * @param limit
	 * @return
	 */
	public int generateRandom(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
	/**
	 * This method generates system date and time
	 * @return
	 */
	public String generateSystemDateAndTime() {
		Date date = new Date();
		return date.toString().replace(" ", "_").replace(":", "_");
	}
	
	public String generateDateInYYYY_MM_DD_Format() {
		LocalDateTime date = LocalDateTime.now();
		int year = date.getYear();
		int month=date.getMonthValue();
		int day = date.getDayOfMonth();
		String newMonth = "";
		String newDay = "";
		if(month<10) {
			newMonth="0"+month;
			return year+"-"+newMonth+"-"+day;	
		}
		if(day<10) {
			newDay = "0"+day;
			return year+"-"+month+"-"+newDay;	
		}
		else
			return year+"-"+month+"-"+day;	


	}
	

}
