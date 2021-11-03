package demo.actiTime.GenericUnits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import actiTime.POM.HomePage;
import actiTime.POM.LoginPage;

public class BaseClass 
{
	WebDriver driver = null;
	PropertyUtils pUtils = new PropertyUtils();
	
	@BeforeSuite
	public void configBS()
	{
		//database connection
	}
	
	@BeforeTest
	public void configBT()
	{
		//parallel testing codes
	}
	
	@BeforeClass
	public void configBC()
	{
		//open the browser
		String browserName = pUtils.getPropertyData("./src/test/resource/actiTimeCommonData.properties", "browser");
		String url = pUtils.getPropertyData("PROPFILE_PATH", "url");
		if(browserName.equals("chrome"))
		{
			System.setProperty("CHROME_KEY","CHROME_PATH");
			driver = new ChromeDriver();
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("FIREFOX_KEY","FIREFOX_PATH");
			driver = new FirefoxDriver();
			
		}
		else
		{
			throw new SessionNotCreatedException("browser is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait("IMP_TIME", TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@BeforeMethod
	public void configBM()
	{
		LoginPage loginPage = new LoginPage(driver);
		
		String userNAme = pUtils.getPropertyData("./src/test/resource/actiTimeCommonData.properties", "username");
		String password = pUtils.getPropertyData("./src/test/resource/actiTimeCommonData.properties", "password");
		System.out.println(userNAme);
		System.out.println(password);
		
		loginPage.login(userNAme , password);

	}
	@AfterMethod
	public void configAM()
	{
		HomePage homepage = new HomePage(driver);
		homepage.logout();
	}
	@AfterClass
	public void configAC()
	{
		//close the browser
		driver.quit();
	}
	@AfterTest
	public void configAT()
	{
		// close all the parallel connection
	}
	@AfterSuite
	public void configAS()
	{
		//close database connection
	}
}
