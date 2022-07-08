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

@Test
public class Topic_07_Web_Element2 {
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

	public void TC_01_Verify_component_displayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInsecond(3);
		
		WebElement radioAreUnder18=driver.findElement(By.xpath("//input[@id='under_18']"));
		if(radioAreUnder18.isDisplayed()) {
			radioAreUnder18.click();
			System.out.println("Radio Age 18 is displayed");
		}else {
			System.out.println("Radio Age 18 is not displayed");
		}
		
		
		WebElement textBoxEmail=driver.findElement(By.xpath("//input[@id='mail']"));
		if(textBoxEmail.isDisplayed()) {
			textBoxEmail.sendKeys("Automation Testing");
			System.out.println("Email textbox is displayed");
		}else {
			System.out.println("Email textbox is not displayed");
		}
		
		
		WebElement textBoxEdu=driver.findElement(By.cssSelector("#edu"));
		if(textBoxEdu.isDisplayed()) {
			textBoxEdu.sendKeys("Automation Testing");
			System.out.println("Education textbox is displayed");
		}else {
			System.out.println("Education textbox is not displayed");
		}
	
		
		
		
	}

	public void TC_02_Verify_component_enable_disable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInsecond(3);
		
		WebElement textBoxEmail=driver.findElement(By.xpath("//input[@id='mail']"));
		if(textBoxEmail.isEnabled()) {			
			System.out.println("Texbox Email is Enable");
		}else {
			System.out.println("Texbox Email is Disable");
		}
				
		
		WebElement radioAreUnder18=driver.findElement(By.xpath("//input[@id='under_18']"));
		if(radioAreUnder18.isEnabled()) {			
			System.out.println("Radio Are Under 18 is Enable");
		}else {
			System.out.println("Radio Are Under 18 is Disable");
		}
		
		WebElement textBoxEdu=driver.findElement(By.cssSelector("#edu"));
		if(textBoxEdu.isEnabled()) {			
			System.out.println("Texbox Education is Enable");
		}else {
			System.out.println("Texbox Education is Disable");
		}
		
		WebElement jobRole2=driver.findElement(By.cssSelector("#job2"));
		if(jobRole2.isEnabled()) {			
			System.out.println("Texbox Email is Enable");
		}else {
			System.out.println("Texbox Email is Disable");
		}
		
		WebElement jobRole1=driver.findElement(By.cssSelector("#job1"));
		if(jobRole1.isEnabled()) {			
			System.out.println("Job Role 01 is Enable");
		}else {
			System.out.println("Job Role 01 is Disable");
		}
		
		WebElement interestsDevelopmentCheckbox=driver.findElement(By.cssSelector("#development"));
		if(interestsDevelopmentCheckbox.isEnabled()) {			
			System.out.println("Interests Development Checkbox is Enable");
		}else {
			System.out.println("Interests Development Checkbox is Disable");
		}
		
		//cách khác dùng hàm Assert
		WebElement slider01=driver.findElement(By.cssSelector("#slider-1"));
		Assert.assertTrue(slider01.isEnabled());
		
		//------------------------verify disable
		WebElement textBoxPassword=driver.findElement(By.cssSelector("#disable_password"));
		if(textBoxPassword.isEnabled()) {			
			System.out.println("Slider 01 is Enable");
		}else {
			System.out.println("Slider 01 is Disable");
		}
		
		WebElement radioButtonAge=driver.findElement(By.cssSelector("#radio-disabled"));
		if(radioButtonAge.isEnabled()) {			
			System.out.println("Radio Button Age is Enable");
		}else {
			System.out.println("Radio Button Age is Disable");
		}
		
		WebElement textAreaBio=driver.findElement(By.cssSelector("#bio"));
		if(textAreaBio.isEnabled()) {			
			System.out.println("Text Area Bio is Enable");
		}else {
			System.out.println("Text Area Bio is Disable");
		}
		
		WebElement jobRole03=driver.findElement(By.cssSelector("#job3"));
		if(jobRole03.isEnabled()) {			
			System.out.println("Job Role 03 is Enable");
		}else {
			System.out.println("Job Role 03 is Disable");
		}
		
		//cách khác dùng hàm Assert
		WebElement interestsCheckBoxDisable=driver.findElement(By.cssSelector("#check-disbaled"));
		Assert.assertFalse(interestsCheckBoxDisable.isEnabled());
		
		
		
		
		//WebElement checkboxJava=driver.findElement(By.xpath("//input[@id='java']"));
		//checkboxJava.click();
		//sleepInsecond(3);
		//checkboxJava.isSelected();
		
	}

	public void TC_03_Verify_component_Selected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInsecond(3);
		
		WebElement radioAreUnder18=driver.findElement(By.xpath("//input[@id='under_18']"));
		radioAreUnder18.click();
		if(radioAreUnder18.isSelected()) {			
			System.out.println("Radio  Are Under 18 is selected");
		}else {
			System.out.println("Radio  Are Under 18 is de-selected");
		}
		sleepInsecond(3);
		
		WebElement checkBoxLanguageJava=driver.findElement(By.cssSelector("#java"));
		checkBoxLanguageJava.click();
		if(checkBoxLanguageJava.isSelected()) {			
			System.out.println("Check Box Language Java is selected");
		}else {
			System.out.println("Check Box Language Java is de-selected");
		}
		sleepInsecond(3);
		
		checkBoxLanguageJava.click();
		if(checkBoxLanguageJava.isSelected()) {			
			System.out.println("Check Box Language Java is selected");
		}else {
			System.out.println("Check Box Language Java is de-selected");
		}
		
		
	}
	
	public void TC_04_Register_function_at_MailChimp() {
		driver.get("https://login.mailchimp.com/signup/");
		sleepInsecond(3);
		
		WebElement textBoxEmail=driver.findElement(By.cssSelector("#email"));
		WebElement textBoxUserName=driver.findElement(By.xpath("//input[@name='username']"));
		
		textBoxEmail.sendKeys("cuongtu@saigonstyle.com.vn");
		textBoxUserName.sendKeys("Cuong Tran");
		
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}