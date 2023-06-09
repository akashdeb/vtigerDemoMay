package vtiger.genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListenersImplementationClass implements ITestListener {

	
	public void onTestFailure(ITestResult result) {
		String testCaseName = result.getMethod().getMethodName();
		
		JavaUtility jUtils = new JavaUtility();
		String sysDate = jUtils.generateSystemDateAndTime();
		
		TakesScreenshot ts = (TakesScreenshot)BaseClass.sDriver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/"+testCaseName+sysDate+".png");
		try {
			Files.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
	

}
