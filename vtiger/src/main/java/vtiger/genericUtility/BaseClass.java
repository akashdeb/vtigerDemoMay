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

import vitiger.POMRepository.HomePage;
import vitiger.POMRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtils=new FileUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	
	@BeforeSuite
	public void bsConfig() {
		
		
	}
	
	@BeforeClass
	public void bcConfig() throws IOException {
		
		String url = fUtils.toFetchDataFromPropertyFile(IPathConstant.URL_KEY);
		
		driver= new ChromeDriver();
		System.out.println("The browser has been launched");
		wUtils.maximizeTheWebPage(driver);
		wUtils.implicitWait(driver);
		driver.get(url);
		System.out.println("The URL has been navigated");
	}
	
	
	@BeforeMethod
	public void bmConfig() throws IOException {
		
		String username = fUtils.toFetchDataFromPropertyFile(IPathConstant.USERNAME_KEY);
		String password = fUtils.toFetchDataFromPropertyFile(IPathConstant.PASSWORD_KEY);
		
		LoginPage login=new LoginPage(driver);
		login.loginAction(username, password);
		System.out.println("The "+username+" has logged in");
		
	}
	
	
	@AfterMethod
	public void amConfig() throws IOException {
		String username = fUtils.toFetchDataFromPropertyFile(IPathConstant.USERNAME_KEY);
		HomePage home = new HomePage(driver);
		home.logoutAction();
		System.out.println("The "+username+" has logged out");
		
	}
	
	@AfterClass
	public void acConfig() {
		
		driver.quit();
		System.out.println("The Browser has been closed");
		
	}
	
	@AfterSuite
	public void asConfig() {
		
		
	}

}
