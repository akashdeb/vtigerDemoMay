package vtiger.genericUtility;

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
	
	
	

}
