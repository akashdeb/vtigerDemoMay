package vtiger.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	public WebDriver driver;
	FileUtility fUtils=new FileUtility();
	WebDriverUtility wUtils = new WebDriverUtility();

	@BeforeSuite
	public void bsConfig() {
		
		
	}
	
	@BeforeClass
	public void bcConfig() throws IOException {
		
		String url = fUtils.toFetchDataFromPropertyFile(IPathConstant.URL_KEY);
		String username = fUtils.toFetchDataFromPropertyFile(IPathConstant.USERNAME_KEY);
		String password = fUtils.toFetchDataFromPropertyFile(IPathConstant.PASSWORD_KEY);

		driver= new ChromeDriver();
		System.out.println("The browser has been launched");
		wUtils.maximizeTheWebPage(driver);
		wUtils.implicitWait(driver);
		driver.get(url);
		System.out.println("The URL has been navigated");
	}
	
	
	@BeforeMethod
	public void bmConfig() {
		
		
		
	}
	
	
	@AfterMethod
	public void amConfig() {
		
		
	}
	
	@AfterClass
	public void acConfig() {
		
		
	}
	
	@AfterSuite
	public void asConfig() {
		
		
	}

}
