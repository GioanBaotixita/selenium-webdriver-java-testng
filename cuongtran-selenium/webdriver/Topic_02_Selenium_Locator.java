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

public class Topic_02_Selenium_Locator {
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
		driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01() {
		// tìm element bằng id
		//<input type="text" class="inputtext _55r1 _6luy" name="email" id="email" data-testid="royal_email" placeholder="Email hoặc số điện thoại" autofocus="1" aria-label="Email hoặc số điện thoại">
		driver.findElement(By.id("email")).sendKeys("cuong");;
		
		// tìm element bằng class
				//<img class="fb_logo _8ilh img" src="https://static.xx.fbcdn.net/rsrc.php/y8/r/dF5SId3UHWd.svg" alt="Facebook">
				driver.findElement(By.className("fb_logo")).isDisplayed();
				
		// tìm elemant bằng tag name
				driver.findElement(By.tagName("a")); // luôn ra cái đầu tiên trong list mà nó tìm dc
				
		// tìm element bằng link text : lấy hết text
				driver.findElement(By.linkText("Tiếng Việt"));
				
       // tìm element bằng partial link text : chỉ cần láy 1 phần text -> độ chính xác ko cao
				driver.findElement(By.partialLinkText("Tiếng Việt"));
				driver.findElement(By.partialLinkText("Việt"));
				driver.findElement(By.partialLinkText("Tiếng"));
				
	   //CSS :  dùng chính
	         // CSS : cover id
				driver.findElement(By.cssSelector("input[id='email']")); // cách 1
				driver.findElement(By.cssSelector("input#email")); // cách 2 :  dấu # thay cho id
				driver.findElement(By.cssSelector("#email"));// cách 3 bỏ luon thẻ input
				
	         // CSS : cover class
				driver.findElement(By.cssSelector("img[class='fb_logo _8ilh img']"));// cách 1
				driver.findElement(By.cssSelector("img.fb_logo"));// cách 2
				driver.findElement(By.cssSelector(".fb_logo"));// cách 3
				
	         // CSS : cover name
				driver.findElement(By.cssSelector("input[name='email']"));
			 // CSS : cover tag name	
				driver.findElement(By.cssSelector("input[name='email']"));
				
			// CSS : cover link text -> CSS ko work với text -> dùng thuộc tính khác, ex : title hoạc onclick có chứa text
				driver.findElement(By.cssSelector("a[titles='Viet Nam']"));
				driver.findElement(By.cssSelector("a[onclick*='vi_VN']")); // *= là có chứa
			
			// CSS : cover partial link text ->	tương tự link text
			// Link với partial link chủ yếu dùng bằng xpath
				
				
	   //Xpath: dùng chính
			// xpath : id
				driver.findElement(By.xpath("//input[@id='email']"));
			// xpath : class
				driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
				driver.findElement(By.xpath("//img[contains(@class,'fb_logo')]"));
				driver.findElement(By.xpath("//img[starts-with(@class,'fb_logo')]"));
			// xpath : name
				driver.findElement(By.xpath("//input[@name='email']"));
			// tag name
				driver.findElement(By.xpath("//a"));
			// xpath : link text
				driver.findElement(By.xpath("//a[text()='Tiếng Việt']"));
			// xpath : partial link text
				driver.findElement(By.xpath("//a[contains(text(),'Tiếng Việt')]"));
				driver.findElement(By.xpath("//a[contains(text()='Tiếng')]"));
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