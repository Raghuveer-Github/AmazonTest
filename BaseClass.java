package GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import ObjectRepository.LoginPage;
import ObjectRepository.SignOut;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass{

	public PropertyFileUtility plib = new PropertyFileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib = new JavaUtility();
	
	public WebDriver driver=null;
	public static WebDriver sdriver;
	
	@BeforeClass
	public void connectToDatabase() throws Throwable{
		
		//dblib.connectToDataBase();
		Reporter.log("The website used was DemoQA for this test");
	}
	
	@BeforeTest
	public void launchtheBrowser() throws Throwable{
		
		String BROWSER = plib.readDataFromPropertyFile("browser");
		String URL= plib.readDataFromPropertyFile("url");
		
		//create run time polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else
		{
			System.out.println("invalid browser");
		}
		
		sdriver=driver;
//		wlib.moveToLaptopScreen(driver);
		wlib.moveToLeftMonitor(driver);
//		wlib.moveToRightMonitor(driver);
		wlib.maximizeWindow(driver);
		wlib.WaitForPageLoad(driver);
		driver.get(URL);
		Reporter.log("...browser launch successfully...",true);
	}
	
	@BeforeMethod
	public void login() throws Throwable{
		
		String USERNAME = plib.readDataFromPropertyFile("username");
		String PASSWORD = plib.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.ContinueShopping();
		lp.helloSignIn();
		lp.signIn();
		lp.EnterMobileNumberORemailTxt(USERNAME);
		lp.ClickonContinueBTN();
		lp.EnterPasswordTxt(PASSWORD);
		lp.ClickonSignInBTN();
		
		
	}
	
	@AfterMethod
	public void SignOut() 
	{
		SignOut so= new SignOut(driver);
		so.MouseHoverToProfileLogo();
		so.ClickOnSignOutLink();
		Reporter.log("...Sign Out successfully...");
		
	}
	
//	@AfterTest
//	public void closebrowser()
//	{
//		driver.quit();
//		Reporter.log("...browser closed successfully...",true);
//		
//	}
//	/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button
	@AfterSuite
	public void closedb()
	{
		//dblib.closeDB();
		Reporter.log("...database closed successfully...",true);
		
	}
}
