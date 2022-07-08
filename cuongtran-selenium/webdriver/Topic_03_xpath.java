package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




public class Topic_03_xpath {
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
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// Hàm này sẽ áp dụng cho việc tìm element (findElement/findElements)
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("");
	}

	@Test
	public void TC_01() {
		// tìm element số it		
		driver.findElement(By.id(""));
		
		//tìm element số nhìu : trả về 1 hoặc >1
		driver.findElements(By.id(""));
		
		//thao tác (action) : click/type/select/hover/...
		  // thao tac trực tiêp, ko khai báo biến, dùng 1 lần ko dùng lại element này
		driver.findElement(By.id("")).click();
		
		
		WebElement loginButton = driver.findElement(By.id(""));
		loginButton.click();
		loginButton.isDisplayed();
		
		//tìm element số nhìu : trả về 1 hoặc >1
				driver.findElements(By.id("")).size();
		// Thao tác lặp lại nhiều lần : vd check het check box tren UI
				List<WebElement> logincheckboxes = driver.findElements(By.id(""));	
		
		//Kiểm tra (verify) : get text/ getAtribute/getCss/...
		
		// Thao tác với Email texbox
		// Thao tác với Password textbox
		// Thao tác với Login
	}

	@Test
	public void TC_02() {
		
		
	}

	@Test
	public void TC_03() {
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}