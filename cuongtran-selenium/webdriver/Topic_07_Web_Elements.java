package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Web_Elements {
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
		driver.get("");
	}

	@Test
	public void TC_01() {
		// muốn thao tác được với element thì phải tìm dc element trước
		//sau đó áp dụng hành vi cho nó
		//1-tìm element
		//2-tìm với loại locator gì ? (id, name , class ...)
		//3-tương tác /kiểm tra nó
		
		//xóa dữ liệu trong nhưng filed cho phép nhập : textbox, text erea, editable dropdown
		//luon luon clear het dữ liêu truoc khi thao tac
		driver.findElement(By.name(" ")).clear();
		
		//nhập dữ liệu trong nhưng field cho phép nhập
		//cho phép nhập kiểu chuối
		//cũng cho phép nhập kiểu sendkey 1 phím tren bàn phím
		driver.findElement(By.name(" ")).sendKeys("dfdf");
		driver.findElement(By.name(" ")).sendKeys(Keys.ENTER);
		
		//hàm findElement có thể dùng lồng ghép với 1 hàm findElement khác -> tuy nhiên thực tế ko sử dụng
		// hàm findElement thuộc về webbrowser và cả webElement
		driver.findElement(By.name(" ")).findElement(By.className(projectPath));
		
		//get những giá trị mà ko thể get tren UI dc, vi du label của search field
		//Attribute cuả nó thường là  placeholder , aria-label
		driver.findElement(By.name(" ")).getAttribute("placeholder");
		
		//GUI: verify font/size/color/pixel ...
		//vd muốn verify button login có màu gì, có giống với expected ko
		// để check actual value css tren firefox, mở dev tool vào tab Rules
		driver.findElement(By.name(" ")).getCssValue("background-color");
		//-> hàm trả về rgb(149, 246, 6) : đây là màu của background 
		driver.findElement(By.name(" ")).getCssValue("font-size");
		//-> hàm trả về 13px : đây là font size
		
		// các hàm ko sử dụng
		driver.findElement(By.name(" ")).getLocation();
		driver.findElement(By.name(" ")).getRect();
		driver.findElement(By.name(" ")).getSize();
		
		//sẽ học trong bài framework : attach screenshot to Report HTML
		driver.findElement(By.name(" ")).getScreenshotAs(null);
		
		// get thẻ của element : div , a ....
		// sử dụng trong trường hợp output cua element này là input cua element khác:  tuy nhien tình huống này cũng rất it khi xảy ra
		driver.findElement(By.name(" ")).getTagName();
		driver.findElement(By.xpath("//[@id='abc']"));
		
		//lấy het các test của element, bao gồm sub element
		//lấy ra text của element hiện tài và  text của element con bên trong
		driver.findElement(By.name(" ")).getText();
		//trường hợp get nhìu text trong sub element dùng để check tương đối
		String AText = driver.findElement(By.cssSelector("abc")).getText();
		Assert.assertTrue(Atext.contains("text1"));
		Assert.assertTrue(Atext.contains("text2"));
		Assert.assertTrue(Atext.contains("text3"));
		
		//mong muốn 1 element hiễn thị hoạc ko hiển thị, trả ve boolean
		//ap dung cho tất cả các loại elelment :  textbox, textarea, dropdown, radio ...
		// dc dùng kèm với ham assertTrue, assertFalse
		//Display : người dùng nhìn thấy dc, có kích thước cụ thể (rộng, cao), luôn luôn hiện thị mà ko cần có thao tác để enable nó lên
		driver.findElement(By.name(" ")).isDisplayed();
		
		//mong muốn 1 element có thể thao dc dc lên hoặc ko
		//ap dụng cho tất cả loại element
		// enable : thao tác được 
		//dung kèm với ham assertTrue, assertFalse để check nó la enable hay disable
		driver.findElement(By.name(" ")).isEnabled();
		
		//mong muốn 1 element đã dc chọn hay chưa
		//dc áp dụng cho 1 vài loại element : checkbox, radio button, dropdown(default)
		// chọn rồi tra ve true, chua chọn trả về false
		driver.findElement(By.name(" ")).isSelected();
		
		
		//click vào 1 element: button, link,check box, radio, hình... những loại nào cho phép click
		driver.findElement(By.name(" ")).click();
		
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