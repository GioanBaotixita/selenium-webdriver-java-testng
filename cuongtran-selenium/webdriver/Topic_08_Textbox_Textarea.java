package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Textbox_Textarea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAdressRandom, loginUrl, userID, userPass;
	// phần biến cho input thông tin khi tạo new customer
	String customerName, genderValueOutput, dateOfBirthInput,dateOfBirthOutput, addressInput, addressOutput, city, state, pinNumber, phoneNumber;
	
	JavascriptExecutor jsExecutor;

	public void sleepInsecond(long timeInsecond) {
		try {
			Thread.sleep(timeInsecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public static void main (String [] args) {
	// Random rand = new Random();
	// System.out.println(rand.nextInt(99999));
	// System.out.println(rand.nextInt(99999));
	// System.out.println(rand.nextInt(99999));
	// System.out.println(rand.nextInt(99999));
	// System.out.println(rand.nextInt(99999));
	// System.out.println(rand.nextInt(99999));
	// System.out.println(rand.nextInt(99999));
	// System.out.println(rand.nextInt(99999));
	// }

	public int generateRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(99999);
	}

	@BeforeClass
	public void beforeClass() {
		// Chạy với Chrome
		//// đường dẫn tuyệt đối
		// System.setProperty("webdriver.gecko.driver", "F:\\Automation
		// Testing\\Autonation_Software Support\\2 - Selenium Web
		// Driver\\browserDriver\\chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver", projectPath +
		// "\\browserDriver\\chromedriver.exe");
		// driver = new ChromeDriver();

		// Chạy với firefox
		//// đường dẫn tuyệt đối
		// System.setProperty("webdriver.gecko.driver", "F:\\Automation
		// Testing\\Autonation_Software Support\\2 - Selenium Web
		// Driver\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		//ép kiểu tường mình
		jsExecutor = (JavascriptExecutor) driver;

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		emailAdressRandom = "cuongtran" + generateRandomNumber() + "@hotmail.vn";

		driver.get("https://demo.guru99.com/v4/");
		loginUrl = driver.getCurrentUrl();

		// khởi tạo dữ liệu của phần create new customer
		customerName = "cuongtran";
		genderValueOutput = "male";
		dateOfBirthInput = "04/24/1986";
		dateOfBirthOutput = "1986-04-24";
		addressInput = "128 Le Van Duyet \nBinh Thanh";
		addressOutput = "128 Le Van Duyet Binh Thanh";
		city = "HCM";
		state = "Ppp";
		pinNumber = "123456";
		phoneNumber = "0908740094";
		
	}

	@Test
	public void TC_01_Register() {
		driver.get(loginUrl);
		sleepInsecond(3);

		driver.findElement(By.xpath("//a[text()='here']")).click();
		sleepInsecond(10);

		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(emailAdressRandom);
		sleepInsecond(2);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling ::td")).getText();
		userPass = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling ::td")).getText();

	}

	@Test
	public void TC_02_Login() {
		driver.get(loginUrl);
		sleepInsecond(3);

		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(userPass);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		sleepInsecond(3);

		// verify login successful
		Assert.assertEquals(driver.findElement(By.cssSelector("tr.heading3>td")).getText(), "Manger Id : " + userID);
	}

	@Test
	public void TC_03_Create_New_Customer() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		sleepInsecond(2);
		
		//input dữ liệu
		driver.findElement(By.name("name")).sendKeys(customerName);
		driver.findElement(By.xpath("//input[@value='m']")).click();
		
		//xữ lý date picker
		WebElement dateOfBirthTextbox = driver.findElement(By.name("dob"));
		jsExecutor.executeScript("arguments[0].removeAttribute('type')", dateOfBirthTextbox);
		dateOfBirthTextbox.sendKeys(dateOfBirthInput);
		
		driver.findElement(By.name("addr")).sendKeys(addressInput);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("pinno")).sendKeys(pinNumber);
		driver.findElement(By.name("telephoneno")).sendKeys(phoneNumber);
		driver.findElement(By.name("emailid")).sendKeys(emailAdressRandom);
		driver.findElement(By.name("password")).sendKeys(userPass);
		driver.findElement(By.name("sub")).click();
		sleepInsecond(2);
		
		//verify dữ liệu
		Assert.assertEquals(driver.findElement(By.cssSelector("p.heading3")).getText(), "Customer Registered Successfully!!!");
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerName);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), genderValueOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dateOfBirthOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), addressOutput);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pinNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phoneNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), emailAdressRandom);
		
		
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}
}