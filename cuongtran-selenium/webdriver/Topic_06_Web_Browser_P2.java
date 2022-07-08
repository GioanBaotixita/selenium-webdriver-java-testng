package webdriver;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Browser_P2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	public void sleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
		//Chạy với Chrome
		////đường dẫn tuyệt đối
		//System.setProperty("webdriver.gecko.driver", "F:\\Automation Testing\\Autonation_Software Support\\2 - Selenium Web Driver\\browserDriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		
		//Chạy với firefox
	    ////đường dẫn tuyệt đối
		//System.setProperty("webdriver.gecko.driver", "F:\\Automation Testing\\Autonation_Software Support\\2 - Selenium Web Driver\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Verify_Url() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@Title='My Account']")).click();
		sleepInsecond(3);
		String loginPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl,"http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.findElement(By.xpath("//a[@Title='Create an Account']")).click();
		sleepInsecond(3);
		String createAccountPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(createAccountPageUrl,"http://live.techpanda.org/index.php/customer/account/create/");
		
		
	}

	@Test
	public void TC_02_Verify_Title() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@Title='My Account']")).click();
		sleepInsecond(3);
		String loginTitle=driver.getTitle();
		Assert.assertEquals(loginTitle,"Customer Login");
		
		driver.findElement(By.xpath("//a[@Title='Create an Account']")).click();
		sleepInsecond(3);
		String createAccountTitle = driver.getTitle();
		Assert.assertEquals(createAccountTitle,"Create New Customer Account");
		
	}

	@Test
	public void TC_03_Navigate_function() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@Title='My Account']")).click();
		sleepInsecond(3);
		driver.findElement(By.xpath("//a[@Title='Create an Account']")).click();
		sleepInsecond(3);
		String createAccountPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(createAccountPageUrl,"http://live.techpanda.org/index.php/customer/account/create/");
		
		driver.navigate().back();
		String loginPageUrl=driver.getCurrentUrl();
		Assert.assertEquals(loginPageUrl,"http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.navigate().forward();
		String createAccountTitle = driver.getTitle();
		Assert.assertEquals(createAccountTitle,"Create New Customer Account");
		
		
	}
	
	@Test
	public void TC_04_Get_PageSource_Code() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div[@class='footer']//a[@Title='My Account']")).click();
		sleepInsecond(3);
		String loginPageSource = driver.getPageSource();
		Assert.assertTrue(loginPageSource.contains("Login or Create an Account"));
		
		driver.findElement(By.xpath("//a[@Title='Create an Account']")).click();
		sleepInsecond(3);
		String createAccountPageSource = driver.getPageSource();
		Assert.assertTrue(createAccountPageSource.contains("Create an Account"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}