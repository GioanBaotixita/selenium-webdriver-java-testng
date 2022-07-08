package webdriver;

import static org.testng.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_xpath_baitap {
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
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_Register_With_Empty_Data() {
		// mở app ra
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		//kiểm tra các message lỗi
		  //lấy cái text
		//driver.findElement(By.id("txtFirstname-error")).getText();
		  //kiểm tra 1 dk trả về đúng
		//Assert.assertTrue(true);
		  //kiểm tra 1 dk trả về sai
		//Assert.assertFalse(true);
		
		  //kiểm tra 1 dk trả về bằng với dk có sẳn
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
		
		//driver.close();
		
		}

	@Test
	public void TC_02_Register_With_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Tran Cuong");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0908740094");
		driver.findElement(By.id("txtEmail")).sendKeys("Tran@Cuong@");
		driver.findElement(By.id("txtCEmail")).sendKeys("Tran@Cuong@");
		
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		
		//driver.close();
		
	}

	@Test
	public void TC_03_Register_With_Incorrect_Confirm_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Tran Cuong");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0908740094");
		driver.findElement(By.id("txtEmail")).sendKeys("TranCuong@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Cuong@gmail.com");
		
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
		
		//driver.close();
		
	}
	
	@Test
	public void TC_04_Register_With_Password_Less_Than_6Characters() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Tran Cuong");
		driver.findElement(By.id("txtPassword")).sendKeys("12345");
		driver.findElement(By.id("txtCPassword")).sendKeys("12345");
		driver.findElement(By.id("txtPhone")).sendKeys("0908740094");
		driver.findElement(By.id("txtEmail")).sendKeys("TranCuong@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Cuong@gmail.com");
		
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		
	}
	
	@Test
	public void TC_05_Register_With_Icorrect_Confirm_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Tran Cuong");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123465");
		driver.findElement(By.id("txtPhone")).sendKeys("0908740094");
		driver.findElement(By.id("txtEmail")).sendKeys("TranCuong@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Cuong@gmail.com");
		
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
		
	}
	
	@Test
	public void TC_06_Register_With_Invalid_Phone_Number() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("Tran Cuong");
		driver.findElement(By.id("txtPassword")).sendKeys("123456");
		driver.findElement(By.id("txtCPassword")).sendKeys("123456");
		driver.findElement(By.id("txtPhone")).sendKeys("0908740094abc");
		driver.findElement(By.id("txtEmail")).sendKeys("TranCuong@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Cuong@gmail.com");
		
		driver.findElement(By.xpath("//button[@class='btn_pink_sm fs16']")).click();
		
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập con số");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}