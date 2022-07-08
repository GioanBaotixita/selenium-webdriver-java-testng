package webdriver;

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

public class Topic_00_PTC_Test {
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
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}

	@Test
	public void TC_01_Login_With_WrongEmail_Or_WrongPassword() {
		driver.get("https://positivethinking.tech/");
		sleepInsecond(3);
		
		driver.findElement(By.id("txtEmail")).sendKeys("invalid email");
		driver.findElement(By.id("txtPassword")).sendKeys("invalid password");
		driver.findElement(By.id("btnLogin")).click();
		sleepInsecond(3);
		
		driver.findElement(By.id("lblEmailErr")).getText();
		Assert.assertEquals(driver.findElement(By.id("lblEmailErr")).getText(),"The inputted email or password is not correct.");
		
		Assert.assertEquals(driver.findElement(By.id("lblPasswordErr")).getText(),"The inputted email or password is not correct.");		
		
	}

	@Test
	public void TC_02_Login_Sucessful() {
		driver.get("https://positivethinking.tech/");
		sleepInsecond(3);
		
		driver.findElement(By.id("txtEmail")).sendKeys("valid email");
		driver.findElement(By.id("txtPassword")).sendKeys("valid password");
		driver.findElement(By.id("btnLogin")).click();
		sleepInsecond(3);
		
		Assert.assertEquals(driver.findElement(By.id("lblLoggedinSuccessfully")).getText(),"You have logged-in successfully!");
		
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}