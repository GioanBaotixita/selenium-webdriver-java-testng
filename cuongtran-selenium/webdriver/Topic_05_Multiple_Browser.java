package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Multiple_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

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
		
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("");
	}

	@Test
	public void TC_01_Chrome() {
		// setting OS hiểu dc geckodrive -> giao tiếp vs Browser
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
				
		driver.get("https://www.facebook.com/");
		driver.quit();
		
	}

	@Test
	public void TC_02_Firefox() {
		// setting OS hiểu dc geckodrive -> giao tiếp vs Browser
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("https://www.facebook.com/");
		driver.quit();
		
	}

	@Test
	public void TC_03_Edge_Chromium() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\msedgedriver.exe");
		driver = new msEdgeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.quit();
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}