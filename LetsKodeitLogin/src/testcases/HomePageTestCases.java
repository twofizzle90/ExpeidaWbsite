package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePageFactory;

public class HomePageTestCases {
	private WebDriver driver;
	private String baseUrl;
	HomePageFactory searchpage;
	
	ExtentReports report;
	ExtentTest test;
	
	
	
	
	@BeforeTest
 	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/Users/tofazzalhossain90/Seleniumfiles/browserDriver/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://www.letskodeit.com/";
		report = new ExtentReports("//Users//tofazzalhossain90/Desktop/april.html");
		test = report.startTest("Verify Login Page");
		
		//Maximize the browser's size
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		searchpage = new HomePageFactory(driver);
	}
		
	@Test
	public void logintoAccount() throws Exception {
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Browser Started...");
		Thread.sleep(7000);
		driver.findElement(By.id("comp-jgmoxws4")).click();
		//GoTo Login page
		searchpage.clickLoginPage();
		//enter id
		searchpage.enterEmail("test@email.com");
		test.log(LogStatus.INFO, "Enter email address");
		searchpage.EnterPassword("abcabc");
		test.log(LogStatus.INFO, "Enter password");
		searchpage.clickOnLogin();
		//Find if error messages exist 
		boolean result = driver.findElements(By.xpath("//a[contains(text(),'My Courses')]")).size() != 0;
		Assert.assertTrue(result);
		//System.out.println(result);
		test.log(LogStatus.PASS, "User looged into account");
				
			
		}
	@AfterTest
	public void tearDown() throws Exception{
		report.endTest(test);
		report.flush();
		//driver.quit();
		
		
	}

}
	

