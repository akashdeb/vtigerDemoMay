package vtiger.genericUtility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.mysql.cj.jdbc.Driver;

import vitiger.POMRepository.HomePage;
import vitiger.POMRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtils=new FileUtility();
	public WebDriverUtility wUtils = new WebDriverUtility();
	public ExcelUtility eUtils = new ExcelUtility();
	public static WebDriver sDriver;
	public Connection connection;
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger", "root", "root");
		System.out.println("The data base connection was established");
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
		sDriver = driver;
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
	public void asConfig() throws SQLException {
		
		connection.close();
		System.out.println("The data base connection was closed");
	}

}
